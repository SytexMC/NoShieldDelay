package me.sytex.noShieldDelay;

import me.sytex.noShieldDelay.listeners.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoShieldDelay extends JavaPlugin {

  @Override
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
  }
}
