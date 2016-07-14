class Api::ApplicationController < ActionController::Base
  before_action :name_params_validation, only: [:update, :create]
  before_action :secret_key_validation

  include Api::ParamsValidators

  protect_from_forgery with: :null_session

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

end
