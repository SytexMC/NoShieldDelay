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

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class EntityDamageListener implements Listener {

  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent event) {
    if (!(event.getEntity() instanceof Player)) return;

    Player player = (Player) event.getEntity();

    if (player.isBlocking() || !player.isHandRaised()) return;

    Vector facing = player.getLocation().getDirection().normalize();
    Vector relative = event.getDamager().getLocation().getDirection().normalize();

    double angle = facing.angle(relative);
    double threshold = Math.toRadians(90);

    if (threshold >= angle) return;

    event.setCancelled(true);
  }
}
