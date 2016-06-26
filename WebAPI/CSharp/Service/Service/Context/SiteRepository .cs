using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Service.Entities;
using Service.Interfaces;

namespace Service.Context
{
    public class SiteRepository 
    {
        private static List<Site> Items = new List<Site>();


        public IEnumerable<Site> GetList()
        {
            return Items;
        }

        public Site GetItem(int id)
        {
            return Items.FirstOrDefault(x => x.Id == id);
        }
        public void Create(Site item)
        {
            item.Id = Items.Count;
            Items.Add(item);
        }

        public void Update(Site item)
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

        static SiteRepository()
        {
            Items.Add(new Site {Id = 0, Name = "lenta.ru"});
        }

    }
}