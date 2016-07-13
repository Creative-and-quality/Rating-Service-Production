class Api::KeywordController < ApplicationController
  skip_before_filter :verify_authenticity_token
  before_action :keyword_params_validation, only: :update

  def show
    @keyword = Keyword.find_by id: params['id']
    if @keyword
      render :json => @keyword.to_json
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

  def update
    @keyword = Keyword.find_by id: params['id']
    if @keyword
      @keyword.update_attributes(@keyword_params)
      render :json => @keyword
    else
      render :json => response_not_found
    end
  end

  private

  def response_ok
    {status: 'OK'}
  end

  def response_not_found
    {status: 'not_found'}
  end

  def keyword_params_validation
    if params['Name']
      @keyword_params = params.permit(:Name)
    else
      render :json => {error: '500 bad request'}
    end
  end
end
