using DAL.Context;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Repositories
{
    public class UserRepository : Base.IRepository<User>
    {
        private RSPDbContext db;
        public UserRepository()
        {
            this.db = new RSPDbContext();
        }
        public IEnumerable<User> GetList()
        {
            var users = db.Users.AsEnumerable<User>();
            return users;
        }
        public User Get(int Id)
        {
            var user = db.Users.FirstOrDefault(u => u.ID == Id);
            return user;
        }
        public void Create(User item)
        {
            db.Users.Add(item);
            db.SaveChanges();
        }
        public void Update(User item)
        {
            var user = db.Users.FirstOrDefault(u => u.ID == item.ID);
            if (user != null)
            {
                user.Name = item.Password;
                user.Login = item.Login;
                user.Password = item.Password;
                user.IsAdmin = item.IsAdmin;
                db.Entry(user).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
            }
        }
        public void Delete(int Id)
        {
            var user = db.Users.FirstOrDefault(u => u.ID == Id);
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
