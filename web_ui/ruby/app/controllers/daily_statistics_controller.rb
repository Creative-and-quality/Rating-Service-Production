class DailyStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'D'
    @sites     = sites_option_list
    @persons   = persons_option_list
    @last_site = last_option_site     if params[:option_site_id]
    @last_person = last_option_person if params[:option_person_id]
  end




end
