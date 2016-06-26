using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Service.Context;
using Service.Entities;
using Person = Service.Entities.Person;

namespace Service.Controllers
{
    public class PersonController : ApiController
    {
        public IEnumerable<Person> Get()
        {
            return new KeywordRepository().Persons;
        }

        // GET api/<controller>/5
        public Person Get(int id)
        {
            return new KeywordRepository().Persons.FirstOrDefault(item => item.Id == id);
        }

        // POST api/<controller>
        public void Post([FromBody]Person value)
        {
            new KeywordRepository().Add(value);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]Person value)
        {
            new KeywordRepository().Save(value);
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
            KeywordRepository keywordRepository = new KeywordRepository();
            Person item = keywordRepository.Persons.FirstOrDefault(g => g.Id == id);
            if (item != null)
                keywordRepository.Delete(item);
        }
    }
}
