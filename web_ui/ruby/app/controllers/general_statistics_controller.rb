class GeneralStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'G'
    @sites     = sites_option_list
    @last_site = last_option_site
    @persons   = persons_option_list if @last_site

    flash[:error] = error_list_emty_params(option_site_id: 'Вы не выбрали сайт')
  end


end
