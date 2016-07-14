class Api::KeywordController < Api::ApplicationController
  # если нужно обойти авторизацию сессии в куках, можно использовать:
  # skip_before_filter :verify_authenticity_token

  def index
    @keywords = Keyword.all
    render :json => @keywords
  end

  def create
    @person = Person.find_by(id: params['person_id'])
    @keyword = @person.keyword.new(Name: params['Name']) if @person

    render :json => response_body_create

  end

  def show
    @keyword = Keyword.find_by(id: params['id'])
    if @keyword
      render :json => @keyword
    else
      render :json => response_not_found
    end

  end

  def update
    @keyword = Keyword.find_by(id: params['id'])

    if @keyword && @keyword.update_attributes(@name_params)
      render :json => @keyword
    elsif @keyword.nil?
      render :json => response_not_found
    else
      render :json => @keyword.errors
    end
  end

  def destroy
    @keyword = Keyword.find_by(id: params['id'])
    if @keyword
      @keyword.destroy!
      render :json => response_ok
    else
      render :json => response_not_found
    end
  end
  
  private

  def response_body_create
    if @keyword && @keyword.save
      @keyword
    elsif @person.nil?
      response_not_found
    else
      @keyword.errors
    end
  end

end
