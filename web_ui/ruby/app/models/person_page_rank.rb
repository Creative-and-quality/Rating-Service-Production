class PersonPageRank < ActiveRecord::Base
  self.table_name  = "PersonPageRanks"
  self.primary_key = 'PageID'

  belongs_to :person, primary_key: 'PersonID'
  belongs_to :page,   primary_key: 'PageID'

  validates(:person, :page, presence: true)
  validates(:rank, presence: true)

  def rank
    self.Rank
  end

  def person
    Person.find person_id
  end

  def page
    Page.find page_id
  end

  def person_id
    self.PersonID
  end

  def page_id
    self.PageID
  end

end
