using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using Service.Entities;

namespace Service.Context
{
    public class ApiDbContext : DbContext
    {
        private static ApiDbContext _context = null;

        static ApiDbContext()
        {
            _context = new ApiDbContext();
        }

        public static ApiDbContext Instance
        {
            get
            {
                return _context;
            }
        }

        private ApiDbContext()
            : base("ApiConnectionString")
        { }

        public DbSet<Keyword> Keywords { get; set; }

        public DbSet<Entities.Person> Persons { get; set; }

        public DbSet<Site> Sites { get; set; }

    }
}