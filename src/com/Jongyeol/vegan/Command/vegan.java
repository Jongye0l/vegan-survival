package com.Jongyeol.vegan.Command;

import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class vegan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, org.bukkit.command.Command command, String Cmd, String[] args) {
        if(args.length < 1) {
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " add <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " remove <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
            return true;
        }
        if(args[0].equals("set")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            int vegan = Integer.parseInt(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            target.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, vegan);
            Sender.sendMessage(ChatColor.AQUA + args[1] + "에 비건수치를 " + target.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER) + " 로 정하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].equals("add")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " add <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            int vegan = target.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER);
            vegan += Integer.parseInt(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            target.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, vegan);
            Sender.sendMessage(ChatColor.AQUA + args[1] + "에 비건수치를 " + Integer.parseInt(args[2]) + " 추가하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].equals("remove")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " remove <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            int vegan = target.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER);
            vegan -= Integer.parseInt(args[2]);
            if(vegan < 0){
                vegan = 0;
            }
            target.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, vegan);
            Sender.sendMessage(ChatColor.AQUA + args[1] + "에 비건수치를 " + Integer.parseInt(args[2]) + " 추가하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].equals("show")) {
            if(args.length < 2) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
            }
            Player target = Bukkit.getPlayer(args[1]);
            Sender.sendMessage(ChatColor.AQUA + args[1] + "에 비건수치 : " + target.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER));
            return true;
        }
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " add <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " remove <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
        return true;
    }
}
