case class Time(hours: Int, minutes: Int) extends Ordered[Time] {
  require(hours >= 0 && hours <= 23, "hours must be within 0 and 23")
  require(minutes >= 0 && minutes <= 59, "minutes must be within 0 and 59")
  val asMinutes: Int = hours * 60 + minutes
  override lazy val toString: String = f"$hours%02d:$minutes%02d"

  def minus(that: Time): Int =
    this.asMinutes - that.asMinutes

  def -(that: Time): Int =
    minus(that)

  override def compare(that: Time): Int =
    this - that
}

object Time {

  private val totalMinutesInADay = 1440

  /**
   * This function is used to create a Time object from a string
   * @param timeStr: String
   * @return Time
   */
  def fromString(timeStr: String): Time = {
    val formatted: String = ??? // TODO: Formatea la variable `timeStr` para que tenga 4 caracteres, añadiendo ceros a
                                //  la izquierda si es necesario
    val hours: Int = ???  // TODO: Extraer las horas de la variable `formatted`, que es un String de 4 caracteres: HHMM
                          //  Pista: puedes usar el método `substring` de la clase String,
                          //    revisa el dataset para entender el formato de la variable
                          //  Pista: puedes usar el método `toInt` de la clase String
                          //  Pista: recuerda que las horas deben estar entre 0 y 23
    val minutes: Int = ???  // TODO: Extraer los minutos de la variable `formatted`, que es un String de 4 caracteres: HHMM
                            //  Pista: puedes usar el método `substring` de la clase String,
                            //    revisa el dataset para entender el formato de la variable
                            //  Pista: puedes usar el método `toInt` de la clase String
                            //  Pista: recuerda que los minutos deben estar entre 0 y 59
    ??? // TODO: Devuelve un objeto Time con las horas y minutos extraídos
  }

  def fromMinutes(minutes: Int): Time = {
    val normalized = if (minutes < 0) 0 else minutes % totalMinutesInADay
    Time(normalized / 60, normalized % 60)
  }
}