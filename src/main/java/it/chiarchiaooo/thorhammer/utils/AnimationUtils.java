package it.chiarchiaooo.thorhammer.utils;

import it.chiarchiaooo.thorhammer.Thorhammer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;

import java.util.HashMap;

public class AnimationUtils implements Runnable {

    private final Location loc;
    private float radius;
    private int taskId;
    private final HashMap<Location,Entity> nEntities;

    public AnimationUtils(Location loc, HashMap<Location,Entity> nEntities) {
        this.radius = Thorhammer.getInstance().getRadius();
        this.nEntities = nEntities;
        this.loc = loc;
    }

    public void animate() {taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Thorhammer.getInstance(),this,0,1L);}

    @Override
    public void run() {
        for (int d = 0; d <= 90; d += 1) {
            Location particleLoc = loc;
            particleLoc.setX(loc.getX() + Math.cos(d) * radius);
            particleLoc.setZ(loc.getZ() + Math.sin(d) * radius);
            loc.getWorld().spawnParticle(Particle.BLOCK_CRACK, particleLoc, 5, loc.getBlock().getRelative(BlockFace.DOWN).getType().createBlockData());

            if (nEntities.containsKey(particleLoc)) nEntities.get(particleLoc).getWorld().strikeLightning(nEntities.get(particleLoc).getLocation());
        }

        radius += 0.4;
        if (radius > 5.0f) taskCancel();
    }

    public void taskCancel() {Bukkit.getScheduler().cancelTask(taskId);}
}
