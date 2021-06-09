package me.sakio.captcha.listener;

import me.sakio.captcha.CaptchaPlugin;
import me.sakio.captcha.menu.CaptchaMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Project: Captcha
 * Date: 09/06/2021 @ 15:57
 * Class: JoinListener
 */
public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if (CaptchaPlugin.getInstance().getConfig().getBoolean("ENABLED")) {
            if (CaptchaPlugin.getInstance().getConfig().getBoolean("BYPASS")) {
                if (!event.getPlayer().hasPermission(CaptchaPlugin.getInstance().getConfig().getString("BYPASS_PERMISSION"))) {
                    CaptchaMenu.openCaptcha(event.getPlayer());
                }
            } else {
                CaptchaMenu.openCaptcha(event.getPlayer());
            }
        }
    }
}
