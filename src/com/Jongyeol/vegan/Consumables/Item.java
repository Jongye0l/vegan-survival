package com.Jongyeol.vegan.Consumables;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public static ItemStack Consumables;
    public static void init() {
        createConsumables();
    }
    public static void createConsumables() {
        ItemStack item = new ItemStack(Material.DEAD_BUSH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "비건 소모제");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "비건 수치를 제거해주는 아이템이다.");
        lore.add(ChatColor.GREEN + "우클릭을 눌러 비건을 제거합니다.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        Consumables = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        sr.shape("ABC",
                 "DEF",
                 "GHI");
        sr.setIngredient('A', Material.HONEYCOMB);
        sr.setIngredient('B', Material.PACKED_ICE);
        sr.setIngredient('C', Material.HONEY_BOTTLE);
        sr.setIngredient('D', Material.GOLDEN_APPLE);
        sr.setIngredient('E', Material.JUNGLE_SAPLING);
        sr.setIngredient('F', Material.DARK_OAK_SAPLING);
        sr.setIngredient('G', Material.GLOW_BERRIES);
        sr.setIngredient('H', Material.BAMBOO);
        sr.setIngredient('I', Material.ACACIA_SAPLING);
        Bukkit.getServer().addRecipe(sr);
    }
}
