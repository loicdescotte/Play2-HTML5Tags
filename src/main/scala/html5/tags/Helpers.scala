import play.twirl.api._

import scala.language.implicitConversions

import scala.collection.JavaConverters._

import views.html.helper.{FieldConstructor, FieldElements}

package html5.tags.html {

  object FieldConstructor {

    implicit val defaultField = FieldConstructor(views.html.helper.defaultFieldConstructor.f)

    def apply(f: FieldElements => Html): FieldConstructor = new FieldConstructor {
      def apply(elts: FieldElements) = f(elts)
    }

    implicit def inlineFieldConstructor(f: (FieldElements) => Html) = FieldConstructor(f)
    implicit def templateAsFieldConstructor(t: Template1[FieldElements, Html]) = FieldConstructor(t.render)

  }

  object repeat {

    def apply(field: play.api.data.Field, min: Int = 1)(f: play.api.data.Field => Html) = {
      (0 until math.max(if (field.indexes.isEmpty) 0 else field.indexes.max + 1, min)).map(i => f(field("[" + i + "]")))
    }

  }

  object options {

    def apply(options: (String, String)*) = options.toSeq
    def apply(options: Map[String, String]) = options.toSeq
    def apply(options: java.util.Map[String, String]) = options.asScala.toSeq
    def apply(options: List[String]) = options.map(v => v -> v)
    def apply(options: java.util.List[String]) = options.asScala.map(v => v -> v)

  }

}