/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
package com.example.iotsitewise;

import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient;
import software.amazon.awssdk.services.iotsitewise.model.AssetSummary;
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsFilter;
import software.amazon.awssdk.services.iotsitewise.model.ListAssetsRequest;

import java.util.List;

import static java.lang.System.out;

public class ListAssets {
    public static void main(String[] args) {
        IoTSiteWiseClient iotSiteWiseClient = IoTSiteWiseClient.create();

        ListAssetsRequest listAssetsRequest = ListAssetsRequest.builder()
                // Request only the top level assets
                .filter(ListAssetsFilter.TOP_LEVEL)
                .build();

        List<AssetSummary> topLevelAssetList = iotSiteWiseClient
                .listAssets(listAssetsRequest)
                .assetSummaries();

        if (topLevelAssetList.isEmpty()) {
            out.println("No top level assets present");
            return;
        }

        out.println("Top level assets list:");

        topLevelAssetList.stream()
                // Convert the asset summaries to strings
                .map(AssetSummary::toString)
                // Print them
                .forEach(out::println);
    }
}
