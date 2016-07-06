module Forms::FilterFormHelper
  def options_for_select_site
    sites_option_list_for_select = {}
    
    if @last_site
      sites_option_list_for_select[@last_site.name] = @last_site.id
    else
      sites_option_list_for_select[''] = ''
    end

    @sites.each do |site|
      sites_option_list_for_select[site.name] = site.id
    end
    sites_option_list_for_select.to_a

  end

end
