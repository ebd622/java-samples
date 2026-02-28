/bin/rm -rf output

# Create output directories
mkdir -p output/mlib
mkdir -p output/classes

# Compile and package the first module (first.jar)
javac -d output/classes `find firstAPI -name \*.java`
jar -c -f output/mlib/first.jar -C output/classes .

/bin/rm -rf output/classes
mkdir -p output/classes

# Compile and package the app module (app.jar)
javac -d output/classes -p output/mlib `find app -name \*.java`
jar -c -f output/mlib/app.jar -C output/classes .

echo "\n--- Modules that run in classpath run under unnamed module ---"
java -classpath output/mlib/first.jar:output/mlib/app.jar com.myorg.app.Application

echo "\n--- Modules that run in module path run under their own explicitly name module---"
java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application

#echo "\n---Classpath is slow fail---"
#/bin/rm -rf output/mlib/first.jar
#java -classpath output/mlib/first.jar:output/mlib/app.jar com.myorg.app.Application

#echo "\n---module-path is fast fail---"
#java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application
