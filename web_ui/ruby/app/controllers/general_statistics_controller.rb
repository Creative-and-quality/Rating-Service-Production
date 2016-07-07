class GeneralStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'G'
    @sites     = sites_option_list
    @last_site = last_option_site
    @persons   = persons_option_list if @last_site
  end

  private

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


end
