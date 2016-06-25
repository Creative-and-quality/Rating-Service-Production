class CreatePersonPageRanks < ActiveRecord::Migration
  def change
    create_table :person_page_ranks do |t|
      t.integer :rank
      t.references :person, index: true, foreign_key: true
      t.references :page, index: true, foreign_key: true

      t.timestamps null: false
    end
  end
end
