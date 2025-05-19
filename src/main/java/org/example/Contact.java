package org.example;

public class Contact {

    private String name;
    private  String phone;
    Contact(String name, String phone ){
        this.name= name;
        this.phone= phone;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }

}
