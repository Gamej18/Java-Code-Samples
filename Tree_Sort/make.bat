@echo off
cls
del *.class
javac -cp .;bst.jar *.java
cd ki
del *.class
javac KeyedItem.java
cd ..
java -cp .;bst.jar TreeSortDriver