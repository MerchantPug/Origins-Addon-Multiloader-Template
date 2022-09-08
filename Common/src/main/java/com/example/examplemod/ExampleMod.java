package com.example.examplemod;

import com.example.examplemod.platform.Services;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod {
    
    public static final String MOD_ID = "originsmultiloader";
    public static final String MOD_NAME = "Origins Multi Loader Template";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    
    // This method serves as an initialization hook for the mod. The vanilla
    // game has no mechanism to load tooltip listeners so this must be
    // invoked from a mod loader specific project like Forge or Fabric.
    public static void init() {
        LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
    }
    
    public static ResourceLocation asResource(String name) {
        return new ResourceLocation(name);
    }
    
}