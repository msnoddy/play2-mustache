import sbt._
import Keys._

object ApplicationBuild extends Build {
  val appName         = "play2-mustache"
  val appVersion      = "1.1.4"

  val appDependencies = Seq(
    "com.github.spullara.mustache.java" % "compiler" % "0.9.5",
    "com.github.spullara.mustache.java" % "scala-extensions-2.11" % "0.9.5",
    "org.apache.commons" % "commons-lang3" % "3.8.1"
  )

  object Resolvers {
    // publish to my local github website clone, I will push manually 
    val localRepository = Resolver.file("local repo", new java.io.File(System.getProperty("user.home") + "/tmp/repo"))(Resolver.ivyStylePatterns)
  }

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    scalaVersion := "2.11.12",
    organization := "org.jba",
    version := appVersion,
    libraryDependencies ++= appDependencies,
    publishMavenStyle := false,
    publishTo := Some(Resolvers.localRepository)
  )
}
