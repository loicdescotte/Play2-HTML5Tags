package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import org.fluentlenium.core.filter.FilterConstructor._


/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
 class IntegrationSpec extends Specification {

 	"Application" should {

 		"work from within a browser" in {
 			running(TestServer(3333), HTMLUNIT) { browser =>
 				browser.goTo("http://localhost:3333/")
 				browser.$("form input", withName("name")).first.getAttribute("required") must equalTo("true")
 				browser.$("form input", withName("name")).first.getAttribute("pattern") must equalTo(".{2,}")
 				browser.$("form input", withName("name")).first.getAttribute("maxLength") must equalTo("10")

 				browser.$("form input", withName("email")).first.getAttribute("required") must equalTo("true")
 				browser.$("form input", withName("email")).first.getAttribute("type") must equalTo("email")

 				browser.$("form input", withName("age")).first.getAttribute("max") must equalTo("99")
				browser.$("form input", withName("age")).first.getAttribute("min") must equalTo("18")
				browser.$("form input", withName("age")).first.getAttribute("type") must equalTo("number")
 				browser.$("form input", withName("age")).first.getAttribute("required") must equalTo(null)
 				
 				browser.$("form input", withName("password")).first.getAttribute("type") must equalTo("password")
 				browser.$("form input", withName("password")).first.getAttribute("pattern") must equalTo("""/^[a-z0-9_]$/i""")
 			}

 		}

 	}
 }