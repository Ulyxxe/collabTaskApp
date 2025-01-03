package org.ulysse.collabtaskapp;

public class Report {
    private int id;
    private String type;
    private String format;

    public Report (int id, String type, String format){
        this.id = id;
        this.type = type;
        this.format = format;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
