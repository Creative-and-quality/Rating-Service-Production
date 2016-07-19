class User < ActiveRecord::Base
  include Models::ColumnMethodsMysql
  self.table_name = "Users"

  validates :name,  presence: true, length: { maximum: 50 }
  validates :login, presence: true, length: { maximum: 50 }

  before_save { self.login = login.downcase }

  has_secure_password
  validates :password, presence: true, length: { minimum: 6 }


end
