using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Http.Tracing;
using Service.Entities;
using Service.Interfaces;


namespace Service.Context
{
    public class KeywordRepository : IRepository<Keyword>, IDisposable
    {

        private static DbSet<Keyword> Items;

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
           item.Id = Items.Count();
           Items.Add(item);
           Save();
       }

        public void Update(Keyword item)
        {
            var firstOrDefault = Items.FirstOrDefault(x=>x.Id == item.Id);
            if (firstOrDefault != null)
            {
                Items.Attach(firstOrDefault);
                Save();
            }
        }

        public void Delete(int id)
        {
            var firstOrDefault = Items.FirstOrDefault(x => x.Id == id);
            if (firstOrDefault != null)
            {
                Items.Remove(firstOrDefault);
                Save();

            }
                
        }

        public  void Save()
        {
            ApiDbContext.Instance.SaveChanges();
        }

        public void Dispose()
        {
        }

        static KeywordRepository()
        {
            Items = ApiDbContext.Instance.Keywords;
        }
    }
}