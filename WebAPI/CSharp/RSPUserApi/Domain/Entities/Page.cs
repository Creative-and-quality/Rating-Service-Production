using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Domain.Entities
{
    [Table("Pages")]
    public class Page
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }
        [Required, MaxLength(2048), Column(TypeName = "nvarchar")]
        public string Url { get; set; }
        [Required]
        public int SiteID { get; set; }
        [Required]
        public DateTime FoundDateTime { get; set; }
        [Required]
        public DateTime LastScanDate { get; set; }
        [ForeignKey("SiteID")]
        public virtual Site Site { get; set; }
    }
}
