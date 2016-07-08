class GeneralStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'G'
    @sites     = sites_option_list
    @last_site = last_option_site
    @persons   = persons_option_list if @last_site
  end


end
