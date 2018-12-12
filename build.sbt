import sbt.Defaults._

name := "play2-plugins-mustache"
version := "1.1.4"
organization := "org.jba"

sbtPlugin := true
scalacOptions += "-deprecation"
publishMavenStyle := false

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.10")

libraryDependencies +=  "org.apache.commons" % "commons-lang3" % "3.8.1"
libraryDependencies += "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3"

publishTo <<= (version) { version: String =>
  val localRepository = Resolver.file("local repo", new java.io.File(System.getProperty("user.home") + "/tmp/repo"))(Resolver.ivyStylePatterns)
  Some(localRepository)
}
