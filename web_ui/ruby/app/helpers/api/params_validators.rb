module Api::ParamsValidators

  def name_params_validation
    if params['Name'] && !params['Name'].blank?
      @name_params = params.permit(:Name)
    else
      render :json => {error: '500 bad request'}
    end
  end

  def before_action_site_id_validation
    if params['SiteID'] && !params['SiteID'].blank?
      @site_id_params = params['SiteID'].to_i
    else
      render :json => {error: '500 bad request'}
    end
  end

  def before_action_person_id_validation
    if params['PersonID'] && !params['PersonID'].blank?
      @person_id_params = params['PersonID'].to_i
    else
      render :json => {error: '500 bad request'}
    end
  end

  def before_action_date_validation
    if params['DateFirst'] && !params['DateLast'].blank? && params['DateLast'] && !params['DateFirst'].blank? && date_validation
      @date_range_params = Time.parse(params['DateFirst'])..Time.parse(params['DateLast'])
    else
      raise ArgumentError
    end
  rescue ArgumentError => e
    render :json => {error: '500 bad request'}
  end

  def secret_key_validation
    secret_key = RspWeb::Application.config.rsp_web_api_key['api_key_geekbrains']
    unless params[:app_key] == secret_key
      render :json => response_error_auth
    end
  end

  def date_validation
    regex = /^\d{4}\/\d{2}\/\d{2}$/
    regex =~ params['DateFirst'] && regex =~ params['DateLast']
  end
end
