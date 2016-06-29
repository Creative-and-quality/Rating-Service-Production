using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace RSPUserApi.Models.Request
{
    public class PersonPageRankLite
    {
        public int PersonID { get; set; }
        public string PersonName { get; set; }
        public int Rank { get; set; }
    }
    public class StatisticsRequest
    {
        public int SiteID { get; set; }
        public int PersonID { get; set; }
        public DateTime From { get; set; }
        public DateTime To { get; set; }
    }
    public class StatisticsResponse
    {
        public IEnumerable<PersonPageRankLite> Data { get; set; }
    }
}