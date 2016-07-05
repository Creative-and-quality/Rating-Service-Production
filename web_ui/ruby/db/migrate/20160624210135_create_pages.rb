class CreatePages < ActiveRecord::Migration
  def change
    create_table :pages do |t|
      t.string :url
      t.date :last_scan_date
      t.references :site, index: true, foreign_key: true

      t.timestamps null: false
    end
  end
end
