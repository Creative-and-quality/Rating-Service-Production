using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;

namespace Service.Entities
{
    [Serializable]
    [JsonObject]
    public class Keyword
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public Person PersonId { get; set; }

    }
}