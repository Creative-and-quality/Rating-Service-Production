class Person < ActiveRecord::Base
  has_many :keyword
  has_many :person_page_rank

  validates(:name, presence: true)

  def general_rank_pages_on_site(site_id)
    page_ids = "SELECT id FROM pages
    WHERE  site_id = :site_id"
    person_page_rank.where("page_id IN (#{page_ids})", site_id: site_id)
  end
end
