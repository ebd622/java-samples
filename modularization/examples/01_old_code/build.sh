/bin/rm -rf output

mkdir -p output/mlib
mkdir -p output/classes

javac -d output/classes -classpath output/mlib `find firstAPI -name *.java`
jar -c -f output/mlib/first.jar -C output/classes .

/bin/rm -rf ouput/classes
mkdir -p output/classes

javac -d output/classes -classpath output/mlib/first.jar `find client -name *.java`
jar -c -f output/mlib/client.jar -C output/classes .

java -classpath output/mlib/first.jar:output/mlib/client.jar com.myorg.client.ClientApp

