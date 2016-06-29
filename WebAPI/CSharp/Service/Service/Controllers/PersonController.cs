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
            return new PersonRepository().GetList();
        }

        // GET api/<controller>/5
        public Person Get(int id)
        {
            return new PersonRepository().GetItem(id);
        }

        // POST api/<controller>
        public void Post([FromBody]Person value)
        {
            new PersonRepository().Update(value);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]Person value)
        {
            new PersonRepository().Update(value);
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
            new PersonRepository().Delete(id);
        }
    }
}
