package org.ntic.flights
// TODO: Para que esta clase funcione, debes añadir la dependencia
                                                  //  de typesafe config en build.sbt
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import scala.jdk.CollectionConverters._

object FlightsLoaderConfig {
  val config: Config = ConfigFactory.load().getConfig("flightsLoader") // TODO: Carga el fichero de configuración de la aplicación y obtén la configuración para el
                           //  objeto flightsLoader
  val filePath: String = config.getString("filePath")  // TODO: Obtén el valor de filePath del fichero de configuración
  val hasHeaders: Boolean = config.getBoolean("hasHeaders") // TODO: Obtén el valor de hasHeaders del fichero de configuración
  val headersLength: Int = config.getInt("headersLength")  // TODO: Obtén el valor de headersLength del fichero de configuración
  val delimiter: String = config.getString("delimiter") // TODO: Obtén el valor de delimiter del fichero de configuración
  val outputDir: String = config.getString("outputDir") // TODO: Obtén el valor de outputDir del fichero de configuración
  val headers: List[String] = config.getStringList("headers").asScala.toList // TODO: Obtén el valor de headers del fichero de configuración
                                  //  Pista: usa getStringList de la clase Config para obtener una lista de strings y
                                  //  conviértela a una lista de scala
                                  //
  val columnIndexMap: Map[String, Int] = headers.map(x => (x, headers.indexOf(x))).toMap
  val filteredOrigin: List[String] = config.getStringList("filteredOrigin").asScala.toList // TODO: Obtén el valor de headers del fichero de configuración
                                         //  Pista: usa getStringList de la clase Config para obtener una lista de strings y
                                         //  conviértela a una lista de scala

}