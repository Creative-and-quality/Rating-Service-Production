module Models::ColumnMethodsMysql
  def person_id
    self.PersonID
  end

  def url
    self.Url
  end

  def site
    Site.find site_id
  end

  def site_id
    self.SiteID
  end

  def rank
    self.Rank
  end

  def person
    Person.find person_id
  end

  def page
    Page.find page_id
  end

  def page_id
    self.PageID
  end

  def name
    self.Name
  end

  def login
    self.Login
  end

  def login=(value)
    self.Login = value
  end

  def password_digest
    self.Password
  end

  def found_date
    self.FoundDateTime
  end

  def password_digest=(value)
    self.Password = value

  end


end
