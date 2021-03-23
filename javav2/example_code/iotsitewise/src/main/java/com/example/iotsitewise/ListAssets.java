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
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsFilter;
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsRequest;
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsResponse;
import software.amazon.awssdk.services.iotsitewise.model.IoTSiteWiseException;

import java.util.List;
import java.util.ListIterator;

public class ListAssets {

    public static void main(String[] args) {

        final String USAGE = "\n" +
                "Usage:\n" +
                "    ListAssets\n\n";

//        if (args.length != 1) {
//           System.out.println(USAGE);
//           System.exit(1);
//         }

        Region region = Region.US_WEST_2;

        IoTSiteWiseClient sitewise = IoTSiteWiseClient.builder()
                .region(region)
                .build();

        listAssets(sitewise);

        sitewise.close();
    }

    public static void listAssets(IoTSiteWiseClient sitewise) {
        System.out.println("Listing Assets");
       try {
            ListAssetsRequest listAssetsRequest = ListAssetsRequest
                    .builder()
                    .filter(ListAssetsFilter.TOP_LEVEL)
                    .build();

            ListAssetsResponse listAssetsResponse = sitewise.listAssets(listAssetsRequest);
            System.out.println("\n\nTOP_LEVEL Assets:\n\n");
            System.out.println(listAssetsResponse.toString());
            System.out.println("\n\n");
        } catch (IoTSiteWiseException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
