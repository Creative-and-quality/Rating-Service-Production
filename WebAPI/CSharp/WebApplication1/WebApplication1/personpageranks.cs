//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WebApplication1
{
    using System;
    using System.Collections.Generic;
    
    public partial class personpageranks
    {
        public int PersonID { get; set; }
        public int PageID { get; set; }
        public Nullable<int> Rank { get; set; }
    
        public virtual pages pages { get; set; }
        public virtual pesrons pesrons { get; set; }
    }
}
