package notjoe.tmm;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import notjoe.tmm.common.CommonProxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = TooManyMetals.MODID, version = TooManyMetals.VERSION, dependencies = "after:thermalexpansion;after:tconstruct")
public class TooManyMetals {
    public static final String MODID = "tmm";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "notjoe.tmm.client.ClientProxy",
            serverSide = "notjoe.tmm.common.CommonProxy")
    public static CommonProxy PROXY;
    public static Logger LOGGER;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
        LOGGER.info("Starting pre-init.");
        PROXY.onPreInit(event);
        LOGGER.info("Pre-init completed.");
    }
    
    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        LOGGER.info("Starting init.");
        PROXY.onInit(event);
        LOGGER.info("Init completed.");
    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting post-init.");
        PROXY.onPostInit(event);
        LOGGER.info("Post-init completed.");
    }
}
