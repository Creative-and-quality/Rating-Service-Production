using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Service.Context;
using Service.Entities;

namespace Service.Controllers
{
    public class SiteController : ApiController
    {
        public IEnumerable<Site> Get()
        {
            return new SiteRepository().GetList();
        }

        // GET api/<controller>/5
        public Site Get(int id)
        {
            return new SiteRepository().GetItem(id);
        }

        // POST api/<controller>
        public void Post([FromBody]Site value)
        {
            new SiteRepository().Update(value);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]Site value)
        {
            new SiteRepository().Update(value);
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
            new SiteRepository().Delete(id);
        }
    }
}
