module GeneralStatisticsHelper
  def persons_table(persons, site_id)
    table = {}
    persons.each do |person|
      table[person.name] = summ_general_rank_on_site(person, site_id)
    end

    sort_table(table)
  end

  def sort_table(table, max_to_min: 1)

    sort_table = table.invert
    sort_table =
    if max_to_min.zero?
      sort_table.sort { |a, b| a <=> b }
    else
      sort_table.sort { |a, b| b <=> a }
    end
    sort_table.to_h.invert
  end

end
