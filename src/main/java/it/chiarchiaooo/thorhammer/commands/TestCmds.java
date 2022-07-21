package it.chiarchiaooo.thorhammer.commands;


import it.chiarchiaooo.thorhammer.Thorhammer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCmds implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length >0) Thorhammer.getInstance().setRadius(Float.parseFloat(args[0]));
        sender.sendMessage("Nuovo radius: "+Thorhammer.getInstance().getRadius());
        return false;
    }
}
