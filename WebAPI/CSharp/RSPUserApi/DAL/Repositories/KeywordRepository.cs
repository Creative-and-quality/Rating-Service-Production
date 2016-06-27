using DAL.Context;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Repositories
{
    public class KeywordRepository : Base.IRepository<Keyword>
    {
        private RSPDbContext db;
        public KeywordRepository()
        {
            this.db = new RSPDbContext();
        }
        public IEnumerable<Keyword> GetList()
        {
            var keywords = db.Keywords.AsEnumerable<Keyword>();
            return keywords;
        }
        public Keyword Get(int Id)
        {
            var keyword = db.Keywords.FirstOrDefault(k => k.ID == Id);
            return keyword;
        }
        public void Create(Keyword item)
        {
            db.Keywords.Add(item);
            db.SaveChanges();
        }
        public void Update(Keyword item)
        {
            var keyword = db.Keywords.FirstOrDefault(k => k.ID == item.ID);
            if (keyword != null)
            {
                keyword.Name = item.Name;
                keyword.PersonID = item.PersonID;
                db.Entry(keyword).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
            }
        }
        public void Delete(int Id)
        {
            var user = db.Users.FirstOrDefault(k => k.ID == Id);
            if (user != null)
            {
                db.Users.Remove(user);
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
