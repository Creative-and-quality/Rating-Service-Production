class DailyStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'D'
    @sites       = sites_option_list
    @persons     = persons_option_list
    @last_site   = last_option_site
    @last_person = last_option_person
    @date_range  = date_rang_params
  end




end
