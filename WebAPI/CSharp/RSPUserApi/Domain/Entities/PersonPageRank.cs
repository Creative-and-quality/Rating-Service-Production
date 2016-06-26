using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    [Table("PersonPageRanks")]
    public class PersonPageRank
    {
        [Key, Column(Order = 1)]
        public int PageID { get; set; }
        [ForeignKey("PageID")]
        public virtual Page Page { get; set; }
        [Key, Column (Order = 2)]
        public int PersonID { get; set; }
        [ForeignKey("PersonID")]
        public virtual Person Person { get; set; }
        [Required]
        public int Rank { get; set; }
    }
}
