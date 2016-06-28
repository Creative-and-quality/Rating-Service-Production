class Person < ActiveRecord::Base
  has_many :keyword
  has_many :person_page_rank

  validates(:name, presence: true)

  def general_rank
    rank_sum = 0
    person_page_rank.find_each(batch_size: 100){|rank_page| sum+= rank_page.rank}
    sum
  end
end
