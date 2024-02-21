package com.university.library.model.assets.digital;

import com.university.library.model.assets.Asset;

public abstract class Digital extends Asset {
    // Attribute
    private String accessLink;

    // Constructors
    public Digital() {
        // Default constructor
    }

    public Digital(String accessLink) {
        this.accessLink = accessLink;
    }

    // Getter and setter
    public String getAccessLink() {
        return accessLink;
    }

    public void setAccessLink(String accessLink) {
        this.accessLink = accessLink;
    }
}