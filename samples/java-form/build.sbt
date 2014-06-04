name := "java-form"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  //"com.loicdescotte.coffeebean" %% "html5tags" % "1.2.0"
)     

lazy val lib = RootProject(file("../.."))

val main = Project(id = "application", base = file(".")).enablePlugins(PlayJava).dependsOn(lib)

resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/releases/"))(Resolver.ivyStylePatterns)