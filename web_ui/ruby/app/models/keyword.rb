class Keyword < ActiveRecord::Base
  include Models::ColumnMethodsMysql
  self.table_name = "Keywords"

  belongs_to :person, primary_key: 'PersonID'

  validates  :Name, presence: true, length: { maximum: 50 }


end
