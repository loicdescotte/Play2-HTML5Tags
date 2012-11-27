package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;
import models.*;

public class Application extends Controller {

    final static Form<Contact> contactForm = form(Contact.class);
  
    public static Result index() {
        return ok(index.render(contactForm));
    }

    public static Result save() {
        return redirect( "/" );
    }
  
}
