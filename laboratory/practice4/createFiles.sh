#!/bin/bash

# Cambia al directorio de 'practice4' (ajusta la ruta según sea necesario)
cd /ruta/a/tu/proyecto/practice4

# Crea la estructura de directorios
mkdir -p TortilleriaAlgorithm/src/main/java/kas/concurrrente
mkdir -p TortilleriaAlgorithm/src/test/java/kas/concurrrente

# Crea los archivos Java y pom.xml
touch TortilleriaAlgorithm/src/main/java/kas/concurrrente/Main.java
touch TortilleriaAlgorithm/src/main/java/kas/concurrrente/StampedSnap.java
touch TortilleriaAlgorithm/src/main/java/kas/concurrrente/WFSnapshot.java
touch TortilleriaAlgorithm/src/test/java/kas/concurrrente/WFSnapshotTest.java
touch TortilleriaAlgorithm/pom.xml

# Imprime un mensaje para confirmar que la estructura se ha creado
echo "La estructura de directorios y archivos para TortilleriaAlgorithm ha sido creada exitosamente."
