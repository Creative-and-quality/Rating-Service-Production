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
            return new KeywordRepository().Keywords;
        }

        // GET api/<controller>/5
        public Keyword Get(int id)
        {
            return new KeywordRepository().Keywords.FirstOrDefault(item => item.Id == id);
        }

        // POST api/<controller>
        public void Post([FromBody]Keyword value)
        {
            new KeywordRepository().Add(value);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]Keyword value)
        {
            new KeywordRepository().Save(value);
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
            KeywordRepository keywordRepository = new KeywordRepository();
            Keyword item = keywordRepository.Keywords.FirstOrDefault(g => g.Id == id);
            if (item != null)
                keywordRepository.Delete(item);
        }

    }
}
