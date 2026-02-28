/bin/rm -rf output

# Create output directories
mkdir -p output/mlib
mkdir -p output/classes

# Compile and package the first module (first.jar)
javac -d output/classes -classpath output/mlib `find firstAPI -name \*.java`
jar -c -f output/mlib/first.jar -C output/classes .

/bin/rm -rf output/classes
mkdir -p output/classes

# Compile and package the app module (app.jar)
javac -d output/classes -classpath output/mlib/first.jar `find app -name \*.java`
jar -c -f output/mlib/app.jar -C output/classes .

echo "--- Code running from the classpath belong to the one [unnamed module] ---"

# Run the app application
java -classpath output/mlib/first.jar:output/mlib/app.jar com.myorg.app.Application

echo ""
echo "--- The same code running from the modulepath belong to their own automatic module ---"
## -p output/mlib: Sets the module path to the output/mlib directory, where modular JARs are located.
## -m app/com.myorg.app.Application: Runs the main class com.myorg.app.Application from the app module.
java -p output/mlib -m app/com.myorg.app.Application
