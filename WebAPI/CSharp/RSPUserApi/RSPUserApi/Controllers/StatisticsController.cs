using DAL.Repositories;
using DAL.Repositories.Base;
using Domain.Entities;
using RSPUserApi.Models.Request;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Results;

namespace RSPUserApi.Controllers
{
    [AllowAnonymous]
    public class StatisticsController : ApiController
    {
        //private IRepository<Person> _persons;
        private IRepository<Site> _sites;
        private IPersonPageRankRepository _personPageRanks;
        public StatisticsController()
        {
            //this._persons = new PersonRepository();
            this._sites = new SiteRepository();
            this._personPageRanks = new PersonPageRankRepository();
        }
        // GET: api/statistics/1
        [HttpGet]
        public IHttpActionResult GetCommonStatisticsForSite(int id)
        {           
            var pageIDs = _sites.Get(id).Pages.Select(p => p.ID);
            var personPageRanks = _personPageRanks
                                         .GetList()
                                         .Where(p => pageIDs.Contains(p.PageID))
                                         .ToList();
            var personPageRanksLite = personPageRanks.Select(p => new PersonPageRankLite { PersonID = p.PersonID, PersonName = p.Person.Name, Rank = p.Rank }).ToList();
            return Ok<List<PersonPageRankLite>>(personPageRanksLite);
        }
        // GET: api/statistics/
        [HttpPost]
        public IHttpActionResult GetDailyStatistics([FromBody] StatisticsRequest data)
        {
            var pageIDs = _sites.Get(data.SiteID).Pages.Where(p => data.From <= p.FoundDateTime && p.FoundDateTime <= data.To).Select(p => p.ID);
            var personPageRanks = _personPageRanks
                                         .GetList()
                                         .Where(p => pageIDs.Contains(p.PageID) && p.PersonID == data.PersonID)
                                         .ToList();
            var personPageRanksLite = personPageRanks.Select(p => new PersonPageRankLite { PersonID = p.PersonID, PersonName = p.Person.Name, Rank = p.Rank }).ToList();
            return Ok<List<PersonPageRankLite>>(personPageRanksLite);
        }
    }
}
