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
libraryDependencies += "org.mockito" % "mockito-core" % "1.10.19"
libraryDependencies += "org.testng" % "testng" % "6.9.10"
libraryDependencies += "org.easytesting" % "fest-assert-core" % "2.0M10"


import de.johoop.testngplugin.TestNGPlugin._

lazy val testNGVersion = settingKey[Unit]("6.9.10")
lazy val testNGOutputDirectory = settingKey[Unit]("target/testng")
lazy val testNGParameters = Seq()
lazy val testNGSuites = Seq("src/test/resources/testng.xml")

//import trafficland.opensource.sbt.plugins._

//seq(StandardPluginSet.plugs : _*)