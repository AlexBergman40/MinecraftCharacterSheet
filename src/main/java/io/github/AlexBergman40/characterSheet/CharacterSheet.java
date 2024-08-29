package io.github.AlexBergman40.characterSheet;

import org.bukkit.plugin.java.JavaPlugin;

public final class CharacterSheet extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("charactersheet").setExecutor(new CommandCard());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
