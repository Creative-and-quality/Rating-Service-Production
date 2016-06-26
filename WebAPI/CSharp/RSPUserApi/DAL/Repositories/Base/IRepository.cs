using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Repositories.Base
{
    public interface IRepository<T> : IDisposable
        where T : class
    {
        IEnumerable<T> GetList();
        T Get(int Id);
        void Create(T item);
        void Update(T item);
        void Delete(int Id);
    }
}
