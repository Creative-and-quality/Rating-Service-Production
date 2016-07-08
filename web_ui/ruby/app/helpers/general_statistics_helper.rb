module GeneralStatisticsHelper
  def persons_table(persons, site_id)
    table = {}
    persons.each do |person|
      table[person.name] = summ_general_rank_on_site(person, site_id)
    end

    sort_table_by_rank(table)
  end

  def sort_table_by_rank(table, max_to_min: 1)

    sort_table = table.invert
    sort_table =
    if max_to_min.zero?
      sort_table.sort { |a, b| a <=> b }
    else
      sort_table.sort { |a, b| b <=> a }
    end
    sort_table.to_h.invert
  end

  def summ_general_rank_on_site(person, site_id)
    rank_sum = 0
    if site_id.zero?
      person.person_page_rank.find_each {|rank_page| rank_sum+= rank_page.rank}
    else
      person.general_rank_pages_on_site(site_id).find_each {|rank_page| rank_sum+= rank_page.rank}
    end

    rank_sum
  end

end
