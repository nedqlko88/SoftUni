package com.ned.demo.models.binding;

public class CreateStudentBindingModel {
    private String name;
    private Integer willToLive;

    public CreateStudentBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWillToLive() {
        return this.willToLive;
    }

    public void setWillToLive(Integer willToLive) {
        this.willToLive = willToLive;
    }
}
