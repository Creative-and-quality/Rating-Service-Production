class Api::DailyStatisticsController < Api::ApplicationController
  include DailyStatisticsHelper
  include StatisticsHelper

  before_action :before_action_site_id_validation,   only: [:index]
  before_action :before_action_person_id_validation, only: [:index]
  before_action :before_action_date_validation,      only: [:index]

  def index
    @site   = Site.find_by(id: @site_id_params)
    @person = Person.find_by(id: @person_id_params)

    if @site && @person
      render :json => count_page_on_date_and_site(@person, @site, @date_range_params)
    else
      render :json => response_not_found
    end

  end

end
