name := "html5Tags"

version := "1.2.2-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

libraryDependencies ++= Seq(
	"com.typesafe.play" %% "play" % "2.4.3"
)

// Automatically import PlayMagic
TwirlKeys . templateImports += "play.api.templates.PlayMagic._"

organization := "com.loicdescotte.coffeebean"
