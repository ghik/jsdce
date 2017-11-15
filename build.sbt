import org.scalajs.core.tools.sem.Semantics.RuntimeClassNameMapper

inThisBuild(Seq(
  scalaVersion := "2.12.4",
  crossScalaVersions := Seq("2.11.11", "2.12.4"),
  scalacOptions ++= Seq(
    "-encoding", "utf-8",
    "-explaintypes",
    "-feature",
    "-deprecation",
    "-unchecked",
    "-language:implicitConversions",
    "-language:existentials",
    "-language:dynamics",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-Xfuture",
    "-Xfatal-warnings",
    "-Xlint:-missing-interpolator,-adapted-args,-unused,_",
  ),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
))

val commonsVersion = "1.24.0"

lazy val macros = project
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "com.avsystem.commons" %% "commons-macros" % commonsVersion,
    )
  )

lazy val jsdce = crossProject
  .jsConfigure(_.dependsOn(macros))
  .jvmConfigure(_.dependsOn(macros))
  .settings(
    name := "jsdce",
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "com.avsystem.commons" %%% "commons-shared" % commonsVersion,
      "org.scalatest" %%% "scalatest" % "3.0.4" % Test,
    ),
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSSemantics := scalaJSSemantics.value.withRuntimeClassNameMapper(RuntimeClassNameMapper.discardAll),
  )
  .jvmSettings(
  )

lazy val jsdceJVM = jsdce.jvm
lazy val jsdceJS = jsdce.js
