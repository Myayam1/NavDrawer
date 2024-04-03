package com.example.sidebarnav;

public class MyModel {
    private String name ,desc, src;

    public MyModel(String name, String desc, String src) {
        this.name = name;
        this.desc = desc;
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getSrc() {
        return src;
    }
}
