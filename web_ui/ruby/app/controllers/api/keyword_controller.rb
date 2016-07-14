class Api::KeywordController < ApplicationController
  skip_before_filter :verify_authenticity_token
  before_action :keyword_params_validation, only: [:update, :create]
  before_action :secret_key_validation

  def index
    @keywords = Keyword.all
    render :json => @keywords
  end

  def show
    @keyword = Keyword.find_by id: params['id']
    if @keyword
      render :json => @keyword
    else
      render :json => response_not_found
    end

  end

  def create
    # {"name":"Путиным","controller":"api/keyword","action":"create","person_id":"1"}
    @person = Person.find_by(id: params['person_id'])

    if @person
      @keyword = @person.keyword.create(Name: params['Name'])
      render :json => @keyword
    else
      render :json => response_not_found
    end

  end

  def update
    @keyword = Keyword.find_by id: params['id']
    if @keyword
      @keyword.update_attributes(@keyword_params)
      render :json => @keyword
    else
      render :json => response_not_found
    end
  end

  def destroy
    @keyword = Keyword.find_by id: params['id']
    if @keyword
      @keyword.destroy!
      render :json => response_ok
    else
      render :json => response_not_found
    end
  end


  private

  def response_ok
    {status: 'OK'}
  end

  def response_not_found
    {error: 'not_found'}
  end

  def response_error_db
    {error: 'could not write to the database'}
  end

  def response_error_auth
    {error: 'authentication error'}
  end

  def keyword_params_validation
    if params['Name'] && !params['Name'].blank?
      @keyword_params = params.permit(:Name)
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
