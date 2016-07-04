module PersonHelper

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
