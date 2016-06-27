using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http.Tracing;
using Service.Entities;
using Service.Interfaces;

namespace Service.Context
{
    public class KeywordRepository : IRepository<Keyword>, IDisposable
    {

        private static List<Keyword> Items = new List<Keyword>(); 



        public IEnumerable<Keyword> GetList()
        {
            return Items;
        }

        public Keyword GetItem(int id)
        {
            return Items.FirstOrDefault(x => x.Id == id);
        }
       public void Create(Keyword item)
       {
           item.Id = Items.Count;
           Items.Add(item);
       }

        public void Update(Keyword item)
        {
            var firstOrDefault = Items.FirstOrDefault(x=>x.Id == item.Id);
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

        static KeywordRepository()
        {
            Items.Add(new Keyword { Id = 0, Name = "Putin", PersonId = new Entities.Person { Id = 0, Name = "Putin" } });
        }
    }
}