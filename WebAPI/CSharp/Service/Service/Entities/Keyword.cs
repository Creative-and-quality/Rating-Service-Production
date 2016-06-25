using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Service.Entities
{
    public class Keyword
    {
        public int Id { get; set; }
        public int Name { get; set; }
        public Person PersonId { get; set; }

    }
}