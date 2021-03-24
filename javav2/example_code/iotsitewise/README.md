# Amazon IoT SiteWise Java code examples

Samples of using the AWS Java v2 SDK with IoT SiteWise

Summary of examples:
* `ListAssets` : lists the `TOP_LEVEL` assets. Compare with results from CLI:

```bash
aws iotsitewise list-assets --filter TOP_LEVEL
```

## Running the Amazon IoT SiteWise Java files

**IMPORTANT**

The Java examples perform AWS operations for the account and AWS Region for which you've specified credentials, and you may incur AWS service charges by running them. See the [AWS Pricing page](https://aws.amazon.com/pricing/) for details about the charges you can expect for a given service and operation.   

Some of these examples perform *destructive* operations on AWS resources. **Be very careful** when running an operation that deletes or modifies AWS resources in your account. It's best to create separate test-only resources when experimenting with these examples.

To run these examples, you can setup your development environment to use Apache Maven or Gradle to configure and build AWS SDK for Java projects. For more information, see 
see [Get started with the AWS SDK for Java 2.x](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html). 


 ## Testing the Amazon IoT SiteWise Java files

You can test the Amazon IoT SiteWise Java code examples by running a test file named **AmazonSiteWiseTest**. This file uses JUnit 5 to run the JUnit tests and is located in the **src/test/java** folder. For more information, see [https://junit.org/junit5/](https://junit.org/junit5/).

You can execute the JUnit tests from a Java IDE, such as IntelliJ, or from the command line by using Maven. As each test is executed, you can view messages that inform you if the various tests succeed or fail. For example, the following message informs you that Test 3 passed.

	Test 3 passed

**WARNING**: _Running these JUnit tests manipulates real Amazon IoT SiteWise resources and may incur charges on your account._

### Command line

To execute the JUnit tests from the command line, you can use the following command.

		mvn test

You will see output from the JUnit tests, as shown here.

	[INFO] -------------------------------------------------------
	[INFO]  T E S T S
	[INFO] -------------------------------------------------------
	[INFO] Running AmazonIoT SiteWiseTest
	Running Amazon IoT SiteWise Test 1
	Running Amazon IoT SiteWise Test 2
	...
	Done!
	[INFO] Results:
	[INFO]
	[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
	[INFO]
	INFO] --------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO]--------------------------------------------
	[INFO] Total time:  12.003 s
	[INFO] Finished at: 2020-02-10T14:25:08-05:00
	[INFO] --------------------------------------------

### Unsuccessful tests

If you do not define the correct values in the properties file, your JUnit tests are not successful. You will see an error message such as the following. You need to double-check the values that you set in the properties file and run the tests again. Also, ensure that you specify the correct resource name in the **Sample policy** text file, and the correct owner ID value (you can retrieve this value from the AWS Management Console).

	[INFO]
	[INFO] --------------------------------------
	[INFO] BUILD FAILURE
	[INFO] --------------------------------------
	[INFO] Total time:  19.038 s
	[INFO] Finished at: 2020-02-10T14:41:51-05:00
	[INFO] ---------------------------------------
	[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.1:test (default-test) on project IoT SiteWiseJ2Project:  There are test failures.
	[ERROR];

### Make and runner

A Makefile is included to build a jar from the sources as well.  To build,

```bash
make
```

Then run an individual class with

```bash
./run_exmample <ClassName>  # e.g. ListAssets
```

### Environment

These samples have been developed on MacOS with Corretto 15 and Maven 3.6.3. Other compatible JDKs and OS's should work fine, but have not yet been validated.