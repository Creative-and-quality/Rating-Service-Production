class Api::KeywordController < Api::ApplicationController
  # если нужно обойти авторизацию сессии в куках, можно использовать:
  # skip_before_filter :verify_authenticity_token

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
    @person = Person.find_by(id: params['person_id'])

    if @person
      @keyword = @person.keyword.new(Name: params['Name'])
    else
      render :json => response_not_found
    end

    if @keyword.save
      render :json => @keyword
    else
      render :json => @keyword.errors
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

end
