
/bin/rm -rf output

# Create output directories
mkdir -p output/mlib
mkdir -p output/classes

# Compile and package the first module (first.jar)
javac -d output/classes `find firstAPI -name *.java`
jar -c -f output/mlib/first.jar -C output/classes .

/bin/rm -rf output/classes
mkdir -p output/classes

# Compile and package the client module (client.jar)
javac -d output/classes -p output/mlib `find client -name *.java`
jar -c -f output/mlib/client.jar -C output/classes .

## -p output/mlib: Sets the module path to the output/mlib directory, where modular JARs are located.
## -m com.myorg.theClient/com.myorg.theClient.ClientApp
java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp

echo "\n--- Modules that run in classpath run under unnamed module ---"
java -classpath output/mlib/first.jar:output/mlib/client.jar com.myorg.client.ClientApp

echo "\n--- Modules that run in module path run under their own explicitly name module---"
java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp

echo "\n---Classpath is slow fail---"
/bin/rm -rf output/mlib/first.jar
java -classpath output/mlib/first.jar:output/mlib/client.jar com.myorg.client.ClientApp

echo "\n---module-path is fast fail---"
java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp
