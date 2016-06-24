class Person < ActiveRecord::Base
  validates(:name, presence: true)
  has_many :keyword
end
