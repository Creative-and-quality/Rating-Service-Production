class GeneralStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'G'
    @sites     = sites_option_list
    @last_site = last_option_site
    @persons   = persons_option_list if @last_site
  end

  private

  def sites_option_list
    all_site_parametr = Site.new(name: 'Все', id: 0)
    Site.find_each.to_a.push(all_site_parametr)
  end

  def last_option_site
    if params[:option_site_id] && statistics_params(:option_site_id).zero?
      @sites.last
    elsif params[:option_site_id]
      Site.find statistics_params(:option_site_id)
    end
  end

  def statistics_params(*name_options)
    params.require(*name_options).to_i
  end

end
