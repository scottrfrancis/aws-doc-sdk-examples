/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import software.amazon.awssdk.regions.Region;
import java.io.*;
import java.util.*;
import com.example.iotsitewise.*;
import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AmazonSiteWiseTest {

    private static Region region;
    private static IoTSiteWiseClient sitewise;


    @BeforeAll
    public static void setUp() throws IOException {

        // Run tests on Real AWS Resources
        region = Region.US_WEST_2;
        sitewise = IoTSiteWiseClient.builder()
                .region(region)
                .build();
    }

    @Test
    @Order(1)
    public void whenInitializingAWSIoTSiteWiseService_thenNotNull() {
        assertNotNull(sitewise);
        System.out.println("Test 1 passed");
    }


    @Test
    @Order(13)
    public void ListAssets() {
        ListAssets.listAssets(sitewise);
        System.out.println("Test 13 passed");
    }

}
