package com.example.sagar.hallbook;

/**
 * Created by sagar on 20/7/17.
 */

public class Vendor {
    private String vendorName, area;
    private int thumbnail;
    public String getvendorName() {
        return vendorName;
    }

    public String getArea() {
        return area;
    }

    public int getThumbnail() {
        return thumbnail;
    }
    public Vendor(String vendorName, String area, int thumbnail)
    {
        this.vendorName = vendorName;
        this.area = area;
        this.thumbnail = thumbnail;
    }
}
