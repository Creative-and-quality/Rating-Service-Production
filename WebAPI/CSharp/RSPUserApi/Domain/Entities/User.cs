using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    [Table("Users")]
    public class User
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }
        [Required, MaxLength(200), Column(TypeName = "nvarchar")]
        public string Name { get; set; }
        [Required, MaxLength(100), Column(TypeName = "nvarchar")]
        public string Login { get; set; }
        [Required, MaxLength(100), Column(TypeName = "nvarchar")]
        public string Password { get; set; }
        [DefaultValue(false)]
        public bool IsAdmin { get; set; }
    }
}
