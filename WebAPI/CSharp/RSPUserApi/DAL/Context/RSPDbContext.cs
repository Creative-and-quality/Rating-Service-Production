using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Domain.Entities;

namespace DAL.Context
{
    public class RSPDbContext : DbContext
    {
        public RSPDbContext()
            : base("RSPDbConnection")
        {
            
        }
        public DbSet<User> Users { get; set; }
        public DbSet<Keyword> Keywords { get; set; }
        public DbSet<Person> Persons { get; set; }
        public DbSet<Site> Sites { get; set; }
        public DbSet<Page> Pages { get; set; }
        public DbSet<PersonPageRank> PersonPageRanks { get; set; }
    }
}
