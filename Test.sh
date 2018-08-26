#!/bin/bash

projectLocation=/Users/sharif/Desktop/Automation/Deliver/NeonMob
cd $projectLocation
classpath=$projectLocation/lib/*:$projectLocation/target/classes
java -cp $classpath org.testng.TestNG $projectLocation/TestNg.xml
