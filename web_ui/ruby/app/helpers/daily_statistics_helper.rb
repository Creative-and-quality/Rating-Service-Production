module DailyStatisticsHelper

  def count_page_on_date_and_site(person, site, date_range)
    date_count_page_table = Hash.new { |hash, key| hash[key] = 0 }
    site_id = site.id

    pages =
    if site_id.zero?
      person.page_in_time_range(date_range)
    else
      person.page_in_time_range(date_range).where(SiteID: site_id)
    end

    pages.each do |page|
      date_count_page_table[page.found_date.strftime('%Y-%m-%d')] += 1
    end
    date_count_page_table[''] = summ_text_value(pages.size)

    date_count_page_table
  end

  def print_date_range(date_range)
    'c ' + date_range.first.strftime('%Y-%m-%d') + ' по ' + date_range.last.strftime('%Y-%m-%d')
  end

  def summ_text_value(page_count)
    "Всего страниц: #{page_count}"

  end


end
