class Person < ActiveRecord::Base
  self.table_name = "Persons"


  has_many :keyword,          dependent: :destroy, foreign_key: 'PersonID'
  has_many :person_page_rank, dependent: :destroy, foreign_key: 'PersonID'

  validates(:Name, presence: true)

  include Models::ColumnMethodsMysql

  def general_rank_pages_on_site(site_id)
    page_ids = "SELECT id FROM Pages
    WHERE  SiteID = :site_id"
    person_page_rank.where("PageID IN (#{page_ids})", site_id: site_id)
  end

  def page_in_time_range(time_range)
    pages.where(FoundDateTime: time_range)
  end

  def pages
    page_ids = "SELECT PageID FROM PersonPageRanks
    WHERE  PersonID = :person_id"
    Page.where("id IN (#{page_ids})", person_id: id)
  end



end
