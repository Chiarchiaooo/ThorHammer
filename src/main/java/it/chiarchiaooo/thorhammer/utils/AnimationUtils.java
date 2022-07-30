package it.chiarchiaooo.thorhammer.utils;

import it.chiarchiaooo.thorhammer.Thorhammer;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

public class AnimationUtils implements Runnable {

    private final Location loc;
    private float radius;
    private int taskId;
    private int count =5;
    private final Block bParticles;

    public AnimationUtils(Location loc) {
        this.radius = Thorhammer.getInstance().getRadius();
        this.loc = loc;
        this.bParticles =
    }

    public void animate() {taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Thorhammer.getInstance(),this,0,1L);}

    @Override
    public void run() {
        System.out.println(loc.getBlock().getRelative(BlockFace.DOWN).getType());
        for (int d = 0; d <= 90; d += 1) {
            Location particleLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
            particleLoc.setX(loc.getX() + Math.cos(d) * radius);
            particleLoc.setZ(loc.getZ() + Math.sin(d) * radius);
            loc.getWorld().spawnParticle(Particle.BLOCK_CRACK, particleLoc, count, );
        }
        radius += 0.4;
        if (radius > 5.0f) taskCancel();
    }

    public void taskCancel() {Bukkit.getScheduler().cancelTask(taskId);}
}
