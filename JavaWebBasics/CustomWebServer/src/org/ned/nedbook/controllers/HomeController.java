package org.ned.nedbook.controllers;

import org.ned.nedbook.CasebookWebConstants;
import org.ned.nedbook.util.GetMapping;
import org.ned.database.repositories.UserRepository;
import org.ned.javache.http.HttpRequest;
import org.ned.javache.http.HttpResponse;

import java.util.HashMap;

public class HomeController extends BaseController {
    private UserRepository userRepository;

    public HomeController() {
        this.userRepository = new UserRepository();
    }

    @GetMapping(route = "/")
    public byte[] index(HttpRequest httpRequest, HttpResponse httpResponse) {
        if(httpRequest.getCookies().containsKey(CasebookWebConstants.CASEBOOK_SESSION_KEY)) {
            return this.redirect(new byte[0], "/home", httpResponse);
        }

        return this.processPageRequest("/index", httpResponse);
    }

    @GetMapping(route = "/home")
    public byte[] home(HttpRequest httpRequest, HttpResponse httpResponse) {
        if(!httpRequest.getCookies().containsKey(CasebookWebConstants.CASEBOOK_SESSION_KEY)) {
            return this.redirect(new byte[0], "/login", httpResponse);
        }

        String currentUserUsername = httpResponse.getSession().getAttributes().get("username").toString();

        HashMap<String, String> viewData = new HashMap<>();

        viewData.put("username", currentUserUsername);

        return this.processPageRequest("/home", viewData, httpResponse);
    }
}
