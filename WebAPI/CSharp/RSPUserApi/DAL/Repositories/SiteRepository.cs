using DAL.Context;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace DAL.Repositories
{
    public class SiteRepository : Base.IRepository<Site>
    {
        private RSPDbContext db;
        public SiteRepository()
        {
            this.db = new RSPDbContext();
        }
        public IEnumerable<Site> GetList()
        {
            var site = db.Sites.AsEnumerable<Site>();
            return site;
        }
        public Site Get(int Id)
        {
            var site = db.Sites.Include(s => s.Pages).FirstOrDefault(s => s.ID == Id);
            return site;
        }
        public void Create(Site item)
        {
            db.Sites.Add(item);
            db.SaveChanges();
        }
        public void Update(Site item)
        {
            var site = db.Sites.FirstOrDefault(s => s.ID == item.ID);
            if (site != null)
            {
                site.Name = item.Name;
                db.Entry(site).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
            }
        }
        public void Delete(int Id)
        {
            var site = db.Sites.FirstOrDefault(s => s.ID == Id);
            if (site != null)
            {
                db.Sites.Remove(site);
                db.SaveChanges();
            }
        }
        private bool disposed = false;
        public virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                    db.Dispose();
            }
            this.disposed = true;
        }
        public void Dispose()
        {
            this.Dispose(true);
            GC.SuppressFinalize(this);
        }
    }
}
