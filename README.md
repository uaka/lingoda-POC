I made audit of wdio tests for Lingoda and found next limitations:
- autotests were not maintained for several months and 90% of tests fail
- no debug mode
- no logs 
- no reports
- no screenshots
- no stacktrace!
- hard to read the code
- not compatible with Windows OS

I was absolutely blinded and disappointed trying to debug them

So I decided to start new automation proj from scratch
And created this small proof-of-concept test for register new student and make a payment

_______


Requerments:

OS: Win/Mac/Unix

Java: 11

Maven: 3+

Chrome: 76


Ask me to give you PropertiesConfiguration.java file
paste it to src/main/java/config/PropertiesConfiguration.java

To run test on browserstack run

mvn clean test -Dtest=tests.student.MakePayment -Dplatform=browserstack 

or To run test on browserstack run

mvn clean test -Dtest=tests.student.MakePayment -Dplatform=local


mvn clean test -Dsuite=student