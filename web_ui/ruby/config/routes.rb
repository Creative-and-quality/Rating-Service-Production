Rails.application.routes.draw do
  root 'static_pages#home'

  resources :general_statistics, only: [:index]
  # resources :persons, only: [:create, :show, :index]
end
