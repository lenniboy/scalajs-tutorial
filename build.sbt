enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.7"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.8.1"
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.8.0"

skip in packageJSDependencies := false
