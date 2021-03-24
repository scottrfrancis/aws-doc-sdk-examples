# Amazon IoT SiteWise Java code examples

Samples of using the AWS Java v2 SDK with IoT SiteWise

Summary of examples:

* `ListAssets` : lists the `TOP_LEVEL` assets. Compare with results from CLI:

```bash
aws iotsitewise list-assets --filter TOP_LEVEL
```

## Running the Amazon IoT SiteWise Java files

**IMPORTANT**

The Java examples perform AWS operations for the account and AWS Region for which you've specified credentials, and you
may incur AWS service charges by running them. See the [AWS Pricing page](https://aws.amazon.com/pricing/) for details
about the charges you can expect for a given service and operation.

Some of these examples perform *destructive* operations on AWS resources. **Be very careful** when running an operation
that deletes or modifies AWS resources in your account. It's best to create separate test-only resources when
experimenting with these examples.

To run these examples, you can setup your development environment to use Apache Maven or Gradle to configure and build
AWS SDK for Java projects. For more information, see
see [Get started with the AWS SDK for Java 2.x](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html)
.

### Command line

To execute the code from the command line, you can use the following command.

```
./gradlew run
```

You will see output from the sample as shown here.

If no top level assets are present:

```
No top level assets present
```

If one or more top level assets are present:

```
Top level assets list:
AssetSummary(Id=612e71b0-271a-40b5-82d5-cb1cefb6e448, Arn=arn:aws:iotsitewise:us-east-1:111111111111:asset/612e71b0-271a-40b5-82d5-cb1cefb6e448, Name=asdf, AssetModelId=4ec91df4-9265-4650-b881-84b4f256355d, CreationDate=2021-03-24T00:32:47Z, LastUpdateDate=2021-03-24T00:32:47Z, Status=AssetStatus(State=ACTIVE), Hierarchies=[])
```

### Environment

These samples have been developed on MacOS with Corretto 15. Other compatible JDKs and OS's should work fine, but have
not yet been validated.
