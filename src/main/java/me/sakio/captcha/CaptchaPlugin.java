package me.sakio.captcha;

import lombok.Getter;
import me.sakio.captcha.listener.CaptchaListener;
import me.sakio.captcha.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CaptchaPlugin extends JavaPlugin {
    private static final List<Player> playerArrayList = new ArrayList<>();

    @Override
    public void onEnable() {
        reloadConfig();
        saveDefaultConfig();
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new CaptchaListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
    }

    @Override
    public void onDisable() {}

    public static CaptchaPlugin getInstance(){
        return CaptchaPlugin.getPlugin(CaptchaPlugin.class);
    }

    public static List<Player> getCaptchaList(){
        return playerArrayList;
    }
}
