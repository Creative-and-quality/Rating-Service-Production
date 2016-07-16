class GeneralStatisticsController < ApplicationController
  def index
    @error_message = {}
    @BUTTEN_ACTIVE = 'G'
    @sites         = sites_option_list
    @last_site     = last_option_site
    @persons       = persons_option_list if @last_site

    @error_message[:error] = error_list_emty_params(option_site_id: 'Вы не выбрали сайт')
  end


end
