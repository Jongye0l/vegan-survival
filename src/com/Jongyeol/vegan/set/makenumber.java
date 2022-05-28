package com.Jongyeol.vegan.set;

public class makenumber {
    public static int makenumber(String string){
        String[] strings = string.split("");
        String st = "";
        for(int i1=0; i1<strings.length; i1++){
            for(int i2=0; i2<10; i2++){
                if(strings[i1].equals(i2 + "")){
                    st = st + i2;
                }
            }
        }
        return Integer.parseInt(st);
    }
}
