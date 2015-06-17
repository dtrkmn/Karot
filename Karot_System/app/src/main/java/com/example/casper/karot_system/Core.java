package com.example.casper.karot_system;

/**
 * Created by Win8 on 5/10/2015.
 */
public class Core {

    String core_name;
    String type;
    String date;
    public Core(String core_name, String type, String date){
        this.core_name = core_name;
        this.type = type;
        this.date = date;
    }
    public Core(){

    }

    public String getCore_name() {
        return core_name;
    }

    public void setCore_name(String core_name) {
        this.core_name = core_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
