import sbt.Keys.libraryDependencies
import sbtassembly.AssemblyPlugin.defaultShellScript

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.15"
ThisBuild / assemblyPrependShellScript := Some(defaultShellScript)

val mainClassName = "org.ntic.flights.FlightsLoaderApp"

lazy val root = (project in file("."))
  .settings(
    name := "entregable_ivym",// TODO: establece el nombre del proyecto. Tiene que ser el mismo que el nombre que le has dado al proyecto en IntelliJ
    // TODO: define la clase principal del proyecto para la etapa `run` de `Compile`
    Compile / run / mainClass := Some(mainClassName),
    // TODO: define la clase principal del proyecto para la etapa `packageBin` de `Compile`
    Compile / packageBin / mainClass := Some(mainClassName),
    // TODO: define la clase principal del proyecto para el ensamblado de `assembly`
    assembly / mainClass := Some(mainClassName),
    // TODO: define `flights_loader.jar` como el nombre del jar que se genera en la etapa assembly
    assembly / assemblyJarName := "flights_loader.jar",

    libraryDependencies ++= Seq(
      // TODO añade la dependencia de la librería de configuración de Typesafe
      "com.typesafe" % "config" % "1.4.3",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.2",
      "org.scalatest" %% "scalatest" % "3.2.17" % Test,
      "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test
    )
  )
