package me.sakio.captcha.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Color {
    public static String translate(String translate) {
        return ChatColor.translateAlternateColorCodes('&', translate);
    }
}
