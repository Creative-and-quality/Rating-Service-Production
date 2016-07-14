class Api::PersonController < Api::ApplicationController

  def index
    @persons = Person.all
    render :json => @persons
  end

  def create
    @person = Person.new(Name: params['Name'])

    if @person.save
      render :json => @person
    else
      render :json => @person.errors
    end
  end

  def show
    @person = Person.find_by(id: params['id'])
    if @person
      render :json => @person
    else
      render :json => response_not_found
    end
  end

  def update
    @person = Person.find_by(id: params['id'])

    if @person && @person.update_attributes(@name_params)
      render :json => @person
    elsif @person.nil?
      render :json => response_not_found
    else
      render :json => @person.errors
    end
  end

  def destroy
    @person = Person.find_by(id: params['id'])
    if @person
      @person.destroy!
      render :json => response_ok
    else
      render :json => response_not_found
    end

  end
end
