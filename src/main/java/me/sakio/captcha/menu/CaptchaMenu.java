package me.sakio.captcha.menu;

import me.sakio.captcha.Captcha;
import me.sakio.captcha.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Random;

/**
 * Created by DevSakio
 * Project: Captcha
 * Date: 02/12/2020 @ 20:17
 * Class: CaptchaMenu
 */
public class CaptchaMenu {
    public static void openCaptcha(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.RED + "Click the emerald block!");
        Random random = new Random();
        int rand = random.nextInt(9);

        for(int i = 0; i < 9; i++){
            if(!(rand == i)){
                inventory.setItem(i, new ItemBuilder(Material.REDSTONE_BLOCK).toItemStack());
            }
        }
        inventory.setItem(rand, new ItemBuilder(Material.EMERALD_BLOCK).toItemStack());
        Bukkit.getScheduler().runTask(Captcha.getInstance(), () -> player.openInventory(inventory));
    }
}
