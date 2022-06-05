package com.Jongyeol.vegan.iff;

public class BooleanCheck {
    public static boolean booleanCheck(String string) {
        String[] customboolean = "true yes ok positive 1 false nope not denial 0".split(" ");
        String[] args = string.toLowerCase().split("");
        Boolean test = true;
        for(int i1=0; i1 < customboolean.length; i1++){
            String[] true1b = customboolean[i1].split("");
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
