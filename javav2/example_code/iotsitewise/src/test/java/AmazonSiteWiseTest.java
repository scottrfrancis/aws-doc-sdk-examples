/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import software.amazon.awssdk.regions.Region;
import java.io.*;
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
    @Order(0)
    public void whenInitializingAWSIoTSiteWiseService_thenNotNull() {
        assertNotNull(sitewise);
        System.out.println("Test 0 (setup) - SiteWise Client Setup passed");
    }

    @Test
    @Order(1)
    public void ListAssets() {
        assertNotNull(ListAssets.listTopLevelAssets(sitewise));
        System.out.println("Test 1 - Top Level Asset List passed");
    }

}
