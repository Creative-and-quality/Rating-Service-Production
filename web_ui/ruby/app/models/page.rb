class Page < ActiveRecord::Base
  belongs_to :site
  validates(:url, presence: true)
  validates(:site, presence: true)
end
