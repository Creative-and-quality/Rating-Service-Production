require 'test_helper'

class DailyStatisticsControllerTest < ActionController::TestCase
  test "should get index" do
    get :index
    assert_response :success
  end

end
