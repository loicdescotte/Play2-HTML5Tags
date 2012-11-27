package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.validation._
import play.api.data.Forms._
import models._
import views._

import play.api.data.validation._
import play.api.data.validation.Constraints._


object Application extends Controller {  

  val contactForm = Form(
    mapping(      
      "name" -> nonEmptyText(minLength=2, maxLength=10),      
      "email" -> (email verifying nonEmpty),
      "age" -> number(min=18, max=99),
      "password" -> (nonEmptyText verifying pattern("""[0-9]{4}""".r))
    )(Contact.apply)(Contact.unapply)
  )

  def index = Action {
    Ok(views.html.index(contactForm))
  }

  def save = Action {
    Redirect( routes.Application.index() )    
  }
  
}