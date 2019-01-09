package org.softuni.viewModels;

import org.services.SoftUniService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "softUni")
public class SoftUniViewModel {

    @ManagedProperty("#{softUniService}")
    private SoftUniService softUniService;

    private String username;
    private String password;

    private String registerResult;

    public String getName() {
        return "Hello Java Web @ " + this.softUniService.getNameReversed();
    }

    public SoftUniService getSoftUniService() {
        return this.softUniService;
    }

    public void setSoftUniService(SoftUniService softUniService) {
        this.softUniService = softUniService;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void onSubmit() {
        String result = this.softUniService.register(this.username, this.password);
        this.registerResult = result;

    }

    public String getRegisterResult() {
        return this.registerResult;
    }

    public void setRegisterResult(String registerResult) {
        this.registerResult = registerResult;
    }
}
