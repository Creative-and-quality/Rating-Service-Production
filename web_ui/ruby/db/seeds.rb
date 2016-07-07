putin    = %w/Путин Путину Путином Путина/
medvedev = %w/Медведев Медведеву Медведевым/
novaln   = %w/Новальный Новальному Новальным Новального/

persons = {
  'Путин'     => putin,
  'Медведев'  => medvedev,
  'Новальный' => novaln
}

persons.each_pair do |name, keywords|
  person = Person.create(Name: name)
  keywords.each { |keyword| person.keyword.create(Name: keyword) }

end

sites = %w/lenta.ru news.ru 24.ru/

sites.each do |site_name|
  page_number = 1
  time = Time.new(2015)
  persons = Person.all

  # Using callback after_save!!! becouse not using create.
  site = Site.new(Name: site_name, page_url: site_name)
  site.save

  300.times do
    new_page_url = site.page_url + '/' + page_number.to_s
    page = site.page.create(Url: new_page_url, FoundDateTime: time)

    random_person_id = persons.sample.id
    rank_on_page = rand(20) + 1
    page.person_page_rank.create!(PersonID: random_person_id, Rank: rank_on_page)

    page_number += 1
    time = time.tomorrow
  end
end
