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

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, org.bukkit.command.Command command, String Cmd, String[] args) {
        if(args.length < 1) {
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
            return true;
        }
        if(args.equals("set")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
            }
            Player target = Bukkit.getPlayer(args[1]);
            int vegan = Integer.parseInt(args[2]);
            target.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER, vegan);
            Sender.sendMessage(ChatColor.AQUA + args[1] + "에 비건수치를 " + target.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER) + " 로 정하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args.equals("show")) {
            if(args.length < 2) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
            }
            Player target = Bukkit.getPlayer(args[1]);
            Sender.sendMessage(ChatColor.AQUA + args[1] + "에 비건수치 : " + target.getPersistentDataContainer().get(new NamespacedKey(Main.getPlugin(), "vegan"), PersistentDataType.INTEGER));
            return true;
        }
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
        return false;
    }
}
