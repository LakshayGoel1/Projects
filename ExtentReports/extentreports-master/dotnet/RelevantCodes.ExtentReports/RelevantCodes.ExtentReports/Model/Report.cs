﻿using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Runtime.CompilerServices;

using RelevantCodes.ExtentReports.Config;
using RelevantCodes.ExtentReports.Utils;

namespace RelevantCodes.ExtentReports.Model
{
    public abstract class Report
    {
        private const string InternalWarning = "Close was called before test could end safely using EndTest.";

        private List<IReporter> _reporterList;
        private bool _terminated = false;

        internal LogStatus ReportStatus;

        protected Guid ReportId;

        internal string FilePath { get; set; }

        internal bool ReplaceExisting { get; set; }

        internal DisplayOrder DisplayOrder { get; set; }

        internal NetworkMode NetworkMode { get; set; }

        internal CultureInfo Culture { get; set; }

        internal DateTime StartTime;

        internal DateTime EndTime;

        internal Test Test { get; private set; }

        internal Dictionary<string, string> SystemInfo { get; set; }

        internal List<string> TestRunnerLogs { get; set; }

        internal string ProjectName { get; set; }

        internal string MongoDBObjectId { get; set; }

        protected void Attach(IReporter Reporter)
        {
            if (_reporterList == null)
            {
                _reporterList = new List<IReporter>();
            }
            
            _reporterList.Add(Reporter);
            Reporter.Start(this);
        }

        protected void Detach(IReporter Reporter)
        {
            Reporter.Stop();
            _reporterList.Remove(Reporter);
        }

        internal IDictionary<string, List<Test>> CategoryMap { get; private set; }

        internal IDictionary<string, List<Test>> ExceptionMap { get; private set; }

        [MethodImpl(MethodImplOptions.Synchronized)]
        protected void AddTest(Test Test)
        {
            EndTime = DateTime.Now;

            this.Test = Test;

            Test.PrepareFinalize();

            Test.CategoryList.ForEach(x =>
            {
                if (!CategoryMap.ContainsKey(x.Name))
                {
                    CategoryMap.Add(x.Name, new List<Test>() { Test });
                }
                else
                {
                    CategoryMap[x.Name].Add(Test);
                }
            });

            Test.ExceptionList.ForEach(x =>
            {
                var ex = ExceptionUtil.GetExceptionHeadline(x);

                if (!ExceptionMap.ContainsKey(ex))
                {
                    ExceptionMap.Add(ex, new List<Test>() { Test });
                }
                else
                {
                    ExceptionMap[ex].Add(Test);
                }
            });

            _reporterList.ForEach(x =>
            {
                x.AddTest(Test);
            });

            UpdateReportStatus(Test.Status);
        }

        internal List<ExtentTest> TestList { get; set; }

        protected virtual void Terminate()
        {
            if (TestList == null)
            {
                return;
            }

            TestList.ForEach(x =>
            {
                if (!x.GetTest().HasEnded)
                {
                    var ex = new ExtentTestInterruptedException(InternalWarning);

                    x.GetTest().InternalWarning = InternalWarning;
                    x.Log(LogStatus.Fail, ex);

                    AddTest(x.GetTest());
                }
            });

            Flush();

            _reporterList.ForEach(x => 
            {
                x.Stop();
            });

            _reporterList.Clear();

            _terminated = true;
        }

        protected virtual void Flush()
        {
            EndTime = DateTime.Now;

            if (_terminated)
            {
                throw new IOException("Unable to write source: Stream closed.");
            }

            _reporterList.ForEach(x => x.Flush());
        }

        internal Dictionary<string, string> ConfigurationMap { get; private set; }

        protected virtual void LoadConfig(Configuration Config)
        {
            var config = Config.Read();

            if (config != null) 
            {
                ConfigurationMap = config;
            }

            if (!ConfigurationMap.ContainsKey("dateFormat") || string.IsNullOrEmpty(ConfigurationMap["dateFormat"]))
            {
                ConfigurationMap["dateFormat"] = Globals.DateFormat;
            }

            if (!ConfigurationMap.ContainsKey("timeFormat") || string.IsNullOrEmpty(ConfigurationMap["timeFormat"]))
            {
                ConfigurationMap["timeFormat"] = Globals.TimeFormat;
            }

            if (!ConfigurationMap.ContainsKey("protocol") || string.IsNullOrEmpty(ConfigurationMap["protocol"]))
            {
                ConfigurationMap["protocol"] = Globals.Protocol;
            }
        }

        internal string RunTime
        {
            get
            {
                TimeSpan diff = DateTime.Now.Subtract(StartTime);

                return String.Format("{0}h {1}m {2}s+{3}ms", diff.Hours, diff.Minutes, diff.Seconds, diff.Milliseconds);
            }
        }

        private void UpdateReportStatus(LogStatus logStatus)
        {
            if (ReportStatus == LogStatus.Fatal) return;

            if (logStatus == LogStatus.Fatal)
            {
                ReportStatus = logStatus;
                return;
            }

            if (ReportStatus == LogStatus.Fail) return;

            if (logStatus == LogStatus.Fail)
            {
                ReportStatus = logStatus;
                return;
            }

            if (ReportStatus == LogStatus.Error) return;

            if (logStatus == LogStatus.Error)
            {
                ReportStatus = logStatus;
                return;
            }

            if (ReportStatus == LogStatus.Warning) return;

            if (logStatus == LogStatus.Warning)
            {
                ReportStatus = logStatus;
                return;
            }

            if (ReportStatus == LogStatus.Pass) return;

            if (logStatus == LogStatus.Pass)
            {
                ReportStatus = LogStatus.Pass;
                return;
            }

            if (ReportStatus == LogStatus.Skip) return;

            if (logStatus == LogStatus.Skip)
            {
                ReportStatus = LogStatus.Skip;
                return;
            }

            if (ReportStatus == LogStatus.Info) return;

            if (logStatus == LogStatus.Info)
            {
                ReportStatus = LogStatus.Info;
                return;
            }

            ReportStatus = LogStatus.Unknown;
        }

        public Report() 
        {
            ReportId = Guid.NewGuid();

            CategoryMap = new SortedDictionary<string, List<Test>>();
            ExceptionMap = new SortedDictionary<string, List<Test>>();
            StartTime = DateTime.Now;
            SystemInfo = new StandardSystemInfo().GetInfo();
            TestRunnerLogs = new List<string>();
        }
    }
}
