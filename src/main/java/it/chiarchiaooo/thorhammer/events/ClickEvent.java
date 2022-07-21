package it.chiarchiaooo.thorhammer.events;

import it.chiarchiaooo.thorhammer.utils.AnimationUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ClickEvent implements Listener {

    @EventHandler
    public void click(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || !e.getPlayer().isSneaking() || !checkItem(e.getItem())) return;
        Player p = e.getPlayer();
        e.setCancelled(true);

        AnimationUtils animator = new AnimationUtils(p.getLocation());
        animator.animate();

        //struckEntities(p.getNearbyEntities(5,0,5));
    }


    private void struckEntities(List<Entity> nEntities) {
        for (Entity en : nEntities) {
            en.getWorld().strikeLightning(en.getLocation());
        }
    }

    private boolean checkItem(ItemStack item) {
        if (item == null || item.getItemMeta() == null) return false;
        ItemMeta im = item.getItemMeta();

        return (
            item.getType().equals(Material.TRIDENT) &&
            im.hasLore() &&
            (im.hasEnchants() && im.getEnchants().keySet().equals(Arrays.asList(Enchantment.CHANNELING,Enchantment.LOYALTY,Enchantment.IMPALING))) &&
            (im.hasDisplayName() && im.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',"&6&lMjolnir")))
        );
    }
}
