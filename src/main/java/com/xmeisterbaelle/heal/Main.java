package com.xmeisterbaelle.heal;

import com.xmeisterbaelle.heal.commands.Heal;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new Heal());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
