class Person < ActiveRecord::Base
  has_many :keyword
  has_many :person_page_rank

  validates(:name, presence: true)
end
