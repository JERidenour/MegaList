name := "MegaList"

version := "1.0"

scalaVersion := "2.12.2"

lazy val scalaGraphvizProject = RootProject(uri("git://github.com/JERidenour/ScalaGraph.git"))
lazy val root = Project("root", file(".")) dependsOn(scalaGraphvizProject)

//libraryDependencies += "com.github.whatever" %% "etc" % "etc"
