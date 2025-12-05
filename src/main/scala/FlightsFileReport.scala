import scala.io.Source
import scala.util.Try

/**
 * This class is used to represent a report of the flights file with the valid rows, invalid rows and the flights
 * extracted from the valid rows.
 * @param validRows: Seq[Row]
 * @param invalidRows: Seq[String]
 * @param flights: Seq[Flight]
 */
case class FlightsFileReport(validRows: Seq[Row],
                         invalidRows: Seq[String],
                         flights: Seq[Flight]
                        ) {

  override val toString: String = {
    // TODO: Implementa esta función de tal manera que devuelva un string con la siguiente información:
    //  - Número de filas válidas
    //  - Número de filas inválidas
    //  - Resumen de errores
    //     - Tipos de errores: Número de errores por tipo
    //  Cuyo resultado sea algo similar a (las triples comillas son para delimitar el resultado esperado y no deben ser devueltos):
    //  Además, asegúrate de que la información de las filas válidas e inválidas sean mostradas con un nivel de tabulación.
    //  """
    //  FlightsReport:
    //    - 585058 valid rows.
    //    - 16808 invalid rows.
    //  Error summary:
    //  <java.lang.ArrayIndexOutOfBoundsException>: 16801
    //  <java.lang.ArrayIndexOutOfBoundsException: 12>: 1
    //  <java.lang.ArrayIndexOutOfBoundsException: 9>: 6
    //  """
    //  Pista: puedes usar `groupBy` de las colecciones
    //  Pista: puedes usar `map` de las colecciones
    //  Pista: puedes usar `mkString` de las colecciones para concatenar los elementos de una colección en un string con un separador dado (ver https://www.scala-lang.org/api/current/scala/collection/Iterable.html#mkString-fffff2ca)
    //  Pista: para obtener el nombre de la clase de un objeto puedes usar `getClass.getSimpleName`
    ???
  }
}

object FlightsFileReport {
  /**
   * This function is used to create a FlightsFileReport from a list of Try[Row] objects where each Try[Row] represents a row
   * loaded from the file. If the row is valid, it is added to the validRows list, otherwise the error message is added to
   * the invalidRows list. Finally, the valid rows are converted to Flight objects and added to the flights list.
   *
   * @param rows: Seq[Try[Row]]
   * @return FlightsFileReport
   */
  def fromRows(rows: Seq[Try[Row]]): FlightsFileReport = {
    // TODO: Implementa esta función de tal manera que devuelva un FlightsFileReport con las filas válidas, inválidas y los vuelos
    //  extraídos de las filas válidas.
    //  Pista: puedes usar `filter` de las colecciones
    //  Pista: puedes usar `map` de las colecciones
    //  Pista: puedes usar `isSuccess` de Try para comprobar si el Try es un Success
    //  Pista: puedes usar `get` de Try para obtener el valor de un Success
    //  Pista: puedes usar `isFailure` de Try para comprobar si el Try es un Failure
    //  Pista: puedes usar `failed` de Try para obtener el error de un Failure
    //  Pista: puedes usar `fromRow` de Flight para crear un Flight a partir de una Row
    ???
  }
}
