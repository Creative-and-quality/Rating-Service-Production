class SessionsController < ApplicationController
  def new
  end

  def create
    user = User.find_by(Login: params[:session][:login].downcase)
    if user && user.authenticate(params[:session][:password])
      log_in user
      redirect_to general_statistics_path

    else
      flash[:error] = ['Ошибка авторизации'] # Not quite right!
      render 'new'
    end
  end
end
