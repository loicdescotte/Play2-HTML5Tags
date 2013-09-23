name := "scala-form"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.loicdescotte.coffeebean" % "html5tags_2.10" % "1.1.1-SNAPSHOT"
)     

resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/releases/"))(Resolver.ivyStylePatterns)

play.Project.playScalaSettings
