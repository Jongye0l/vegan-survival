package com.Jongyeol.vegan.Command;

import com.Jongyeol.vegan.Item.Item;
import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import com.Jongyeol.vegan.iff.FoundPlayer;
import com.Jongyeol.vegan.iff.NumberCheck;
import com.Jongyeol.vegan.set.makenumber;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
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
            Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " give <player> <item>");
            //Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config");
            return true;
        }
        FileConfiguration config = Main.getPlugin().getConfig();
        if(args[0].equals("set")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(FoundPlayer.FoundPlayer(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            if(NumberCheck.NumberCheck(args[2])){
                Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                return true;
            }
            int vegan = makenumber.makenumber(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            config.set("Player.vegan." + target.getUniqueId(), vegan);
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치를 " + vegan + " 로 정하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].equals("add")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " add <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(FoundPlayer.FoundPlayer(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            if(NumberCheck.NumberCheck(args[2])){
                Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                return true;
            }
            int vegan = config.getInt("Player.vegan." + target.getUniqueId());
            vegan += makenumber.makenumber(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            config.set("Player.vegan." + target.getUniqueId(), vegan);
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치를 " + makenumber.makenumber(args[2]) + " 추가하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].equals("remove")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " remove <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(FoundPlayer.FoundPlayer(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            int vegan = config.getInt("Player.vegan." + target.getUniqueId());
            if(NumberCheck.NumberCheck(args[2])){
                Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                return true;
            }
            vegan -= makenumber.makenumber(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            config.set("Player.vegan." + target.getUniqueId(), vegan);
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치를 " + makenumber.makenumber(args[2]) + " 제거하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].equals("give")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " give <player> <item>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(FoundPlayer.FoundPlayer(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            if(args[2].equals("consumable")){
                target.getInventory().addItem(Item.Consumables);
                Sender.sendMessage(ChatColor.AQUA + target.getName() + "에게 비건소모제를 주었습니다.");
                return true;
            }
            if(args[2].equals("laxative")){
                target.getInventory().addItem(Item.Laxative);
                Sender.sendMessage(ChatColor.AQUA + target.getName() + "에게 비건완화제를 주었습니다.");
                return true;
            }
            Sender.sendMessage(ChatColor.RED + "알 수 없는 아이템 입니다.");
            Sender.sendMessage(ChatColor.GREEN + "아이템 종류 : consumable, laxative");
            return true;
        }
        if(args[0].equals("show")) {
            if(args.length < 2) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(FoundPlayer.FoundPlayer(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치 : " + config.getInt("Player.vegan." + target.getUniqueId()));
            int vegancancel = config.getInt("Player.vegancancel." + target.getUniqueId());
            if(vegancancel != 0){
                int M = vegancancel / 60;
                int S = vegancancel - M*60;
                Sender.sendMessage(ChatColor.GREEN + "비건 완화제 효과 발동중 : " + M + "분 " + S + "초 남음");
            }
            return true;
        }
        if(args[0].equals("config")) {
            if(args.length < 2) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config veganadd <number>");
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config regenhealth <number>");
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config regenresethungry <boolean>");
                return true;
            }
            if(args[1].equals("veganadd")) {
                if(args.length < 3) {
                    Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config veganadd <number>");
                    return true;
                }
                if(NumberCheck.NumberCheck(args[2])){
                    Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                    return true;
                }
                int i = makenumber.makenumber(args[2]);
                //FileConfiguration config = plugin.getConfig();


            }
            return true;

        }
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " add <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " remove <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " give <player> <item>");
        //Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config");
        return true;
    }
}
