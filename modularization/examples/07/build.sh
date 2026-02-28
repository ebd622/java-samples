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

java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application
