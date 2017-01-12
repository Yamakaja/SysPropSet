package me.yamakaja.syspropset;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created by Yamakaja on 12.01.17.
 */
public class Main extends JavaPlugin {

    @Override
    public void onLoad() {
        saveDefaultConfig();
        List<String> properties = getConfig().getStringList("properties");
        for (String prop : properties) {
            String[] split = prop.split("=");
            try {
                System.setProperty(split[0], split[1]);
            } catch(SecurityException e) {
                System.out.println("Security Manager is blocking access!");
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid syntax: " + prop);
            }
        }
    }

}
