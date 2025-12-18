#!/bin/bash
# Script para listar archivos a entregar

echo "=== Archivos a entregar ==="
echo ""
echo "1. build.sbt"
find . -maxdepth 1 -name "build.sbt" -type f

echo ""
echo "2. Directorio project/ (sin target/)"
find project -type f ! -path "*/target/*" ! -path "*/streams/*" ! -name "*.cache" ! -name "*.class" | sort

echo ""
echo "3. Directorio src/"
find src -type f | sort

echo ""
echo "=== Resumen ==="
echo "Total archivos build.sbt: $(find . -maxdepth 1 -name "build.sbt" -type f | wc -l)"
echo "Total archivos en project/ (sin target): $(find project -type f ! -path "*/target/*" ! -path "*/streams/*" ! -name "*.cache" ! -name "*.class" | wc -l)"
echo "Total archivos en src/: $(find src -type f | wc -l)"
