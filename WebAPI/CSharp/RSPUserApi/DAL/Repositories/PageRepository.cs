using DAL.Context;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Repositories
{
    public class PageRepository : Base.IRepository<Page>
    {
        private RSPDbContext db;
        public PageRepository()
        {
            this.db = new RSPDbContext();
        }
        public IEnumerable<Page> GetList()
        {
            var page = db.Pages.AsEnumerable<Page>();
            return page;
        }
        public Page Get(int Id)
        {
            var page = db.Pages.FirstOrDefault(p => p.ID == Id);
            return page;
        }
        public void Create(Page item)
        {
            db.Pages.Add(item);
            db.SaveChanges();
        }
        public void Update(Page item)
        {
            var page = db.Pages.FirstOrDefault(p => p.ID == item.ID);
            if (page != null)
            {
                page.Url = item.Url;
                page.SiteID = item.SiteID;
                page.FoundDateTime = item.FoundDateTime;
                page.LastScanDate = item.LastScanDate;
                db.Entry(page).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
            }
        }
        public void Delete(int Id)
        {
            var page = db.Pages.FirstOrDefault(p => p.ID == Id);
            if (page != null)
            {
                db.Pages.Remove(page);
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
