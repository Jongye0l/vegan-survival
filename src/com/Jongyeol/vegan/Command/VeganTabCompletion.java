package com.Jongyeol.vegan.Command;

import com.Jongyeol.Library.CheckSet.CommandComplete;
import com.Jongyeol.Library.CheckSet.CustomBoolean;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class VeganTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String cmd, String[] args) {
        List<String> argument1 = new ArrayList<>();
        argument1.add("set");
        argument1.add("add");
        argument1.add("remove");
        argument1.add("show");
        argument1.add("give");
        argument1.add("config");
        if (args.length == 1) return CommandComplete.getCompleteList(argument1, args[0]);
        if (args.length == 2) {
            if(args[0].toLowerCase().equals("config")) {
                List<String> argument = new ArrayList<>();
                argument.add("veganadd");
                argument.add("regenhealth");
                argument.add("regenresethungry");
                return CommandComplete.getCompleteList(argument, args[1]);
            }
            for(String st : argument1) if(args[0].toLowerCase().equals(st)) return null;
            return new ArrayList<>();
        }
        if (args.length == 3) {
            List<String> arg3 = new ArrayList<>();
            if(args[0].toLowerCase().equals("give")){
                List<String> argument = new ArrayList<>();
                argument.add("consumable");
                argument.add("laxative");
                argument.add("smallremedy");
                return CommandComplete.getCompleteList(argument, args[2]);
            }
            if(args[0].toLowerCase().equals("config")){
                if(args[1].toLowerCase().equals("regenresethungry")){
                    if (args[0].toLowerCase().split("")[0].equals("")){
                        List<String> argument = new ArrayList<>();
                        argument.add("true");
                        argument.add("false");
                        return argument;
                    }
                    return CommandComplete.getCompleteList(CustomBoolean.getCustomBoolean(), args[0]);
                }
            }
        }
        return new ArrayList<>();
    }
}
