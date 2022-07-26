package it.chiarchiaooo.thorhammer.commands;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCmds implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ItemStack im = createHammer();
        ((Player)sender).getInventory().setItem(1,im);



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
