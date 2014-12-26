rm -rf build/src
mkdir build/src
mkdir build/src/main
mkdir build/src/main/java
mkdir build/src/main/webapp
cp -rf ParkKoUtil/src/*  build/src/main/java
cp -rf ParkKoWeb/src/*  build/src/main/java
cp -rf ParkKoWeb/WebContent/*  build/src/main/webapp
rm -rf build/src/main/webapp/WEB-INF/lib
cd build
mvn clean test install