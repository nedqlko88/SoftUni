package org.ned.nedbook.controllers;

import org.ned.nedbook.util.MimeManager;
import org.ned.javache.WebConstants;
import org.ned.javache.http.HttpRequest;
import org.ned.javache.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceController extends BaseController {
    public byte[] processResourceRequest(HttpRequest httpRequest, HttpResponse httpResponse) {
        String assetPath = WebConstants.ASSETS_FOLDER_PATH +
                httpRequest.getRequestUrl();

        File file = new File(assetPath);

        if(!file.exists() || file.isDirectory()) {
            return this.notFound(("Asset not found!").getBytes(), httpResponse);
        }

        byte[] result = null;

        try {
            result = Files.readAllBytes(Paths.get(assetPath));
        } catch (IOException e) {
            return this.internalServerError(("Something went wrong!").getBytes(), httpResponse);
        }

        httpResponse.addHeader("Content-Type", MimeManager.getMimeType(file.getName()));
        httpResponse.addHeader("Content-Length", result.length + "");
        httpResponse.addHeader("Content-Disposition", "inline");

        return this.ok(result, httpResponse);
    }
}
