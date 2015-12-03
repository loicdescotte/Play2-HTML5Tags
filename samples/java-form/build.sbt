name := "java-form"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.loicdescotte.coffeebean" %% "html5tags" % "1.2.2",
  specs2 % Test
)

val main = Project(id = "application", base = file(".")).enablePlugins(PlayJava)

resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/Play2-HTML5Tags/releases/"))(Resolver.ivyStylePatterns)
