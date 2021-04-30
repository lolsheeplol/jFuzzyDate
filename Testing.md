## The SUT (as used in the testing process).

Can be located in the src/test/java/net/sf/jfuzzydate directory.
Faults that we discovered can be found in "faults.txt".


## Step-by-step instructions on how to run the tests

We used JUnit, its coverage tools, and PIT runner to run our blackbox, 
whitebox, and mutation tests.  ALl tools were run inside of IntelliJ, and 
the run configurations to run tests are included in the project under
".idea/runConfigurations".

### Running blackbox tests

Run the run configuration "blackbox" by selecting it from the run config 
dropdown.  This will run all tests inside the "net.sf.jfuzzydate.st" package

### Running whitebox tests

Run the run configuration "whitebox" by selecting it from the run config
dropdown.  This will run all tests inside the "net.sf.jfuzzydate.wb" package

### Running PIT mutation tests

We installed an IntelliJ plugin called PIT Runner to easily run mutation tests.
To install it, download the plugin here: https://plugins.jetbrains.com/plugin/7119-pit-mutation-testing-idea-plugin
Or, search for "PIT Runner" in the plugins window.  

Once PIT Runner has been installed, we first have to disable failing tests so that PIT can run.
Disable the following tests by commenting out the "@Test" annotation
    - `FuzzyDateFormatterTest.testFormatDurationDateInFuture()`
    - `FuzzyDateFormatterTest.testFormatDistanceInFuture()`
    - `FuzzyDateFormatterImplTest.testFormatDistanceInFuture()`

Then, run the configuration "PIT Runner" by selecting it from the run config dropdown.  

A detailed mutation test report can then be found under the "target/report/" folder.
