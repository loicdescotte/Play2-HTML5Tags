package html5.templates

import play.api.templates._
import java.util._
import scala.util.matching.Regex

object Html5Templates {

 /**
  * Find special types from field
  */
 def findType(field: play.api.data.Field): Html = {
   val out = Html.empty 
   field.constraints.foreach(constraint => 
  	 if(constraint._1.equals("constraint.email")) return Html("email")
     else if(constraint._1.equals("constraint.max")||constraint._1.equals("constraint.max")) return Html("number")
   )
   Html("text")
  }
  
  /**
   * Generates form validation attributes
   */
  def toValidation(field: play.api.data.Field) = {
    val out = Html.empty
    field.constraints.foreach(constraint => 
      constraint._1 match {
          case "constraint.required" => out + Html(" required")
          case "constraint.max" => out + constraintValue("max", constraint._2.headOption)
          case "constraint.min" => out + constraintValue("min", constraint._2.headOption)
          case "constraint.maxLength" => out + constraintValue("maxlength", constraint._2.headOption)
          case "constraint.minLength" => out + constraint._2.headOption.map(value => Html(" pattern=\".{" + value + ",}\"")).getOrElse(Html.empty)
          case "constraint.pattern" => out + (constraint._2.headOption.map(value => value match {
            //for scala pattern
            case f: Function0[Any] => constraintValue("pattern", Option(f.apply().toString))
            //for java @Pattern
            case value: String => constraintValue("pattern", Option(value))
          }).getOrElse(Html.empty)) 
          case _ => ()
       })
      out
  }
  
  private def constraintValue(label: String, value : Option[Any]) = {
    val out = value.map(" " + label + "=\"" + _ + "\"")
    Html(out.getOrElse(""))
  }
}
