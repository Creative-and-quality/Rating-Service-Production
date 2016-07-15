class Api::GeneralStatisticsController < Api::ApplicationController
  include GeneralStatisticsHelper

  before_action :before_action_site_id_validation, only: [:index]

  def index
    @persons = Person.all.to_a
    if Site.exists?(@site_id_params)
      render :json => persons_table(@persons, @site_id_params)
    else
      render :json => response_not_found
    end
  end

end
