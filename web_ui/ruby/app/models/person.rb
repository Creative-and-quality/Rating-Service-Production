class Person < ActiveRecord::Base
  self.table_name = "Persons"


  has_many :keyword,          dependent: :destroy, foreign_key: 'PersonID'
  has_many :person_page_rank, dependent: :destroy, foreign_key: 'PersonID'

  validates(:Name, presence: true)

  def general_rank_pages_on_site(site_id)
    page_ids = "SELECT id FROM Pages
    WHERE  SiteID = :site_id"
    person_page_rank.where("PageID IN (#{page_ids})", site_id: site_id)
  end
  
  include Models::ColumnMethodsMysql

end
