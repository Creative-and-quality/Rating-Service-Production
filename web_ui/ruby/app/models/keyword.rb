class Keyword < ActiveRecord::Base
  self.table_name = "Keywords"
  validates(:Name, presence: true)
  belongs_to :person, primary_key: 'PersonID'

  def person_id
    self.PersonID
  end
end
