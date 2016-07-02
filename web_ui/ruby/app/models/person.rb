class Person < ActiveRecord::Base
  has_many :keyword
  has_many :person_page_rank

  validates(:name, presence: true)

  def summ_general_rank_on_site(site_id)
    rank_sum = 0
    general_rank_pages_on_site(site_id).each{|rank_page| rank_sum+= rank_page.rank}
    rank_sum
  end

  private

  def general_rank_pages_on_site(site_id)
    page_ids = "SELECT id FROM pages
    WHERE  site_id = :site_id"
    person_page_rank.where("page_id IN (#{page_ids})", site_id: site_id)
  end
end
