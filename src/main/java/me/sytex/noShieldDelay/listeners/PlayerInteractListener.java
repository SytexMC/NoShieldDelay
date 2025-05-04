package me.sytex.noShieldDelay.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerInteractListener implements Listener {

  @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
  public void onBlocking(@NotNull PlayerInteractEvent event) {
    Player player = event.getPlayer();

    if (!player.getInventory().getItemInMainHand().getType().equals(Material.SHIELD) &&
        !player.getInventory().getItemInOffHand().getType().equals(Material.SHIELD)) return;

    player.setShieldBlockingDelay(0);
  }
}
