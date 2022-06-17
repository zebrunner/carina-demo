package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.report.ReportContext;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class AutoDownloadUtils {

    private AutoDownloadUtils() {
    }

    public static String getFileNameFromURL(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String path = uri.getPath();
        return path.substring(path.lastIndexOf('/') + 1);
    }

    public static boolean isArtifactPresent(String filename) {
        boolean isPresent = false;
        File artifactsFolder = ReportContext.getArtifactsFolder();
        for (File artifact : Objects.requireNonNull(artifactsFolder.listFiles())) {
            if (artifact.getName().equals(filename)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public static void deleteFileFromAutoDownloadFolder(String fileName) {
        for (File file : Objects.requireNonNull(ReportContext.getAutoDownloadFolder().listFiles())) {
            if (file.getName().equals(fileName)) {
                file.delete();
            }
        }
    }

    public static void deleteFilesFromAutoDownloadFolder(List<String> fileNames) {
        for (String fileName : fileNames) {
            deleteFileFromAutoDownloadFolder(fileName);
        }
    }

    public static String getRegexForOnly(List<String> fileNames) {
        if (fileNames.isEmpty()) {
            return "";
        }
        if (fileNames.size() == 1) {
            return Pattern.quote(fileNames.get(0));
        }

        StringBuilder resultRegex = new StringBuilder();
        for (int i = 0; i < fileNames.size(); i++) {
            if (fileNames.get(i).length() <= 0) {
                continue;
            }
            resultRegex = new StringBuilder();

            if (i == 0) {
                resultRegex.append(Pattern.quote(fileNames.get(i)));
            } else {
                resultRegex.append("|").append(Pattern.quote(fileNames.get(i)));
            }
        }
        return resultRegex.toString();
    }
}
