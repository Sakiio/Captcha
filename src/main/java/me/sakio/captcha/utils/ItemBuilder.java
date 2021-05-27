package me.sakio.captcha.utils;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder
{
    private final ItemStack is;

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(Material m, int amount) {
        this.is = new ItemStack(m, amount);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }

    public ItemStack toItemStack() {
        return this.is;
    }

}
