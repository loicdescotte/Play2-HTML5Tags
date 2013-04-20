import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "scala-form"
  val appVersion      = "1.0"

  val appDependencies = Seq(
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
  	resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.com/releases/"))(Resolver.ivyStylePatterns)
  ).dependsOn(RootProject(file("../../")))  

}
