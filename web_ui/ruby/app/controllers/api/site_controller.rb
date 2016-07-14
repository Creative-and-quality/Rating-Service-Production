class Api::SiteController < Api::ApplicationController

  def index
    @sites = Site.all
    render :json => @sites
  end

  def create
    @site = Site.new(site_params)

    if @site.save
      render :json => @site
    else
      render :json => @site.errors
    end
  end

  def show
    @site = Site.find_by(id: params['id'])
    if @site
      render :json => @site
    else
      render :json => response_not_found
    end
  end

  def update
    @site = Site.find_by(id: params['id'])
    params['PageUrl'] = Page.where(SiteID: params['id']).take

    if @site && @site.update_attributes(site_params)
      render :json => @site
    elsif @site.nil?
      render :json => response_not_found
    else
      render :json => @site.errors
    end
  end

  def destroy
    @site = Site.find_by(id: params['id'])
    if @site
      @site.destroy!
      render :json => response_ok
    else
      render :json => response_not_found
    end
  end

  private

  def site_params
    { Name: params['Name'], page_url: params['PageUrl'] }
  end

end
