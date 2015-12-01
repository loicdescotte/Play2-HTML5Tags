name := "html5Tags"

version := "1.2.2-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

lazy val javaForm = project.in(file("samples/java-form")).enablePlugins(PlayJava).dependsOn(root)

lazy val scalaForm = project.in(file("samples/scala-form")).enablePlugins(PlayScala).dependsOn(root)

libraryDependencies ++= Seq(
	"com.typesafe.play" %% "play" % "2.4.3",
	specs2 % Test
)

// Automatically import PlayMagic
TwirlKeys . templateImports += "play.api.templates.PlayMagic._"

organization := "com.loicdescotte.coffeebean"

routesGenerator := InjectedRoutesGenerator
