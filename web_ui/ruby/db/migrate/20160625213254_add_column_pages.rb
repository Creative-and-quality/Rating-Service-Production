class AddColumnPages < ActiveRecord::Migration
  def change
    add_column :pages, :found_date_time, :date
  end
end
