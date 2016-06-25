using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Service.Entities;

namespace Service.Controllers
{
    public class KeywordController : ApiController
    {

        //It's fake!
        private List<Keyword> Fake = new List<Keyword>(); 
        // GET api/<controller>
        public IEnumerable<Keyword> Get()
        {
            return Fake;
        }

        // GET api/<controller>/5
        public Keyword Get(int id)
        {
            return Fake.FirstOrDefault(x=>x.Id==id);
        }

        // POST api/<controller>
        public void Post([FromBody]Keyword value)
        {
            Fake.Add(value);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
        }
    }
}
