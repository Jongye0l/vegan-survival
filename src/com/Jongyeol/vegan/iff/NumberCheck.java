package com.Jongyeol.vegan.iff;

public class NumberCheck {
    public static boolean NumberCheck(String string){
        for (int i=0; i < 10; i++){
            if(string.contains(""+i)){
                return false;
            }
        }
        return true;
    }
}
