package it.chiarchiaooo.thorhammer.events;

import it.chiarchiaooo.thorhammer.commands.TestCmds;
import it.chiarchiaooo.thorhammer.utils.AnimationUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class ClickEvent implements Listener {

    @EventHandler
    public void click(PlayerInteractEvent e) {
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || !e.getPlayer().isSneaking() || !e.getItem().equals(TestCmds.createHammer())) return;
        Player p = e.getPlayer();
        e.setCancelled(true);

        HashMap<Location,Entity> entities = new HashMap<>();
        for (Entity en : p.getNearbyEntities(5,0,5)) {
            entities.put(en.getLocation(),en);
        }

        AnimationUtils animator = new AnimationUtils(p.getLocation(),entities);
        animator.animate();
    }

}
