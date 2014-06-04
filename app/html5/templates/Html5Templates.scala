package html5.templates

import play.twirl.api._
import java.util._
import scala.util.matching.Regex

object Html5Templates {

  /**
   * Find special types from field
   */
  def findType(field: play.api.data.Field): Html = {
    if (field.constraints.filter(constraint => constraint._1.equals("constraint.email")).size > 0) Html("email")
    else if (field.constraints.filter(constraint => constraint._1.equals("constraint.min") || constraint._1.equals("constraint.max")).size > 0) Html("number")
    else Html("text")
  }

  /**
   * Generates form validation attributes
   */
  def toValidation(field: play.api.data.Field) = {
    val out = field.constraints.foldLeft(new StringBuilder) { (builder, constraint) =>
      constraint._1 match {
        case "constraint.required" => builder.append(" required")
        case "constraint.max" => builder.append(constraintValue("max", constraint._2.headOption))
        case "constraint.min" => builder.append(constraintValue("min", constraint._2.headOption))
        case "constraint.maxLength" => builder.append(constraintValue("maxlength", constraint._2.headOption))
        case "constraint.minLength" => builder.append(constraint._2.headOption.map(value => Html(s""" pattern=".{$value,}"""")).getOrElse(Html("")))
        case "constraint.pattern" => builder.append((constraint._2.headOption.map(value => value match {
          //for scala pattern
          case f: Function0[Any] => constraintValue("pattern", Option(f.apply().toString))
          //for java @Pattern
          case value: String => constraintValue("pattern", Option(value))
        }).getOrElse(new Html(""))))
        case _ => builder
      }
    }
    Html(out.toString)
  }

  private def constraintValue(label: String, value: Option[Any]) = {
    val out = value.map(v => s""" $label="$v"""")
    Html(out.getOrElse(""))
  }
}
