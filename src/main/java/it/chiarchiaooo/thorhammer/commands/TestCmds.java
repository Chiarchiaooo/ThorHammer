package it.chiarchiaooo.thorhammer.commands;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCmds implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        ((Player)sender).getInventory().setItem(1,createHammer());
        return false;
    }


    public static ItemStack createHammer() {
        ItemStack item = new ItemStack(Material.TRIDENT,1);
        ItemMeta im = item.getItemMeta();

        im.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lMjolnir"));
        im.setLore(getLore());

        for (Enchantment e : Arrays.asList(Enchantment.CHANNELING,Enchantment.LOYALTY,Enchantment.IMPALING)) im.addEnchant(e,e.getMaxLevel(),true);

        im.setUnbreakable(true);
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE,ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(im);

        return item;
    }

    private static List<String> getLore() {
        List<String> lore = new ArrayList<>();
        for (String s: Arrays.asList("&7Ecco a voi il Mitico Jonathan","","&cSolo per i degni")) lore.add(ChatColor.translateAlternateColorCodes('&',s));
        return lore;
    }
}
