using DAL.Context;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace DAL.Repositories
{
    public class PersonPageRankRepository : Base.IPageRankRepository
    {
        private RSPDbContext db;
        public PersonPageRankRepository()
        {
            this.db = new RSPDbContext();
        }
        public IEnumerable<PersonPageRank> GetList()
        {
            var personPageRanks = db.PersonPageRanks.AsEnumerable<PersonPageRank>();
            return personPageRanks;
        }
        public PersonPageRank Get(int PageID, int PersonID)
        {
            var personPageRank = db.PersonPageRanks.FirstOrDefault(p => p.PageID == PageID && p.PersonID == PersonID);
            return personPageRank;
        }
        public bool Create(PersonPageRank item)
        {
            try
            {
                db.PersonPageRanks.Add(item);
                db.SaveChanges();
                return true;
            }
            catch { return false; }
        }
        public bool Update(PersonPageRank item)
        {
            var personPageRank = db.PersonPageRanks.FirstOrDefault(p => p.PageID == item.PageID && p.PersonID == item.PersonID);
            if (personPageRank != null)
            {
                try
                {
                    personPageRank.PageID = item.PageID;
                    personPageRank.PersonID = item.PersonID;
                    personPageRank.Rank = item.Rank;
                    db.Entry(personPageRank).State = System.Data.Entity.EntityState.Modified;
                    db.SaveChanges();
                    return true;
                }
                catch { return false; }
            }
            else return false;
        }
        public bool Delete(int PageID, int PersonID)
        {
            var personPageRanks = db.PersonPageRanks.Where(p => p.PageID == PageID && p.PersonID == PersonID);
            if (personPageRanks != null && personPageRanks.Count() > 0)
            {
                try
                {
                    db.PersonPageRanks.RemoveRange(personPageRanks);
                    db.SaveChanges();
                    return true;
                }
                catch { return false; }
            }
            else return false;
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
