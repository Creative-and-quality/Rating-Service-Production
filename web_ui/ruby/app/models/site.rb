class Site < ActiveRecord::Base
  self.table_name = "Sites"

  has_many :page, dependent: :destroy, foreign_key: 'SiteID'

  attr_accessor :page_url

  after_save :add_page

  validates(:name, presence: true)
  validates(:page_url, presence: true)

  include Models::ColumnMethodsMysql

  private

  def add_page
    self.page.create Url: page_url
  end


end
