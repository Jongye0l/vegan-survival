package com.Jongyeol.vegan.Notification;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class madeby extends BukkitRunnable {
    public static void madebyJongyeol() {
        Bukkit.broadcastMessage(ChatColor.AQUA + "---------------------------------------");
        Bukkit.broadcastMessage(ChatColor.GREEN + "해당 플러그인은 종열이 제작하였습니다.");
        Bukkit.broadcastMessage(ChatColor.GREEN + "Copyright (c) 2022, Jongyeol All rights reserved.");
        Bukkit.broadcastMessage(ChatColor.GREEN + "해당 플러그인의 BSD 3-Clause 라이선스를 가지고 있습니다.");
        TextComponent text = new TextComponent(ChatColor.GREEN + "자세한 내용은 github에서 확인해주세요.");
        text.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/Jongye0l/vegan-survival/blob/main/LICENSE"));
        text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("클릭 시 라이선스를 확인합니다.").create()));
        for (Player player : Bukkit.getOnlinePlayers()){
            player.spigot().sendMessage(text);
        }
        System.out.println(text.getText());
        Bukkit.broadcastMessage(ChatColor.AQUA + "---------------------------------------");
    }

    @Override
    public void run() {
        madebyJongyeol();
    }
}
