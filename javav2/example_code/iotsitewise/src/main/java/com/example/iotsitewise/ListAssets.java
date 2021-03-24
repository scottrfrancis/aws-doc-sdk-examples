/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
package com.example.iotsitewise;

import com.awslabs.resultsiterator.implementations.ResultsIteratorAbstract;
import io.vavr.collection.Stream;
import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient;
import software.amazon.awssdk.services.iotsitewise.model.AssetSummary;
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsFilter;
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsRequest;

import static java.lang.System.out;

public class ListAssets {
    public static void main(String[] args) {
        IoTSiteWiseClient iotSiteWiseClient = IoTSiteWiseClient.create();

        ListAssetsRequest listAssetsRequest = ListAssetsRequest.builder()
                // Request only the top level assets
                .filter(ListAssetsFilter.TOP_LEVEL)
                .build();

        Stream<AssetSummary> topLevelAssetStream = new ResultsIteratorAbstract<AssetSummary>(iotSiteWiseClient, listAssetsRequest) {
        }.stream();

        if (topLevelAssetStream.isEmpty()) {
            out.println("No top level assets present");
            return;
        }

        out.println("Top level assets list:");

        topLevelAssetStream
                // Convert the asset summaries to strings
                .map(AssetSummary::toString)
                // Print them
                .forEach(out::println);
    }
}
