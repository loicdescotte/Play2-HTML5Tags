// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin ( "com.typesafe.sbt" % "sbt-twirl" % "1.1.1" )

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.3")
