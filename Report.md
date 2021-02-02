Report
------------
SWE261 Project 1\
Team Name: Cambodia Warriors\
Team Member: Ziyun Yang, Peng Luo, Zhenyu Zhang\
Github: https://github.com/ZiyunYang/SWE261Assignment1


Questions:\
(1). What is the tool that you are testing? What is its purpose? Any other aspects that are relevant: size in terms of LOC, languages that it is written in, etc.
+ The tool we are testing is Apache Commons Lang (https://github.com/apache/commons-lang) . Apache Commons Lang, a package of Java utility classes for the classes that are in java.lang's hierarchy, or are considered to be so standard as to justify existence in java.lang[1]
+ It contains 13 packages to provide highly reusable static utility methods, chiefly concerned with adding value to the java.lang classes.
+ Packages are shown below[2]:\
    ![image](https://github.com/ZiyunYang/SWE261Assignment1/blob/master/src/pics/pic1.png)

+ LOC and Language:\
    ![image](https://github.com/ZiyunYang/SWE261Assignment1/blob/master/src/pics/pic2.png) 
    <br />
          
(2). Document its build. What did you need to do to get it built and running?\
+ The whole project is a library, and the file structure is shown as below:\
    ![image](https://github.com/ZiyunYang/SWE261Assignment1/blob/master/src/pics/pic3.png) 
    <br />
    <br />
+ Build:
```xml
  Clone the repository into the local
  Use IDE such as IDEA to import the project as a maven project
  Right Click at the pom.xml file and choose Maven-> Reload Project
```

+ Run:
```xml
  In a Maven project, open pom.xml and add following code:  
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
      <version>3.11</version>
    </dependency>
```

+ The all Junit Test files are under the directory ?src/test/java/org.apache.commons.lang3?. To implement the test, just run the Junit test here.

(3). Document the existing test cases (JUnit or otherwise). This should be a study of the existing testing practices and frameworks that are used already in the system. (This section might evolve as we learn more throughout the quarter.) How do you run them?

+ The test cases are in the src/test folder. This project uses the JUNIT framework to test all test files. Each subfolder relates to one package in src. ./test/builds contains builder package tests.
  Other subfolders like ./test/compare, ./test/concurrent, ./test/event, ./test/exception, ./test/function, ./test/math, ./test/mutable, ./test/reflect, ./test/stream. Other cases can be divided into these groups like ArrayUtilsTest , CharUtilsTest , ClassUtilsTest, EnumUtilsTest, RandomUtilsTest, StringUtilsTest, ThreadUtilsTest and SystemUtilsTest. These *UtilsTests correspond  to each *Utils class. The StringUtilsTest verifies many functionality on different test cases. It can be runned when clicking the Run button on IDEA or inputting the command line as below.
    ![image](https://github.com/ZiyunYang/SWE261Assignment1/blob/master/src/pics/pic4.png) 
    <br />
    
+ The cases can be runned by using the maven command line:  
  mvn clean install -Drat.numUnapprovedLicenses=100  
  The result is shown on the screenshot below.  
    ![image](https://github.com/ZiyunYang/SWE261Assignment1/blob/master/src/pics/pic5.png) 
    <br /> 

(4). Partitioning: First, motivate the need for systematic functional testing and partition testing. Describe these concepts. Then, select a feature that allows for partitioning. Specify your partitions (and boundaries when appropriate) in English ? describe them. Then, write new test cases in JUnit, and describe and document those test cases and how they run.  
+ systematic functional testing:
  Functional testing is also called ?blackbox? testing, because we see the program as a black box ? that is, we ignore how it is being written. Functional testing applies at all granularity levels which is necessary to the program. Functional testing is better than other forms of testing (particularly structural testing) for missing logic faults.
  ?Systematic? means we select valuable test cases to test the feature, rather than randomly selecting the input. It improves the efficiency of testing and saves the cost.
  The picture below shows the progress of systematic functional testing[3].  
      ![image](https://github.com/ZiyunYang/SWE261Assignment1/blob/master/src/pics/pic6.png) 
      <br /> 
      
+ Partition testing: separates the input space into classes whose union is the entire space.
  In most cases, failures are sparse in most spaces but dense in some specific spaces. In partitio testing, we test each category,and boundaries between categories.
+ The feature that we choose for partitioning is ?public static String capitalize(final String str)? at StringUtils.java. Its function is to capitalize a String changing the first character to title case with no other characters changed. For example, when this method takes in a String ?cat?, it will return ?Cat?.
+ We partitioned by separating input value(String) by Null or not,  the different types of first character(lowercase character, uppercase character, number, symbol and so on), the length of the input String(0, 0-Integer_MAX_VALUE, Integer.MAX_VALUE), the decoding type of the Input String( unicode String , GBK, UTF-8). 
  The Junit test File we created is SWE261PTest under the Test directory. It has four Junit test methods in it.
   
   
Reference
------------  
1. https://github.com/apache/commons-lang
2. http://docs.glngn.com/latest/api/org.apache.commons.commons-lang3/index.html
3. https://people.eecs.ku.edu/~saiedian/810/Readings/testing-functional.pdf (page 16)