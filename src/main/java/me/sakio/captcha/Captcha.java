package me.sakio.captcha;

import lombok.Getter;
import me.sakio.captcha.listener.CaptchaListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Captcha extends JavaPlugin {
    private static Captcha instance;
    private static final List<Player> captchaList = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        reloadConfig();
        saveDefaultConfig();
        this.registerListener();
    }

    @Override
    public void onDisable() {}

    public void registerListener() {
        this.registerListeners(new CaptchaListener());
    }

    private void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> Bukkit.getServer().getPluginManager().registerEvents(l, this));
    }

    public static Captcha getInstance(){
        return Captcha.getPlugin(Captcha.class);
    }

    public static List<Player> getCaptchaList(){
        return captchaList;
    }
}
