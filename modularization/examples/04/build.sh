
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
## -m client/com.myorg.client.ClientApp: Runs the main class com.myorg.client.ClientApp from the client module.
java -p output/mlib -m com.myorg.theClient/com.myorg.theClient.ClientApp
