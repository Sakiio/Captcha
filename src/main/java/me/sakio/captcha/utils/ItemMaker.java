package me.sakio.captcha.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemMaker {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemMaker(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemMaker setDisplayName(String name) {
        this.itemMeta.setDisplayName(Color.translate(name));
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemMaker addLore(String... strings) {
        this.itemMeta.setLore(Arrays.asList(strings));
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemMaker addLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemMaker setDurability(short durability) {
        this.itemStack.setDurability(durability);
        return this;
    }

    public ItemStack create() {
        return this.itemStack;
    }
}
