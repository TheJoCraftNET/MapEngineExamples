package de.pianoman911.mapengine.example;

import de.pianoman911.mapengine.api.MapEngineApi;
import de.pianoman911.mapengine.api.clientside.IMapDisplay;
import de.pianoman911.mapengine.api.drawing.IDrawingSpace;
import de.pianoman911.mapengine.api.util.Converter;
import de.pianoman911.mapengine.api.util.FullSpacedColorBuffer;
import de.pianoman911.mapengine.api.util.ImageUtils;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockVector;

import java.awt.image.BufferedImage;

public class BasicExample {

    private final MapEngineApi api;

    public BasicExample(MapEngineApi api) {
        this.api = api;
    }

    public void foo(BufferedImage image, BlockVector cornerA, BlockVector cornerB, BlockFace facing, Player viewer) {
        // create a map display instance
        IMapDisplay display = api.displayProvider().createBasic(cornerA, cornerB, facing);
        display.spawn(viewer); // spawn the map display for the player

        // create a color buffer for 2x2 item frames (128x128 pixels per map)
        FullSpacedColorBuffer buffer = new FullSpacedColorBuffer(256, 256);

        // resize the image
        image = ImageUtils.resize(image, 256, 256);

        // get all rgb values of the image
        int[] rgb = ImageUtils.rgb(image);

        // set the rgb values of the buffer
        // starting at x: 0 and y: 0
        // end at width: 256 and height: 256
        buffer.pixels(rgb, 0, 0, 256, 256);

        // create an input pipeline element
        // this object can also be used to draw simple shapes and text
        IDrawingSpace input = api.pipeline().drawingSpace(buffer, display);

        // add a player to the pipeline context,
        // making the player receive the map
        input.ctx().receivers().add(viewer);

        // enable floyd-steinberg dithering
        input.ctx().converter(Converter.FLOYD_STEINBERG);

        // flush the pipeline
        // the drawing space can be reused
        display.pipeline().flush(input);
    }
}
