Rails.application.routes.draw do
  root 'static_pages#home'
  get    '/general_statistics', to: 'general_statistics#index'
  get    '/daily_statistics',   to: 'daily_statistics#index'
  get    '/login',              to: 'sessions#new'
  post   '/login',              to: 'sessions#create'
  delete '/logout',             to: 'sessions#destroy'

  namespace :api do
    get    '/general_statistics', to: 'general_statistics#index'
    get    '/daily_statistics',   to: 'daily_statistics#index'

    resources :keyword, only: [:show, :destroy, :update, :index]
    resources :site, only: [:show, :destroy, :update, :index, :create]

    resources :person, only: [:show, :destroy, :update, :index, :create] do
      resources :keyword, only: [:create]
    end

  end

end
