class Keyword < ActiveRecord::Base
  validates(:name, presence: true)
  belongs_to :person
end
