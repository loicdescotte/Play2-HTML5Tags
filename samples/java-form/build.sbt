name := "javaForm"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.loicdescotte.coffeebean" % "html5tags_2.10" % "1.1.1-SNAPSHOT"
)

resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/releases/"))(Resolver.ivyStylePatterns)

play.Project.playJavaSettings
