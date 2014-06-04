name := "html5Tags"

version := "1.2.0"

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
	"com.typesafe.play" %% "play" % "2.3.0"
	//"com.typesafe.play" %% "twirl-api" % "1.0.0"
)

organization := "com.loicdescotte.coffeebean"
