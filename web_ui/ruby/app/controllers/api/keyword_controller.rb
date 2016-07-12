class Api::KeywordController < ApplicationController
  def show
    @keyword = Keyword.find params['id']
    if @keyword
      render :json => @keyword.to_json
    else
      render :json => response_not_found
    end

  end

  def destroy
    @keyword = Keyword.find params['id']
    @keyword.destroy!
    render :json => response_ok
  end

  private

  def response_ok
    {status: 'OK'}.to_json
  end

  def response_not_found
    {status: 'not_found'}.to_json
  end
end
