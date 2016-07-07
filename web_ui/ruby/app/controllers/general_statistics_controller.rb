class GeneralStatisticsController < ApplicationController
  def index
    @sites     = sites_option_list
    @last_site = last_option_site
    @persons   = Person.find_each if @last_site
  end

  private

  def option_site_id_params
    params.require(:option_site_id).to_i
  end

  def sites_option_list
    all_site_parametr = Site.new(Name: 'Все', id: 0)
    Site.find_each.to_a.push(all_site_parametr)
  end

  def last_option_site
    if params[:option_site_id] && option_site_id_params.zero?
      @sites.last
    elsif params[:option_site_id]
      Site.find(option_site_id_params)
    end
  end

end
