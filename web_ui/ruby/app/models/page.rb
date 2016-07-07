class Page < ActiveRecord::Base
  self.table_name = "Pages"

  belongs_to :site,             primary_key: 'SiteID'
  has_many   :person_page_rank, foreign_key: 'PageID'

  validates(:url, presence: true)
  validates(:site, presence: true)

  def url
    self.Url
  end

  def site
    Site.find site_id
  end

  def site_id
    self.SiteID
  end
end
