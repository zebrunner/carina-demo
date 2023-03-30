package com.qaprosoft.carina.demo;

import com.amazonaws.regions.Regions;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.amazon.AmazonS3Manager;
import com.zebrunner.carina.azure.AzureManager;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class CloudTest implements IAbstractTest {

    @Test(description = "Download file from Amazon S3")
    public void amazonS3DownloadTest() {
        String fileName = "carinademoexample.apk";
        R.CONFIG.put(Configuration.Parameter.S3_REGION.getKey(), Regions.US_WEST_2.getName(), true);
        File artifact = new File(ReportContext.getArtifactsFolder() + File.separator + fileName);
        AmazonS3Manager.getInstance()
                .download("qaprosoft", fileName, artifact);
        Assert.assertTrue(artifact.exists(), "Artifact should exists");
    }

    @Test(description = "Download file from Azure Storage")
    public void azureDownloadTest() {
        String fileName = "cloud.jpg";
        String accountName = "azurestoragesamples";
        R.CONFIG.put(Configuration.Parameter.AZURE_BLOB_URL.getKey(), String.format("https://%s.blob.core.windows.net", accountName), true);
        R.CONFIG.put(Configuration.Parameter.AZURE_ACCOUNT_NAME.getKey(), accountName, true);
        File artifact = new File(ReportContext.getArtifactsFolder() + File.separator + fileName);
        AzureManager.getInstance()
                .download("samples", fileName, artifact);
        Assert.assertTrue(artifact.exists(), "Artifact should exists");
    }

}
