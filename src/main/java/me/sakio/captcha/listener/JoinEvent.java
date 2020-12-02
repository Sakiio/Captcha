package me.sakio.captcha.listener;

import me.sakio.captcha.Captcha;
import me.sakio.captcha.menu.CaptchaMenu;
import me.sakio.captcha.utils.Color;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
public class JoinEvent implements Listener {

    @EventHandler
    public void onCaptchaClose(InventoryCloseEvent event) {
        if (event.getInventory().getName().equals(ChatColor.RED + "Click the emerald block!")) {
            Player player = (Player) event.getPlayer();

            if (!Captcha.getCaptchaList().contains(player))
                player.kickPlayer(Color.translate(Captcha.getInstance().getConfig().getString("CAPTCHA.FAILED")));
        }
    }

    @EventHandler
    public void onCaptchaClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getTitle().equals(ChatColor.RED + "Click the emerald block!")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null && !event.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) {
                player.sendMessage(Color.translate(Captcha.getInstance().getConfig().getString("CAPTCHA.FAILED")));
                return;
            }
            Captcha.getCaptchaList().add(player);
            player.closeInventory();
            player.sendMessage(Color.translate(Captcha.getInstance().getConfig().getString("CAPTCHA.PASSED")));
        }
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Captcha.getInstance().getConfig().getBoolean("CAPTCHA.ENABLED")) {
            if (Captcha.getInstance().getConfig().getBoolean("CAPTCHA.BYPASS")) {
                if (!event.getPlayer().hasPermission(Captcha.getInstance().getConfig().getString("CAPTCHA.BYPASS_PERMISSION"))) {
                    CaptchaMenu.openCaptcha(event.getPlayer());
                }
            } else {
                CaptchaMenu.openCaptcha(event.getPlayer());
            }
        }
    }
}
