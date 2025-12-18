
package org.ntic.flights.data

import java.time.LocalDate
import com.sun.media.sound.InvalidFormatException

/**
 * This class is used to represent a date of a flight
 *
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
  override lazy val toString: String = f"$day%02d/$month%02d/$year%04d"
}

object FlightDate {
  /**
   * This function is used to convert a string to a FlightDate
   * @param month: Int
   * @param day: Int
   * @param year: Int
   * @return Boolean
   */

  private def validateDate(month: Int, day: Int, year: Int): Boolean = {
    (1 <= month && month <= 12) && (1 <= day && day <= 31) && (1987 <= year && year <= LocalDate.now().getYear)
  }



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
    require(date.contains("/"), "A valid input must contains a / character ")
    val currentYear: Int = LocalDate.now().getYear
    date.split(" ").head.split("/").map(x => x.toInt).toList match {
      // TODO: Define el patrón de descomposición y reemplazas: reemplazaEstePatron
      // Ten en cuenta el formato en el que llegan las fechas en el dataset:
      // TODO: Comprueba que el día, mes y año son correctos y si lo son devuelve
                                  //    un objeto de FlightDate con esos valores.
                                  //    Si no son correctos asegúrate que el programa lance lanza una excepción
                                  //    de tipo `AssertionError` con el mensaje adecuado.
                                  //  Pista: Ten en cuenta que según la documentación del dataset, el año mínimo es 1987
      case List(month, day, year) if validateDate(month, day, year) =>FlightDate(day, month, year)
      case List(month, day, year) if month < 1 || month > 12 => throw new AssertionError(s"Invalid $month: Month must be between 1 and 12")
      case List(month, day, year) if day < 1 || day > 31 => throw new AssertionError(s"Invalid $day: Day must be vetween 1 and 31")
      case List(month, day,year) if year < 1987 || currentYear < year => throw new AssertionError(s" Invalid $year: Year must be between 1987 and $currentYear")
      case _ => throw new InvalidFormatException(s"$date tiene un formato inválido")
    }
  }
}
