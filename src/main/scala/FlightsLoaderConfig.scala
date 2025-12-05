 // TODO: Para que esta clase funcione, debes añadir la dependencia
                                                   //  de typesafe config en build.sbt
object FlightsLoaderConfig {
  val config: Config = ??? // TODO: Carga el fichero de configuración de la aplicación y obtén la configuración para el
                           //  objeto flightsLoader
  val filePath: String = ???  // TODO: Obtén el valor de filePath del fichero de configuración
  val hasHeaders: Boolean = ??? // TODO: Obtén el valor de hasHeaders del fichero de configuración
  val headersLength: Int = ???  // TODO: Obtén el valor de headersLength del fichero de configuración
  val delimiter: String = ??? // TODO: Obtén el valor de delimiter del fichero de configuración
  val outputDir: String = ??? // TODO: Obtén el valor de outputDir del fichero de configuración
  val headers: List[String] = ??? // TODO: Obtén el valor de headers del fichero de configuración
                                  //  Pista: usa getStringList de la clase Config para obtener una lista de strings y
                                  //  conviértela a una lista de scala
                                  //
  val columnIndexMap: Map[String, Int] = headers.map(x => (x, headers.indexOf(x))).toMap
  val filteredOrigin: List[String] = ??? // TODO: Obtén el valor de headers del fichero de configuración
                                         //  Pista: usa getStringList de la clase Config para obtener una lista de strings y
                                         //  conviértela a una lista de scala

}
