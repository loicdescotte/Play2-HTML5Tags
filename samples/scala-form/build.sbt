name := "scala-form"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  //"com.loicdescotte.coffeebean" %% "html5tags" % "1.2.0",
  specs2 % Test
)

lazy val lib = RootProject(file("../.."))

val main = Project(id = "application", base = file(".")).enablePlugins(PlayScala).dependsOn(lib)

resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/Play2-HTML5Tags/releases/"))(Resolver.ivyStylePatterns)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

routesGenerator := InjectedRoutesGenerator
