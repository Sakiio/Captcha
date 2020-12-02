package me.sakio.captcha.utils.builder;

public abstract class InventoryBuilder extends InventoryMaker implements InventoryLoader {

    public InventoryBuilder(String title, int rows) {
        super(title, rows);
    }
}