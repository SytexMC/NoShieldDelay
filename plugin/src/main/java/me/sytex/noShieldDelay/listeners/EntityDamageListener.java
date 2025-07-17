/*
 * This file is part of NoShieldDelay, licensed under GPL v3.
 *
 * Copyright (c) 2025 Sytex <sytex@duck.com>
 * Copyright (c) contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.sytex.noShieldDelay.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

public class EntityDamageListener implements Listener {

  private static final double BLOCK_ANGLE_THRESHOLD = Math.toRadians(90);

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent event) {
    if (!(event.getEntity() instanceof Player)) return;

    Player player = (Player) event.getEntity();

    if (player.isBlocking() || !player.isHandRaised()) return;

    PlayerInventory inventory = player.getInventory();

    if (inventory.getItemInMainHand().getType() != Material.SHIELD && inventory.getItemInOffHand().getType() != Material.SHIELD) return;

    Vector facing = player.getLocation().getDirection().normalize();
    Vector relative = event.getDamager().getLocation().getDirection().normalize();

    double angle = facing.angle(relative);

    if (BLOCK_ANGLE_THRESHOLD >= angle) return;

    event.setCancelled(true);
  }
}
