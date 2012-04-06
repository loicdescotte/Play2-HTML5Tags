package html5.templates

import play.api.templates._

object Html5Templates {
  /**
   * Generates form validation attributes
   */
  def toValidation(field: play.api.data.Field) = {
    val out = Html.empty
    field.constraints.foreach(
	constraint => constraint._1 match {
        case "constraint.required" => out + Html(" required")
		//TODO extract method, use Option?		
        case "constraint.minLength" => out + Html(" minlength=\"" + constraint._2.head + "\"")
        case "constraint.maxLength" => out + Html(" maxlength=\"" + constraint._2.head + "\"")
        case "constraint.pattern" => out + Html(" pattern=\"" + constraint._2.head + "\"")
        case _ => ()
      })
    out
  }
}
