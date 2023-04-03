package de.pianoman911.mapengine.example;

import de.pianoman911.mapengine.api.clientside.IMapDisplay;
import de.pianoman911.mapengine.api.pipeline.IPipelineContext;
import de.pianoman911.mapengine.api.pipeline.IPipelineStream;
import de.pianoman911.mapengine.api.util.FullSpacedColorBuffer;

public class CustomPipelineExample {

    public void addCustomPipelineNode(IMapDisplay display) {
        display.pipeline().addNode(new CustomPipeline());
    }

    public static class CustomPipeline implements IPipelineStream {

        @Override
        public FullSpacedColorBuffer compute(FullSpacedColorBuffer buffer, IPipelineContext context) {
            // do something with the buffer
            return buffer;
        }
    }
}
