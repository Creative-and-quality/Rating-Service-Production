class SessionsController < ApplicationController
  def new
  end

  def create
    user = User.find_by(Login: params[:session][:login].downcase)
    if user && user.authenticate(params[:session][:password])
      log_in user
      flash[:success] = "#{user.name}, добро пожаловать!"
      redirect_to general_statistics_path

    else
      flash.now[:danger] = 'Ошибка авторизации' # Not quite right!
      render 'new'
    end
  end

  def destroy
    log_out
    redirect_to root_url
  end
end
