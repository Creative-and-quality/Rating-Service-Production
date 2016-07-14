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
end
