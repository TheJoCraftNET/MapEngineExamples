package de.pianoman911.mapengine.example;

import de.pianoman911.mapengine.api.clientside.IMapDisplay;
import de.pianoman911.mapengine.api.drawing.IDrawingSpace;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class GroupExample {

    private final Set<Player> seen = Collections.newSetFromMap(new WeakHashMap<>());

    public void sendData(IMapDisplay display, IDrawingSpace space, Player player, int z) {
        if (this.seen.add(player)) { // only send the data once
            space.ctx().receivers().add(player);
            space.ctx().z(z); // the z coordinate of the map is for sending multiple data sets to the same map
            display.pipeline().flush(space); // flush the pipeline with the z context
        }
        display.mapId(player, z); // send the map id group to the player
    }
}
