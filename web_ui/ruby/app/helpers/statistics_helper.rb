module StatisticsHelper

  def statistics_params(*name_options)
    params.require(*name_options)
  end

  def sites_option_list
    Site.find_each.to_a
  end

  def last_option_site
    Site.find statistics_params(:option_site_id)
  end

  def last_option_person
    Person.find statistics_params(:option_person_id)
  end

  def persons_option_list
    Person.find_each.to_a
  end

end
