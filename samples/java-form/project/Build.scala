import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "java-form"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    javaCore
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
  ).dependsOn(RootProject(file("../../"))) 

}
