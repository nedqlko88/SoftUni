package org.ned;

import org.ned.casebook.CasebookApplication;
import org.ned.javache.Server;
import org.ned.javache.WebConstants;
import org.ned.javache.api.RequestHandler;
import org.ned.javache.http.HttpSessionStorage;
import org.ned.javache.http.HttpSessionStorageImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StartUp {
    public static void main(String[] args) {
        start(args);
    }

    private static HttpSessionStorage getSessionStorage() {
        return new HttpSessionStorageImpl();
    }

    private static Set<RequestHandler> initializeApplications() {
        return new HashSet<>() {{
            add(new CasebookApplication(getSessionStorage()));
        }};
    }

    private static void start(String[] args) {
        int port = WebConstants.DEFAULT_SERVER_PORT;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        Server server = new Server(port, initializeApplications());

        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
