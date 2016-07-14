class Page < ActiveRecord::Base
  include Models::ColumnMethodsMysql
  self.table_name = "Pages"

  default_scope -> { order(FoundDateTime: :asc) }

  belongs_to :site,             primary_key: 'SiteID'
  has_many   :person_page_rank, foreign_key: 'PageID'

  validates(:url, presence: true)
  validates(:site, presence: true)

end
