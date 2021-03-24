//snippet-sourcedescription:[ListObjects.java demonstrates how to list objects located in a given Amazon Simple Storage Service (Amazon S3) bucket.]
//snippet-keyword:[AWS SDK for Java v2]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon S3]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[01/07/2021]
//snippet-sourceauthor:[scmacdon-aws]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
package com.example.iotsitewise;

// snippet-start:[s3.java2.list_assets.import]
import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient;
import software.amazon.awssdk.services.iotsitewise.model.*;

import java.util.List;
import static java.lang.System.out;
import static java.lang.System.err;

public class ListAssets {

//    public static class NoAssetsException extends Exception {}

    public static void main(String[] args) {
        Region region = Region.US_WEST_2;

        final String USAGE = "\n" +
                "Usage:\n" +
                "    ListAssets <region> \n\n" +
                "Where:\n" +
                "    region is desired region - defaults to us-west-2\n\n";

        if (args.length > 0) {
            region = Region.of(args[0]);
        }

        IoTSiteWiseClient sitewise = IoTSiteWiseClient.builder()
                .region(region)
                .build();

        ListAssetsResponse topLevelAssetResponse = listTopLevelAssets(sitewise);

        class NoAssetsException extends Exception {}
        try {
            if (!topLevelAssetResponse.hasAssetSummaries()) {
                throw new NoAssetsException();
            }

            List<AssetSummary> assetSummaryList = topLevelAssetResponse.assetSummaries();
            out.println("Top level assets list:");
            assetSummaryList.forEach((i) -> {
                out.println(i.toString());
            });
        } catch (NoAssetsException e) {
            out.println("No top level assets present");
        } finally {
            out.println("closing client");
            sitewise.close();
        }
    }

    public static ListAssetsResponse listTopLevelAssets(IoTSiteWiseClient sitewise) {
        out.println("Listing Assets");
       try {
            ListAssetsRequest listAssetsRequest = ListAssetsRequest
                    .builder()
                    .filter(ListAssetsFilter.TOP_LEVEL)
                    .build();

            ListAssetsResponse listAssetsResponse = sitewise.listAssets(listAssetsRequest);
            return listAssetsResponse;
        } catch (IoTSiteWiseException e) {
            err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return null;
    }
}
