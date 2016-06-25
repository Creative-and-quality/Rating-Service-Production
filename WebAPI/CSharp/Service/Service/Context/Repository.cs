using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Service.Entities;

namespace Service.Context
{
    public class Repository
    {
        private static Dictionary<int, Keyword> keywords = new Dictionary<int, Keyword>();
        private static Dictionary<int, Person> persons = new Dictionary<int, Person>();
        private static Dictionary<int, Site> sites = new Dictionary<int, Site>();

        public IEnumerable<Keyword> Keywords
        {
            get
            {
                return keywords.Values;
            }
        }
        public IEnumerable<Person> Persons
        {
            get
            {
                return persons.Values;
            }
        }
        public IEnumerable<Site> Sites
        {
            get
            {
                return sites.Values;
            }
        }

        public void Save(Keyword item)
        {
            keywords[item.Id] = item;
        }
        public void Save(Person item)
        {
            persons[item.Id] = item;
        }
        public void Save(Site item)
        {
            sites[item.Id] = item;
        }



        public void Delete(Keyword item)
        {
            if (keywords.ContainsKey(item.Id))
            {
                keywords.Remove(item.Id);
            }
        }
        public void Delete(Site item)
        {
            if (sites.ContainsKey(item.Id))
            {
                sites.Remove(item.Id);
            }
        }
        public void Delete(Person item)
        {
            if (persons.ContainsKey(item.Id))
            {
                persons.Remove(item.Id);
            }
        }

        public void Add(Keyword item)
        {
            item.Id = keywords.Select(p => p.Key).Max() + 1;
            Save(item);
        }
        public void Add(Site item)
        {
            item.Id = sites.Select(p => p.Key).Max() + 1;
            Save(item);
        }
        public void Add(Person item)
        {
            item.Id = persons.Select(p => p.Key).Max() + 1;
            Save(item);
        }

        static Repository()
        {
            persons.Add(0, new Person {Id = 0, Name = "Putin"});
            keywords.Add(0, new Keyword { Id = 0, Name = "Putin", PersonId = persons[0]});
            sites.Add(0, new Site {Id = 0, Name = "lenta.ru"});

        }
    }
}