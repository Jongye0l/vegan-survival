package com.Jongyeol.vegan.Item;

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
    public static ItemStack Laxative;
    public static ItemStack SmallRemedy;
    public static void init() {
        createConsumables();
        createLaxative();
        createSmallRemedy();
    }
    public static void createConsumables() {
        ItemStack item = new ItemStack(Material.DEAD_BUSH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "비건 소모제");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "비건 수치를 제거해주는 아이템이다.");
        lore.add(ChatColor.GREEN + "우클릭을 눌러 아이템을 사용합니다.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        Consumables = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("1"), item);
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
    public static void createLaxative() {
        ItemStack item = new ItemStack(Material.BIRCH_SAPLING, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "비건 완화제");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "비건 수치를 제거해주고 5분간 비건수치가 오르지 않게 해주는 아이템이다.");
        lore.add(ChatColor.GREEN + "우클릭을 눌러 아이템을 사용합니다.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        Laxative = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("2"), item);
        sr.shape("ABC",
                "DEF",
                "GHI");
        sr.setIngredient('B', Material.BRAIN_CORAL);
        sr.setIngredient('D', Material.GLOW_LICHEN);
        sr.setIngredient('E', Material.NETHER_WART);
        sr.setIngredient('F', Material.BLAZE_POWDER);
        sr.setIngredient('H', Material.PRISMARINE_SHARD);
        Bukkit.getServer().addRecipe(sr);
    }
    public static void createSmallRemedy() {
        ItemStack item = new ItemStack(Material.HONEY_BOTTLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "비건 약식 치료제");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "비건 수치를 10 줄여주는 아이템이다.");
        lore.add(ChatColor.GREEN + "우클릭을 눌러 아이템을 사용합니다.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        SmallRemedy = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("3"), item);
        sr.shape("ABC",
                "DEF",
                "GHI");
        sr.setIngredient('A', Material.MELON_SLICE);
        sr.setIngredient('B', Material.IRON_INGOT);
        sr.setIngredient('C', Material.CARROT);
        sr.setIngredient('D', Material.SWEET_BERRIES);
        sr.setIngredient('E', Material.HONEYCOMB);
        sr.setIngredient('F', Material.POTATO);
        sr.setIngredient('G', Material.BEETROOT);
        sr.setIngredient('H', Material.GLASS_BOTTLE);
        sr.setIngredient('I', Material.WHEAT);
        Bukkit.getServer().addRecipe(sr);
    }
}
