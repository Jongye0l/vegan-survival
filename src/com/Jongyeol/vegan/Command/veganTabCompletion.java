package com.Jongyeol.vegan.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class veganTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String cmd, String[] args) {
        List<String> arg1 = new ArrayList<>();
        if (args.length == 1) {
            arg1.add("set");
            arg1.add("add");
            arg1.add("remove");
            arg1.add("show");
            String[] arg1s = args[0].split("");
            if (arg1s[0].equals("")){
                return arg1;
            }
            String[] arg1g = "set add remove show".split(" ");
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
            String[] arg1g = "set add remove show".split(" ");
            Boolean d = false;
            for(int i=0; i < arg1g.length; i++){
                if(args[0].equals(arg1g[i])){
                    return null;
                }
            }
            List<String> arg = new ArrayList<>();
            return arg;
        }
        if (args.length > 2) {
            List<String> arg = new ArrayList<>();
            return arg;
        }
        return null;
    }
}
