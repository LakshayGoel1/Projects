﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace RelevantCodes.ExtentReports.Properties {
    using System;
    
    
    /// <summary>
    ///   A strongly-typed resource class, for looking up localized strings, etc.
    /// </summary>
    // This class was auto-generated by the StronglyTypedResourceBuilder
    // class via a tool like ResGen or Visual Studio.
    // To add or remove a member, edit your .ResX file then rerun ResGen
    // with the /str option, or rebuild your VS project.
    [global::System.CodeDom.Compiler.GeneratedCodeAttribute("System.Resources.Tools.StronglyTypedResourceBuilder", "4.0.0.0")]
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
    [global::System.Runtime.CompilerServices.CompilerGeneratedAttribute()]
    internal class Resources {
        
        private static global::System.Resources.ResourceManager resourceMan;
        
        private static global::System.Globalization.CultureInfo resourceCulture;
        
        [global::System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1811:AvoidUncalledPrivateCode")]
        internal Resources() {
        }
        
        /// <summary>
        ///   Returns the cached ResourceManager instance used by this class.
        /// </summary>
        [global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced)]
        internal static global::System.Resources.ResourceManager ResourceManager {
            get {
                if (object.ReferenceEquals(resourceMan, null)) {
                    global::System.Resources.ResourceManager temp = new global::System.Resources.ResourceManager("RelevantCodes.ExtentReports.Properties.Resources", typeof(Resources).Assembly);
                    resourceMan = temp;
                }
                return resourceMan;
            }
        }
        
        /// <summary>
        ///   Overrides the current thread's CurrentUICulture property for all
        ///   resource lookups using this strongly typed resource class.
        /// </summary>
        [global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced)]
        internal static global::System.Globalization.CultureInfo Culture {
            get {
                return resourceCulture;
            }
            set {
                resourceCulture = value;
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
        ///&lt;extentreports&gt;
        ///  &lt;configuration&gt;
        ///    &lt;!-- report theme --&gt;
        ///    &lt;!-- standard, dark --&gt;
        ///    &lt;theme&gt;standard&lt;/theme&gt;
        ///
        ///    &lt;!-- document encoding --&gt;
        ///    &lt;!-- defaults to UTF-8 --&gt;
        ///    &lt;encoding&gt;UTF-8&lt;/encoding&gt;
        ///
        ///    &lt;!-- protocol for script and stylesheets --&gt;
        ///    &lt;!-- defaults to https --&gt;
        ///    &lt;protocol&gt;https&lt;/protocol&gt;
        ///
        ///    &lt;!-- title of the document --&gt;
        ///    &lt;documentTitle&gt;ExtentReports 2.0&lt;/documentTitle&gt;
        ///
        ///    &lt;!-- report name - displayed at top-nav [rest of string was truncated]&quot;;.
        /// </summary>
        internal static string extent_config {
            get {
                return ResourceManager.GetString("extent_config", resourceCulture);
            }
        }
    }
}