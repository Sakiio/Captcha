package me.sakio.captcha;

import lombok.Getter;
import me.sakio.captcha.listener.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Captcha extends JavaPlugin {
    @Getter
    private static Captcha instance;
    @Getter
    private static final List<Player> captchaList = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        reloadConfig();
        saveDefaultConfig();
        this.registerListeners();
        this.registerCommands();
    }

    @Override
    public void onDisable() {
    }

    public void registerCommands() {
        this.registerListeners(
                new JoinEvent()
        );
    }
    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> Bukkit.getServer().getPluginManager().registerEvents(l, this));
    }
}
