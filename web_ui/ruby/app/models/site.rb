class Site < ActiveRecord::Base
  include Models::ColumnMethodsMysql
  self.table_name = "Sites"

  attr_accessor :page_url

  has_many :page, dependent: :destroy, foreign_key: 'SiteID'

  validates(:name, presence: true)
  validates(:page_url, presence: true)

  after_save :add_page

  private

  def add_page
    self.page.create Url: page_url
  end


end
