package org.ntic.flights

import org.ntic.flights.FlightsLoaderConfig
import org.ntic.flights.data.{Flight, Row}

/*Libreria de java para gestionar directorios */
import java.io.{File, FileOutputStream, ObjectOutputStream}
import scala.util.Try
import scala.io.{BufferedSource, Source}

object FileUtils {

  /**
   * This function is used to check if the line is valid or not
   * @param s: String
   * @return Boolean: true if the line is invalid, false otherwise
   */
  def isInvalidLine(s: String): Boolean = {
    // TODO: Implementar esta función
    //  asegúrate de que el número de campos es el correcto, `s` representa una línea del csv, para ser inválido:
    //    - debe ser vacío,
    //    - tras hacer un split por el delimitador (ver FlightsLoaderConfig) el número de campos debe ser distinto al
    //      número de headers (ver FlightsLoaderConfig)
    val delimiter: String = FlightsLoaderConfig.delimiter
    val expectLength: Int = FlightsLoaderConfig.headersLength
    val values: List[String] = s.split(delimiter).toList
    s.isEmpty || values.length != expectLength
  }

  /**
   * This function is used to read the file located in the path `filePath` and return a list of lines of the file
   *
   * @param filePath: String
   * @return List[String]
   */
  def getLinesFromFile(filePath: String): List[String] = {
    // TODO: Lee el fichero que se encuentra en la ruta `filePath` y devuelve una lista de líneas del fichero
    //  Pista: usa la función fromFile de la clase Source
    val inputFile = new File(filePath)
    require(inputFile.exists(), "File should be exists")
    val source:BufferedSource = Source.fromFile(filePath)
    val lines:List[String] = source.getLines().toList

    source.close()
    lines
  }

  /**
   * This function is used to load the rows from the file lines
   *
   * @param fileLines: Seq[String]
   * @return Seq[Try[Row]]
   */
  def loadFromFileLines(fileLines: Seq[String]): Seq[Try[Row]] = {
    // TODO: Implementa esta función de tal manera que devuelva una lista de Try[Row]
    //  a partir de las líneas del fichero `fileLines`.
    //  Pista: usa map de las colecciones para generar una lista de Try[Row] a partir de las líneas del fichero `fileLines`.
    //  Pista: estás trabajando con CSV, cada línea del fichero está separado por un `delimitador`
    //  Pista: usa la función fromStringList de la clase Row para crear un objeto Row a partir de una lista de tokens.
    require(fileLines.nonEmpty, "File must contains data")
    val delimiter: String = FlightsLoaderConfig.delimiter
    val targetLines: Seq[String] =  if (FlightsLoaderConfig.hasHeaders) fileLines.tail else fileLines
    require(targetLines.nonEmpty, "File must contain data after headers")
    val rows: Seq[Try[Row]] = targetLines.map(_.split(delimiter).map(_.trim)).map(Row.fromStringList(_)).toList

    rows
  }

  def writeFile(flights: Seq[Flight], outputFilePath: String): Unit = {
    val file = new File(outputFilePath)
    file.getParentFile.mkdirs()
    val out = new ObjectOutputStream(new FileOutputStream(outputFilePath))
    try {
      out.writeObject(flights)
    } finally {
      out.close()
    }

  }
}