class Keyword < ActiveRecord::Base
  self.table_name = "Keywords"
  validates(:Name, presence: true)
  belongs_to :person, primary_key: 'PersonID'

  include Models::ColumnMethodsMysql


end
