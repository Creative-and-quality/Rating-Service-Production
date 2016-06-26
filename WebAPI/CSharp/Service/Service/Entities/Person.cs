using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using Newtonsoft.Json;

namespace Service.Entities
{
    [Serializable]
    [JsonObject]
    public class Person
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }
}