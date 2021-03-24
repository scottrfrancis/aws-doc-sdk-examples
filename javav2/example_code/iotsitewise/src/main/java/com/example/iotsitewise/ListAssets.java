/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
package com.example.iotsitewise;

import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient;
import software.amazon.awssdk.services.iotsitewise.model.*;

import java.util.List;
import static java.lang.System.out;
import static java.lang.System.err;

public class ListAssets {

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
            out.println("\n\ncompare above output with \n\n" +
                    "    aws iotsitewise list-assets --filter TOP_LEVEL\n\n");
        } catch (NoAssetsException e) {
            out.println("No top level assets present");
        } finally {
            out.println("closing client");
            sitewise.close();
        }
    }

    public static ListAssetsResponse listTopLevelAssets(IoTSiteWiseClient sitewise) {
        out.println("Listing Assets");
        ListAssetsResponse listAssetsResponse = null;
       try {
            ListAssetsRequest listAssetsRequest = ListAssetsRequest
                    .builder()
                    .filter(ListAssetsFilter.TOP_LEVEL)
                    .build();

             listAssetsResponse = sitewise.listAssets(listAssetsRequest);
        } catch (IoTSiteWiseException e) {
            err.println(e.awsErrorDetails().errorMessage());
        }
        return listAssetsResponse;
    }
}
