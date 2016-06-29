using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Service.Entities;
using Service.Interfaces;

namespace Service.Context
{
    public class PersonRepository 
    {
        private static List<Person> Items = new List<Person>();


        public IEnumerable<Person> GetList()
        {
            return Items;
        }

        public Person GetItem(int id)
        {
            return Items.FirstOrDefault(x => x.Id == id);
        }
        public void Create(Person item)
        {
            item.Id = Items.Count;
            Items.Add(item);
        }

        public void Update(Person item)
        {
            var firstOrDefault = Items.FirstOrDefault(x => x.Id == item.Id);
            if (firstOrDefault != null)
                Items[firstOrDefault.Id] = item;
        }

        public void Delete(int id)
        {
            var firstOrDefault = Items.FirstOrDefault(x => x.Id == id);
            if (firstOrDefault != null)
                Items.Remove(firstOrDefault);
        }

        public void Save()
        {
        }

        public void Dispose()
        {
        }

        static PersonRepository()
        {
            Items.Add(new Person {Id = 0, Name = "Putin"});
        }

    }
}