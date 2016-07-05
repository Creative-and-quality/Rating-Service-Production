class Page < ActiveRecord::Base
  belongs_to :site
  has_many   :person_page_rank

  validates(:url, presence: true)
  validates(:site, presence: true)
end
