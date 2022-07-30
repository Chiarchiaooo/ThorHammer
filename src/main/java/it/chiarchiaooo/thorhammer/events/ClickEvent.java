package it.chiarchiaooo.thorhammer.events;

import it.chiarchiaooo.thorhammer.commands.TestCmds;
import it.chiarchiaooo.thorhammer.utils.AnimationUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class ClickEvent implements Listener {

    @EventHandler
    public void click(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || !e.getPlayer().isSneaking() || !e.getItem().equals(TestCmds.createHammer())) return;
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

}
