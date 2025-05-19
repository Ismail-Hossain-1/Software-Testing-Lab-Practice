package org.example.units;

public class StringUnits {
    public static boolean isPallindrome(String s){
        if(s==null) return false;
        String ss= new StringBuilder(s).reverse().toString();
        return  ss.equals(s);
    }
    public static boolean containsSubstr(String s, String ss){
        if(s==null||ss==null) return false;
        return s.contains(ss);
    }
}
