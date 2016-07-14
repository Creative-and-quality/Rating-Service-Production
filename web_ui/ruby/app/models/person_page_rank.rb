class PersonPageRank < ActiveRecord::Base
  include Models::ColumnMethodsMysql
  self.table_name  = "PersonPageRanks"
  self.primary_key = 'PageID'

  belongs_to :person, primary_key: 'PersonID'
  belongs_to :page,   primary_key: 'PageID'

  validates(:person, :page, presence: true)
  validates(:rank, presence: true)


end
