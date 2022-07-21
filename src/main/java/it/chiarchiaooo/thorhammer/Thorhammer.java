package it.chiarchiaooo.thorhammer;

import it.chiarchiaooo.thorhammer.commands.TestCmds;
import it.chiarchiaooo.thorhammer.events.ClickEvent;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Thorhammer extends JavaPlugin {

    @Getter static Thorhammer instance;

    @Getter @Setter float radius;

    @Override
    public void onEnable() {
        instance = this;
        setRadius(1.0f);
        setupEvent();
        setupCmds();
    }

    public void setupEvent() {getServer().getPluginManager().registerEvents(new ClickEvent(),this);}

    public void setupCmds() {getCommand("test").setExecutor(new TestCmds());}

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
