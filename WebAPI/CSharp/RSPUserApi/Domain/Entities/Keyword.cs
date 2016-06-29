using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    [Table("Keywords")]
    public class Keyword
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }
        [Required, MaxLength(2048), Column(TypeName = "nvarchar")]
        public string Name { get; set; }
        public int PersonID { get; set; }
        [ForeignKey("PersonID")]
        public virtual Person Person { get; set; }
    }
}
