using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using DAL.Context;
using Domain.Entities;

namespace RSPUserApi.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            ViewBag.Title = "Home Page";
            using (var db = new RSPDbContext())
            {
                IEnumerable<User> users = db.Users.Where(u => u.ID == 1);
            }

            return View();
        }
    }
}
