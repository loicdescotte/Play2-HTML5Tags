import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "html5Tags"
    val appVersion      = "1.0-RC1"

    val appDependencies = Seq(
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      organization := "com.loicdescotte.coffeebean"
    )
}
