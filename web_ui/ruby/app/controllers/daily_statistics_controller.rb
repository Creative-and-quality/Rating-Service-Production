class DailyStatisticsController < ApplicationController
  def index
    @BUTTEN_ACTIVE = 'D'
    @sites       = sites_option_list
    @persons     = persons_option_list
    @last_site   = last_option_site
    @last_person = last_option_person
    @date_range  = date_rang_params

    flash[:error] = error_list_emty_params(option_site_id: 'Вы не выбрали сайт', option_person_id: 'Вы не выбрали имя персоны')
  end




end
