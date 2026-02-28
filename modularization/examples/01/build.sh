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

# Run the app application
java -classpath output/mlib/first.jar:output/mlib/app.jar com.myorg.app.Application
