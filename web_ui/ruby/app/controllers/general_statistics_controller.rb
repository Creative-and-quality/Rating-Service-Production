class GeneralStatisticsController < ApplicationController
  def index
    @sites = sites_list
    @last_site = Site.find(option_site_id_params) if params[:option_site_id]
    @persons = Person.find_each if @last_site
  end

  private

  def option_site_id_params
    params.require(:option_site_id)
  end
end
