package koval;


import koval.mobile.myfitnesspal.service.AdbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class Apps {
    private static final Logger log = LoggerFactory.getLogger(Apps.class);
    private static final String GITHUB_APPS_URL = "https://github.com/DianaKovall/carina-demo/releases/download/v.1.1/";


    public static File downloadAndroidApp(AdbService.AppPackage appPackage) {
        return downloadSampleApp(appPackage.getApkName());
    }

    private static File downloadSampleApp(String filename) {
        File app = new File("apk", filename);
        if (app.exists()) {
            log.info("Using pre-downloaded app: {}", app.getAbsolutePath());
            return app;
        }

        if (!app.getParentFile().exists() && !app.getParentFile().mkdirs()) {
            throw new RuntimeException("Failed to create dir " + app.getParentFile().getAbsolutePath());
        }

        String url = Apps.GITHUB_APPS_URL + filename;
        log.info("Downloading app {} to {}...", url, app.getAbsolutePath());
        try (InputStream in = new URL(url).openStream()) {
            copyInputStreamToFile(in, app);
        } catch (IOException e) {
            throw new RuntimeException("Failed to download " + filename + " to " + app.getAbsolutePath(), e);
        }
        return app;
    }
}