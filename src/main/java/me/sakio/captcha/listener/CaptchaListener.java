package me.sakio.captcha.listener;

import me.sakio.captcha.CaptchaPlugin;
import me.sakio.captcha.menu.CaptchaMenu;
import me.sakio.captcha.utils.Color;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by DevSakio
 * Project: Captcha
 * Date: 02/12/2020 @ 18:07
 * Class: JoinEvent
 */
public class CaptchaListener implements Listener {

    @EventHandler
    public void onCaptchaClose(InventoryCloseEvent event) {
        if (event.getInventory().getName().equals(ChatColor.RED + "Click the emerald block!")) {
            Player player = (Player) event.getPlayer();
            if (!CaptchaPlugin.getPlayerArrayList().contains(player))
                player.kickPlayer(Color.translate(CaptchaPlugin.getInstance().getConfig().getString("FAILED")));
        }
    }

    @EventHandler
    public void onCaptchaClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getTitle().equals(ChatColor.RED + "Click the emerald block!")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null && !event.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) {
                player.sendMessage(Color.translate(CaptchaPlugin.getInstance().getConfig().getString("FAILED")));
                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 100, 100);
                return;
            }
            CaptchaPlugin.getPlayerArrayList().add(player);
            player.closeInventory();
            player.sendMessage(Color.translate(CaptchaPlugin.getInstance().getConfig().getString("PASSED")));
            player.playSound(player.getLocation(), Sound.VILLAGER_YES, 100, 100);
        }
    }
}
