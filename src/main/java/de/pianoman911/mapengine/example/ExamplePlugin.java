package de.pianoman911.mapengine.example;

import de.pianoman911.mapengine.api.MapEngineApi;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ExamplePlugin extends JavaPlugin {

    private MapEngineApi api;

    @Override
    public void onEnable() {
        RegisteredServiceProvider<MapEngineApi> registration = getServer().getServicesManager().getRegistration(MapEngineApi.class);
        this.api = Objects.requireNonNull(registration).getProvider();
    }

    public MapEngineApi getApi() {
        return this.api;
    }
}
