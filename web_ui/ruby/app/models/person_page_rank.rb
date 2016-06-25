class PersonPageRank < ActiveRecord::Base
  belongs_to :person
  belongs_to :page
end
