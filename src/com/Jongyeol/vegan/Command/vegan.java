package com.Jongyeol.vegan.Command;

import com.Jongyeol.Library.CheckSet.CustomBoolean;
import com.Jongyeol.Library.CheckSet.Number;
import com.Jongyeol.Library.CheckSet.Other;
import com.Jongyeol.vegan.Item.Item;
import com.Jongyeol.vegan.Main;
import com.Jongyeol.vegan.actionbar.begunaction;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class vegan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, org.bukkit.command.Command command, String Cmd, String[] args) {
        if(args.length < 1) {
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " set <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " add <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " remove <player> <vegan>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " show <player>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " give <player> <item>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " config");
            return true;
        }
        FileConfiguration config = Main.getPlugin().getConfig();
        if(args[0].toLowerCase().equals("set")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " set <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(!Other.playerCheck(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            if(Number.NumberCheck(args[2])){
                Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                return true;
            }
            int vegan = Number.makeinteger(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            config.set("Player.vegan." + target.getUniqueId(), vegan);
            Main.getPlugin().saveConfig();
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치를 " + vegan + " 로 정하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].toLowerCase().equals("add")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " add <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(!Other.playerCheck(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            if(Number.NumberCheck(args[2])){
                Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                return true;
            }
            int vegan = config.getInt("Player.vegan." + target.getUniqueId());
            vegan += Number.makeinteger(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            config.set("Player.vegan." + target.getUniqueId(), vegan);
            Main.getPlugin().saveConfig();
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치를 " + Number.makeinteger(args[2]) + " 추가하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].toLowerCase().equals("remove")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " remove <player> <vegan>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(!Other.playerCheck(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            int vegan = config.getInt("Player.vegan." + target.getUniqueId());
            if(Number.NumberCheck(args[2])){
                Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                return true;
            }
            vegan -= Number.makeinteger(args[2]);
            if(vegan > 100){
                vegan = 100;
            }
            if(vegan < 0){
                vegan = 0;
            }
            config.set("Player.vegan." + target.getUniqueId(), vegan);
            Main.getPlugin().saveConfig();
            Sender.sendMessage(ChatColor.AQUA + target.getName() + "에 비건수치를 " + Number.makeinteger(args[2]) + " 제거하였습니다.");
            begunaction.SendActionbar(target);
            return true;
        }
        if(args[0].toLowerCase().equals("give")) {
            if(args.length < 3) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " give <player> <item>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(!Other.playerCheck(target)){
                Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
                return true;
            }
            if(args[2].toLowerCase().equals("consumable")){
                target.getInventory().addItem(Item.Consumables);
                Sender.sendMessage(ChatColor.AQUA + target.getName() + "에게 비건소모제를 주었습니다.");
                return true;
            }
            if(args[2].toLowerCase().equals("laxative")){
                target.getInventory().addItem(Item.Laxative);
                Sender.sendMessage(ChatColor.AQUA + target.getName() + "에게 비건완화제를 주었습니다.");
                return true;
            }
            if(args[2].toLowerCase().equals("smallremedy")){
                target.getInventory().addItem(Item.SmallRemedy);
                Sender.sendMessage(ChatColor.AQUA + target.getName() + "에게 비건 약식 치료제를 주었습니다.");
                return true;
            }
            Sender.sendMessage(ChatColor.RED + "알 수 없는 아이템 입니다.");
            Sender.sendMessage(ChatColor.GREEN + "아이템 종류 : consumable, laxative, smallremedy");
            return true;
        }
        if(args[0].toLowerCase().equals("show")) {
            if(args.length < 2) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " show <player>");
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(!Other.playerCheck(target)){
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
        if(args[0].toLowerCase().equals("config")) {
            if(args.length < 2) {
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config veganadd <number>");
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config regenhealth <number>");
                Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config regenresethungry <boolean>");
                return true;
            }
            boolean r = false;
            if(args[1].toLowerCase().equals("veganadd")) {
                if(args.length < 3) {
                    Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config veganadd <number>");
                    return true;
                }
                if(Number.NumberCheck(args[2])){
                    Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                    return true;
                }
                int i = Number.makeinteger(args[2]);
                if(i < 0){
                    Sender.sendMessage(ChatColor.RED + "0 이상의 값을 적어주세요.");
                    return true;
                }
                if(i > 100){
                    Sender.sendMessage(ChatColor.RED + "100 이하의 값을 적어주세요.");
                    return true;
                }
                config.set("veganadd", i);
                Sender.sendMessage(ChatColor.GREEN + "비건 추가값을 " + i + "로 설정하였습니다.");
                r = true;
            }
            if(args[1].toLowerCase().equals("regenhealth")) {
                if(args.length < 3) {
                    Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config regenhealth <number>");
                    return true;
                }
                if(Number.NumberCheck(args[2])){
                    Sender.sendMessage(ChatColor.RED + "숫자를 입력해주세요.");
                    return true;
                }
                int i = Number.makeinteger(args[2]);
                if(i < 1){
                    Sender.sendMessage(ChatColor.RED + "1 이상의 값을 적어주세요.");
                    return true;
                }
                if(i > 20){
                    Sender.sendMessage(ChatColor.RED + "20 이하의 값을 적어주세요.");
                    return true;
                }
                config.set("regenhealth", i);
                Sender.sendMessage(ChatColor.GREEN + "리스폰시 체력을 " + i + "로 설정하였습니다.");
                r = true;
            }
            if(args[1].toLowerCase().equals("regenresethungry")) {
                if(args.length < 3) {
                    Sender.sendMessage(ChatColor.GREEN + "사용법 /" + Cmd + " config regenresethungry <boolean>");
                    return true;
                }
                if(CustomBoolean.booleanCheck(args[2].toLowerCase())) {
                    Sender.sendMessage(ChatColor.RED + "True/false를 입력해주세요.");
                    return true;
                }
                boolean Boolean = CustomBoolean.makeboolean(args[2].toLowerCase());
                if(Boolean) {
                    Sender.sendMessage(ChatColor.GREEN + "리스폰시 배고픔 초기화를 활성화했습니다.");
                } else {
                    Sender.sendMessage(ChatColor.GREEN + "리스폰시 배고픔 초기화를 비활성화했습니다.");
                }
                config.set("regenresethungry", Boolean);
                r = true;
            }
            if(r) {
                Main.getPlugin().saveConfig();
                return true;
            }
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " config veganadd <number>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " config regenhealth <number>");
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " config regenresethungry <boolean>");
            return true;

        }
        Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " set <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " add <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " remove <player> <vegan>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " show <player>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " give <player> <item>");
        Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " config");
        return true;
    }
}
