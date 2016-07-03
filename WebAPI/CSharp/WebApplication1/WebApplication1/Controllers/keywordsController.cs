using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using WebApplication1;

namespace WebApplication1.Controllers
{
    public class keywordsController : ApiController
    {
        private geekbrainsEntities db = new geekbrainsEntities();

        // GET: api/keywords
        public IQueryable<keywords> Getkeywords()
        {
            return db.keywords;
        }

        // GET: api/keywords/5
        [ResponseType(typeof(keywords))]
        public IHttpActionResult Getkeywords(int id)
        {
            keywords keywords = db.keywords.Find(id);
            if (keywords == null)
            {
                return NotFound();
            }

            return Ok(keywords);
        }

        // PUT: api/keywords/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putkeywords(int id, keywords keywords)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != keywords.Id)
            {
                return BadRequest();
            }

            db.Entry(keywords).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!keywordsExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/keywords
        [ResponseType(typeof(keywords))]
        public IHttpActionResult Postkeywords(keywords keywords)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.keywords.Add(keywords);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = keywords.Id }, keywords);
        }

        // DELETE: api/keywords/5
        [ResponseType(typeof(keywords))]
        public IHttpActionResult Deletekeywords(int id)
        {
            keywords keywords = db.keywords.Find(id);
            if (keywords == null)
            {
                return NotFound();
            }

            db.keywords.Remove(keywords);
            db.SaveChanges();

            return Ok(keywords);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool keywordsExists(int id)
        {
            return db.keywords.Count(e => e.Id == id) > 0;
        }
    }
}