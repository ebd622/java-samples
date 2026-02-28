/bin/rm -rf output

# Create output directories
mkdir -p output/mlib
mkdir -p output/classes

# Compile and package the client module (client.jar)
javac -d output/classes -classpath output/mlib `find clientAPI -name \*.java`
jar -c -f output/mlib/client.jar -C output/classes .

/bin/rm -rf output/classes
mkdir -p output/classes

# Compile and package the app module (app.jar)
javac -d output/classes -classpath output/mlib/client.jar `find app -name \*.java`
jar -c -f output/mlib/app.jar -C output/classes .

# Run the application
java -classpath output/mlib/client.jar:output/mlib/app.jar com.myorg.app.Application
