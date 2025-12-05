/**
 * This class is used to represent a date of a flight
 * @param day: Int
 * @param month: Int
 * @param year: Int
 */
case class FlightDate(day: Int,
                      month: Int,
                      year: Int) {
  // TODO: Sobreescribir el método toString para que devuelva la fecha en formato dd/mm/yyyy. Al sobreescribirlo haz que
  //  sea peresozo y sólo se calcule cuando se llame a toString, pero además que se calcule una única vez de forma que
  //  si se llama varias veces a toString no se vuelva a calcular.
  //  Pista: usa interpolator `f` (ver https://docs.scala-lang.org/overviews/core/string-interpolation.html)
  //  Pista: conjuga lazy y la inmutabilidad
  ???
}

object FlightDate {
  /**
   * This function is used to convert a string to a FlightDate
   * @param date: String
   * @return FlightDate
   */
  def fromString(date: String): FlightDate = {
    // TODO: el parámetro `date` es String con el formato `mm/dd/yyyy hh:mm:ss PM|AM` (compruébalo en el dataset: 7/1/2023 12:00:00 AM)
    // extrae la fecha `mm/dd/yyyy` y define un patrón que te permita extraer el mes, día y año
    // para hacer la validación.
    // Pista: usa `split`
    // Pista: obtén una lista de Int
    date match {
      // TODO: Define el patrón de descomposición y reemplazas: reemplazaEstePatron
      // Ten en cuenta el formato en el que llegan las fechas en el dataset:
      case reemplazaEstePatron => // TODO: Comprueba que el día, mes y año son correctos y si lo son devuelve
                                  //    un objeto de FlightDate con esos valores.
                                  //    Si no son correctos asegúrate que el programa lance lanza una excepción
                                  //    de tipo `AssertionError` con el mensaje adecuado.
                                  //  Pista: Ten en cuenta que según la documentación del dataset, el año mínimo es 1987
                                  ???
      case _ => throw new Exception(s"$date tiene un formato inválido")
    }
  }
}
