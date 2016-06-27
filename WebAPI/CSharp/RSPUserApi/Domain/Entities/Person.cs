using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    [Table("Persons")]
    public class Person
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }
        [Required, MaxLength(2048), Column(TypeName = "nvarchar")]
        public string Name { get; set; }
        public virtual ICollection<Keyword> Keywords { get; set; }
        public virtual ICollection<PersonPageRank> PersonPageRanks { get; set; }
    }
}
