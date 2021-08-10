package com.company.objects;

public class Drug {
    private int id;
    private String name;
    private int storage;

    public Drug(){

    }

    public Drug(int id, String name, int storage) {
        this.id = id;
        this.name = name;
        this.storage = storage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
