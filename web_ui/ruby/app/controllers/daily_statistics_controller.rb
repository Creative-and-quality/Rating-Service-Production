class DailyStatisticsController < ApplicationController
  before_action :logged_in_user, only: [:index]
  
  def index
    @error_message = {}
    @BUTTEN_ACTIVE = 'D'
    @sites         = sites_option_list
    @persons       = persons_option_list
    @last_site     = last_option_site
    @last_person   = last_option_person
    @date_range    = date_rang_params

    @error_message[:error] = error_list_emty_params(option_site_id: 'Вы не выбрали сайт', option_person_id: 'Вы не выбрали имя персоны')
    if @date_range && @date_range.last < @date_range.first
      @error_message[:error] ||= []
      @error_message[:error] << "Выбран неверный интервал дат"
    end

  end




end
