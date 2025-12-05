import scala.util.Try

/**
 * This class is used to represent a row of the flights data. It contains the following fields:
 * @param flDate: String
 * @param originAirportId: Long
 * @param origin: String
 * @param originCityName: String
 * @param originStateAbr: String
 * @param destAirportId: Long
 * @param dest: String
 * @param destCityName: String
 * @param destStateAbr: String
 * @param depTime: String
 * @param depDelay: Double
 * @param arrTime: String
 * @param arrDelay: Double
 */
case class Row (
                 flDate: String,
                 originAirportId: Long,
                 origin: String,
                 originCityName: String,
                 originStateAbr: String,
                 destAirportId: Long,
                 dest: String,
                 destCityName: String,
                 destStateAbr: String,
                 depTime: String,
                 depDelay: Double,
                 arrTime: String,
                 arrDelay: Double
               )

object Row {
  /**
   * This method is used to create a Row object from a list of tokens. It returns a Try[Row] object.
   * If the list of tokens is not valid or any of the token is invalid, it returns a Failure object. Otherwise, it returns a Success object.
   *
   * @param tokens: Seq[String]
   * @return Try[Row]
   */
  def fromStringList(tokens: Seq[String]): Try[Row] = {
    // TODO: Implementar el método fromStringList que recibe una lista de tokens y devuelve un Try[Row]
    //  Si la lista de tokens no es válida o alguno de los tokens no es válido, devuelve un objeto Failure.
    //  En caso contrario, devuelve un objeto Success.
    //  Pista: usa Try.apply para crear un objeto Try
    //  Pista: usa toLong de la clase String para convertir un String a Long
    //  Pista: usa toDouble de la clase String para convertir un String a Double
    //  Pista: usa trim de la clase String para eliminar los espacios en blanco al principio y al final de un String
    //  Pista: usa apply de la clase Row para crear un objeto Row
    //  Pista: para acceder a los elementos de la lista de tokens, usa apply del objeto Seq
    ???

  }
}