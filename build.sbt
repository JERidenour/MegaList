name := "MegaList"

version := "1.0"

scalaVersion := "2.12.2"

lazy val root = Project("root", file(".")) dependsOn(scalaGraphvizProject)
lazy val scalaGraphvizProject = RootProject(uri("git://github.com/JERidenour/ScalaGraph.git"))

//libraryDependencies += "com.github.whatever" %% "etc" % "etc"
