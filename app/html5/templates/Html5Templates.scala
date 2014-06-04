package html5.templates

import play.twirl.api._
import java.util._
import scala.util.matching.Regex

object Html5Templates {

/*
* Disclaimer : Old code :)
* TODO : be more functional
*/

 /**
  * Find special types from field
  */
 def findType(field: play.api.data.Field): Html = {
   field.constraints.foreach(constraint => 
     if(constraint._1.equals("constraint.email")) return Html("email")
     else if(constraint._1.equals("constraint.min")||constraint._1.equals("constraint.max")) return Html("number")
   )
   Html("text")
  }
  
  /**
   * Generates form validation attributes
   */
  def toValidation(field: play.api.data.Field) = {
    val out = new StringBuilder
    field.constraints.foreach(constraint => 
      constraint._1 match {
          case "constraint.required" => out.append(" required")
          case "constraint.max" => out.append(constraintValue("max", constraint._2.headOption))
          case "constraint.min" => out.append(constraintValue("min", constraint._2.headOption))
          case "constraint.maxLength" => out.append(constraintValue("maxlength", constraint._2.headOption))
          case "constraint.minLength" => out.append(constraint._2.headOption.map(value => Html(" pattern=\".{" + value + ",}\"")).getOrElse(Html("")))
          case "constraint.pattern" => out.append((constraint._2.headOption.map(value => value match {
            //for scala pattern
            case f: Function0[Any] => constraintValue("pattern", Option(f.apply().toString))
            //for java @Pattern
            case value: String => constraintValue("pattern", Option(value))
          }).getOrElse(new Html(""))))
          case _ => ()
       })
      Html(out.toString)
  }
  
  private def constraintValue(label: String, value : Option[Any]) = {
    val out = value.map(" " + label + "=\"" + _ + "\"")
    Html(out.getOrElse(""))
  }
}
