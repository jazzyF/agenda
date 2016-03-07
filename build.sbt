name := """agenda"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

EclipseKeys.preTasks := Seq(compile in Compile)
// Java project. Don't expect Scala IDE
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  
// Use .class files instead of generated .scala files for views and routes

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)
