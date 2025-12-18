package org.ntic.flights

import org.ntic.flights.data.Flight
import org.ntic.flights.FlightsLoaderConfig

import java.io._

object LoaderObj extends App {
  
  // Puedes cambiar el nombre del archivo aquí o pasarlo como argumento
  val fileName = if (args.length > 0) args(0) else "ABE_delayed.obj"
  val filePath = s"${FlightsLoaderConfig.outputDir}/$fileName"

  println(s"Leyendo archivo: $filePath")
  
  try {
    val file = new File(filePath)
    if (!file.exists()) {
      println(s"Error: El archivo no existe: $filePath")
      sys.exit(1)
    }
    
    // Usar ObjectInputStream con el classloader correcto
    val fis = new FileInputStream(filePath)
    val in = new ObjectInputStream(fis) {
      override def resolveClass(desc: java.io.ObjectStreamClass): Class[_] = {
        try {
          Class.forName(desc.getName, false, Thread.currentThread().getContextClassLoader)
        } catch {
          case _: ClassNotFoundException => super.resolveClass(desc)
        }
      }
    }
    val flights: Seq[Flight] = in.readObject().asInstanceOf[Seq[Flight]]
    in.close()

    println(s"Total de vuelos: ${flights.size}")
    println("-" * 80)
    
    // Mostrar los primeros 10 vuelos
    flights.take(10).foreach(flight => {
      println(s"Flight: ${flight.origin.code} -> ${flight.dest.code}")
      println(s"  Date: ${flight.flightDate}")
      println(s"  Scheduled Dep: ${flight.scheduledDepTime}, Actual Dep: ${flight.actualDepTime}")
      println(s"  Scheduled Arr: ${flight.scheduledArrTime}, Actual Arr: ${flight.actualArrTime}")
      println(s"  Delays: Dep=${flight.depDelay}, Arr=${flight.arrDelay}, IsDelayed=${flight.isDelayed}")
      println("-" * 80)
    })
    
    if (flights.size > 10) {
      println(s"... y ${flights.size - 10} vuelos más")
    }
    
    // Estadísticas
    val delayedCount = flights.count(_.isDelayed)
    val notDelayedCount = flights.size - delayedCount
    println(s"\nEstadísticas:")
    println(s"  - Vuelos retrasados: $delayedCount")
    println(s"  - Vuelos no retrasados: $notDelayedCount")
    
  } catch {
    case e: FileNotFoundException => 
      println(s"Error: No se encontró el archivo $filePath")
    case e: Exception => 
      println(s"Error al leer el archivo: ${e.getMessage}")
      e.printStackTrace()
  }
}

