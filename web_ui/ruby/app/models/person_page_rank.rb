class PersonPageRank < ActiveRecord::Base
  belongs_to :person
  belongs_to :page

  validates(:person, :page, presence: true)
  validates(:rank, presence: true)

end
