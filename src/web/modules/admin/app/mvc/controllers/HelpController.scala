package nagara.admin.mvc.controllers

import play.api._
import play.api.mvc._

object HelpController extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
