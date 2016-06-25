using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Service.Entities
{
    //[Table("Persons")]
    public class Person
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }
}