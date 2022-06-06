package com.Jongyeol.vegan.set;

public class makeboolean {
    public static boolean makeboolean(String string) {
        String[] True = "true yes ok positive 1 on".split(" ");
        String[] args = string.toLowerCase().split("");
        Boolean test = true;
        for(int i1=0; i1 < True.length; i1++){
            if(string.toLowerCase().equals(True[i1])){
                return true;
            }
            String[] true1b = True[i1].split("");
            for(int i2=0; i2 < args.length; i2++){
                if (args.length < true1b.length){
                    if (!args[i2].equals(true1b[i2])) {test = false;}
                } else {
                    test = false;
                }
            }
            if(test) { return true;}
        }
        return false;
    }
}
