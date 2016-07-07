module StatisticsHelper

  def site_id_params
    params.require(:option_site_id).to_i unless params[:option_site_id].blank?
  end

  def person_id_params
    params.require(:option_person_id).to_i unless params[:option_person_id].blank?
  end

  def sites_option_list
    Site.find_each.to_a
  end

  def last_option_site
    Site.find site_id_params if site_id_params
  end

  def last_option_person
    Person.find person_id_params if person_id_params
  end

  def persons_option_list
    Person.find_each.to_a
  end


end
