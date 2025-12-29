
/bin/rm -rf output

# Create output directories
mkdir -p output/mlib
mkdir -p output/classes

# Compile and package the first module (first.jar)
javac -d output/classes -classpath output/mlib `find firstAPI -name *.java`
jar -c -f output/mlib/first.jar -C output/classes .

/bin/rm -rf ouput/classes
mkdir -p output/classes

# Compile and package the client module (client.jar)
javac -d output/classes -classpath output/mlib/first.jar `find client -name *.java`
jar -c -f output/mlib/client.jar -C output/classes .

echo "--- All code running from the classpath belong to the one [unnamed module] ---"

# Run the client application
java -classpath output/mlib/first.jar:output/mlib/client.jar com.myorg.client.ClientApp