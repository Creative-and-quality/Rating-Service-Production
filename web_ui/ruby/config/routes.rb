Rails.application.routes.draw do
  root 'static_pages#home'

  resources :general_statistics, only: [:index]
  resources :daily_statistics, only: [:index]

  namespace :api do
  resources :keyword, only: [:show, :destroy]
end
  # resources :persons, only: [:create, :show, :index]
end
