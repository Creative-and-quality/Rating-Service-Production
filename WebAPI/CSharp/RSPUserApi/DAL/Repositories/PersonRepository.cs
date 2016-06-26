using DAL.Context;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Repositories
{
    public class PersonRepository : Base.IRepository<Person>
    {
        private RSPDbContext db;
        public PersonRepository()
        {
            this.db = new RSPDbContext();
        }
        public IEnumerable<Person> GetList()
        {
            var person = db.Persons.AsEnumerable<Person>();
            return person;
        }
        public Person Get(int Id)
        {
            var person = db.Persons.FirstOrDefault(p => p.ID == Id);
            return person;
        }
        public void Create(Person item)
        {
            db.Persons.Add(item);
            db.SaveChanges();
        }
        public void Update(Person item)
        {
            var person = db.Persons.FirstOrDefault(p => p.ID == item.ID);
            if (person != null)
            {
                person.Name = item.Name;
                db.Entry(person).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
            }
        }
        public void Delete(int Id)
        {
            var person = db.Persons.FirstOrDefault(p => p.ID == Id);
            if (person != null)
            {
                db.Persons.Remove(person);
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
