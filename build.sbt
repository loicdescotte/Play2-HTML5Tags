name := "html5Tags"

version := "1.2.1"

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

libraryDependencies ++= Seq(
	"com.typesafe.play" %% "play" % "2.3.1"
)

// Automatically import PlayMagic
TwirlKeys . templateImports += "play.api.templates.PlayMagic._"

organization := "com.loicdescotte.coffeebean"
