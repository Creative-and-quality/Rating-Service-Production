class Site < ActiveRecord::Base
  has_many(:page)

  attr_accessor :page_url

  after_save :add_page

  validates(:name, presence: true)
  validates(:page_url, presence: true)

  private

  def add_page
    self.page.create url: page_url

  end

end
