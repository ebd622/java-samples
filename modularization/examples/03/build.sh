
/bin/rm -rf output

# Create output directories
mkdir -p output/mlib
mkdir -p output/classes

# Compile and package the first module (first.jar)
javac -d output/classes -classpath output/mlib `find firstAPI -name \*.java`
jar -c -f output/mlib/first.jar -C output/classes .

/bin/rm -rf output/classes
mkdir -p output/classes

# Compile and package the client module (client.jar)
javac -d output/classes -classpath output/mlib/first.jar `find client -name \*.java`
jar -c -f output/mlib/client.jar -C output/classes .

echo "--- All code running from the classpath belong to the one [unnamed module] ---"

# Run the client application
java -classpath output/mlib/first.jar:output/mlib/client.jar com.myorg.client.ClientApp

echo ""
echo "--- All old code running from the modulepath belong to their own automatic module ---"
## -p output/mlib: Sets the module path to the output/mlib directory, where modular JARs are located.
## -m client/com.myorg.client.ClientApp: Runs the main class com.myorg.client.ClientApp from the client module.
java -p output/mlib -m client/com.myorg.client.ClientApp
