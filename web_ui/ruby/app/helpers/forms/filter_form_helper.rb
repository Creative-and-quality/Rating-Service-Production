module Forms::FilterFormHelper
  def options_for_select_models(models, last_model)
    option_list_for_select = {}

    if last_model
      option_list_for_select[last_model.name] = last_model.id
    else
      option_list_for_select[''] = ''
    end

    models.each do |model|
      option_list_for_select[model.name] = model.id
    end

    option_list_for_select.to_a
  end


end
