module StatisticsHelper

  def site_id_params
    params.require(:option_site_id).to_i unless params[:option_site_id].blank?
  end

  def person_id_params
    params.require(:option_person_id).to_i unless params[:option_person_id].blank?
  end

  def date_rang_params
    if params[:option_person_id].blank?
      time = Time.now
      time..time
    else
      hash_date_rang = params.require(:date)
      start_year = hash_date_rang['start(1i)']
      start_month = hash_date_rang['start(2i)']
      start_day = hash_date_rang['start(3i)']
      finish_year = hash_date_rang['finish(1i)']
      finish_month = hash_date_rang['finish(2i)']
      finish_day = hash_date_rang['finish(3i)']

      Time.new(start_year, start_month, start_day)..Time.new(finish_year, finish_month, finish_day)
    end
  end

  def sites_option_list
    all_site_parametr = Site.new(Name: 'Все', id: 0)
    Site.find_each.to_a.push(all_site_parametr)
  end

  def last_option_site
    if site_id_params && site_id_params.zero?
      @sites.last
    else
      Site.find site_id_params if site_id_params
    end
  end

  def last_option_person
    Person.find person_id_params if person_id_params
  end

  def persons_option_list
    Person.find_each.to_a
  end


end
