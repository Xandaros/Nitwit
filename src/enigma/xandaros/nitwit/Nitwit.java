package enigma.xandaros.nitwit;

import org.bukkit.plugin.java.JavaPlugin;

public class Nitwit extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(), this);
    }
}
