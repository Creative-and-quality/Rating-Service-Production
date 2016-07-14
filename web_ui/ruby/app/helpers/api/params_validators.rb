module Api::ParamsValidators

  def name_params_validation
    if params['Name'] && !params['Name'].blank?
      @name_params = params.permit(:Name)
    else
      render :json => {error: '500 bad request'}
    end
  end

  def secret_key_validation
    secret_key = RspWeb::Application.config.rsp_web_api_key['api_key_geekbrains']
    unless params[:app_key] == secret_key
      render :json => response_error_auth
    end
  end
end
