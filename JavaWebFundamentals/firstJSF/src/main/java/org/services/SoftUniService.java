package org.services;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "softUniService")
public class SoftUniService {

    public String getNameReversed() {
        return new StringBuilder("SoftUni").reverse().toString();
    }

    public String register(String username, String password) {
        return new StringBuilder(password).reverse().toString();

    }
}
