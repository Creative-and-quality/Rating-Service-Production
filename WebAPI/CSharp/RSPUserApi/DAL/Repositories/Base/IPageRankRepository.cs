using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Domain.Entities;

namespace DAL.Repositories.Base
{
    // Из-за того что в таблице PersonPageRank ключ составной - два метода - Delete и Get - должны принимать два параметра вместо одного (как в других таблицах)
    public interface IPersonPageRankRepository : IDisposable
    {
        IEnumerable<PersonPageRank> GetList();
        PersonPageRank Get(int PageId, int PersonId);
        bool Create(PersonPageRank item);
        bool Update(PersonPageRank item);
        bool Delete(int PageId, int PersonId);
    }
}
