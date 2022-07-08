package com.Jongyeol.vegan.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class veganTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String cmd, String[] args) {
        String[] arg1g = "set add remove show give config".split(" ");
        String[] configarg2g = "veganadd regenhealth regenresethungry".split(" ");
        String[] booleanargg = "true yes ok positive 1 false no nope not denial 0".split(" ");
        String[] givearg3g = "consumable laxative SmallRemedy".split(" ");
        if (args.length == 1) {
            List<String> arg1 = new ArrayList<>();
            arg1.add("set");
            arg1.add("add");
            arg1.add("remove");
            arg1.add("show");
            arg1.add("give");
            arg1.add("config");
            String[] arg1s = args[0].toLowerCase().split("");
            if (arg1s[0].equals("")){
                return arg1;
            }
            for(int i1=0; i1 < arg1g.length; i1++){
                String[] arg1b = arg1g[i1].split("");
                for(int i2=0; i2 < arg1s.length; i2++){
                    if (arg1s.length < arg1b.length){
                        if (!arg1s[i2].equals(arg1b[i2])) {arg1.remove(arg1g[i1]);}
                    } else {
                        arg1.remove(arg1g[i1]);
                    }
                }
            }
            return arg1;
        }
        if (args.length == 2) {
            if(args[0].toLowerCase().equals("config")) {
                List<String> arg2 = new ArrayList<>();
                arg2.add("veganadd");
                arg2.add("regenhealth");
                arg2.add("regenresethungry");
                String[] arg2s = args[1].toLowerCase().split("");
                if (arg2s[0].equals("")){
                    return arg2;
                }
                for(int i1=0; i1 < configarg2g.length; i1++){
                    String[] arg2b = configarg2g[i1].split("");
                    for(int i2=0; i2 < arg2s.length; i2++){
                        if (arg2s.length < arg2b.length){
                            if (!arg2s[i2].equals(arg2b[i2])) {arg2.remove(configarg2g[i1]);}
                        } else {
                            arg2.remove(configarg2g[i1]);
                        }
                    }
                }
                return arg2;
            }
            for(int i=0; i < arg1g.length; i++){
                if(args[0].toLowerCase().equals(arg1g[i])){
                    return null;
                }
            }
            List<String> arg = new ArrayList<>();
            return arg;
        }
        if (args.length == 3) {
            List<String> arg3 = new ArrayList<>();
            if(args[0].toLowerCase().equals("give")){
                arg3.add("consumable");
                arg3.add("laxative");
                arg3.add("smallremedy");
                String[] arg3s = args[2].toLowerCase().split("");
                if (arg3s[0].equals("")){
                    return arg3;
                }
                for(int i1=0; i1 < givearg3g.length; i1++){
                    String[] arg3b = givearg3g[i1].split("");
                    for(int i2=0; i2 < arg3s.length; i2++){
                        if (arg3s.length < arg3b.length){
                            if (!arg3s[i2].equals(arg3b[i2])) {arg3.remove(givearg3g[i1]);}
                        } else {
                            arg3.remove(givearg3g[i1]);
                        }
                    }
                }
            }
            if(args[0].toLowerCase().equals("config")){
                if(args[1].toLowerCase().equals("regenresethungry")){
                    arg3.add("true");
                    arg3.add("false");
                    String[] arg3s = args[2].toLowerCase().split("");
                    if (arg3s[0].equals("")){
                        return arg3;
                    }
                    arg3.add("yes");
                    arg3.add("ok");
                    arg3.add("positive");
                    arg3.add("1");
                    arg3.add("nope");
                    arg3.add("not");
                    arg3.add("no");
                    arg3.add("denial");
                    arg3.add("0");
                    for(int i1=0; i1 < booleanargg.length; i1++){
                        String[] arg3b = booleanargg[i1].split("");
                        for(int i2=0; i2 < arg3s.length; i2++){
                            if (arg3s.length < arg3b.length){
                                if (!arg3s[i2].equals(arg3b[i2])) {arg3.remove(booleanargg[i1]);}
                            } else {
                                arg3.remove(booleanargg[i1]);
                            }
                        }
                    }

                }
            }
            return arg3;
        }
        if (args.length > 3) {
            List<String> arg = new ArrayList<>();
            return arg;
        }
        return null;
    }
}
