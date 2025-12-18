# LoaderObj - Utilidad para revisar archivos .obj

Este script es una utilidad **separada** del proyecto principal para revisar los archivos `.obj` generados por `FlightsLoaderApp`.

## ⚠️ Importante

- **NO está incluido en el JAR principal** (`flights_loader.jar`)
- Es solo una herramienta de desarrollo/debugging
- No afecta la compilación ni el JAR del proyecto

## Cómo usar

### Opción 1: Desde sbt (recomendado)

```bash
# Compilar primero el script
scalac -cp "../target/scala-2.13/classes:../target/scala-2.13/flights_loader.jar" -d ../target/scala-2.13/classes LoaderObj.scala

# Ejecutar
cd ..
sbt "runMain org.ntic.flights.LoaderObj ABE_delayed.obj"
```

### Opción 2: Compilar y ejecutar manualmente

```bash
# Desde la raíz del proyecto
scalac -cp "target/scala-2.13/classes:target/scala-2.13/flights_loader.jar" -d target/scala-2.13/classes scripts/LoaderObj.scala

# Ejecutar
java -cp "target/scala-2.13/classes:target/scala-2.13/flights_loader.jar" org.ntic.flights.LoaderObj ABE_delayed.obj
```

### Opción 3: Usar desde sbt directamente (más simple)

```bash
# Desde la raíz del proyecto, copiar temporalmente a src/main/scala
cp scripts/LoaderObj.scala src/main/scala/
sbt "runMain org.ntic.flights.LoaderObj ABE_delayed.obj"
# Luego eliminar si quieres: rm src/main/scala/LoaderObj.scala
```

## Ejemplos

```bash
# Ver vuelos retrasados de ABE
sbt "runMain org.ntic.flights.LoaderObj ABE_delayed.obj"

# Ver vuelos no retrasados de ATL
sbt "runMain org.ntic.flights.LoaderObj ATL.obj"

# Ver vuelos retrasados de un aeropuerto grande
sbt "runMain org.ntic.flights.LoaderObj ATL_delayed.obj"
```

## Nota

Este script está en la carpeta `scripts/` para mantenerlo separado del código principal del proyecto. No se incluye en el JAR final.

