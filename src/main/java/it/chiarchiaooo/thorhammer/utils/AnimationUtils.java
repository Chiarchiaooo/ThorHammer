package it.chiarchiaooo.thorhammer.utils;

import it.chiarchiaooo.thorhammer.Thorhammer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

public class AnimationUtils implements Runnable {

    private final Location loc;
    private float radius;
    private int taskId;

    public AnimationUtils(Location loc) {
        this.radius = Thorhammer.getInstance().getRadius();
        this.loc = loc;
    }

    public void animate() {taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Thorhammer.getInstance(),this,0,1L);}

    @Override
    public void run() {
        for (int d = 0; d <= 90; d += 1) {
            Location particleLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
            particleLoc.setX(loc.getX() + Math.cos(d) * radius);
            particleLoc.setZ(loc.getZ() + Math.sin(d) * radius);
            loc.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(Color.MAROON, 2));
        }
        radius +=0.4;
        if (radius > 5.0f) taskCancel();
    }

    public void taskCancel() {Bukkit.getScheduler().cancelTask(taskId);}
}
