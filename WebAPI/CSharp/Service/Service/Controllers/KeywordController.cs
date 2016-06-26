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
    public class KeywordController : ApiController
    {
        public IEnumerable<Keyword> Get()
        {
            return new KeywordRepository().GetList();
        }

        // GET api/<controller>/5
        public Keyword Get(int id)
        {
            return new KeywordRepository().GetItem(id);
        }

        // POST api/<controller>
        public void Post([FromBody]Keyword value)
        {
            new KeywordRepository().Create(value);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]Keyword value)
        {
            new KeywordRepository().Update(value);
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
            new KeywordRepository().Delete(id);
        }

    }
}
