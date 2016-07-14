Rails.application.routes.draw do
  root 'static_pages#home'

  resources :general_statistics, only: [:index]
  resources :daily_statistics, only: [:index]

  namespace :api do
    resources :keyword, only: [:show, :destroy, :update, :index]

    resources :person, only: [:show, :destroy, :update, :index, :create] do
      resources :keyword, only: [:create]
    end

  end

end
