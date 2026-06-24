package com.barnacle.pesky_scalies;

import com.barnacle.pesky_scalies.client.renderer.entity.GridsectRenderer;
import com.barnacle.pesky_scalies.client.renderer.entity.ShameCrestRenderer;
import com.barnacle.pesky_scalies.datagen.DataGenerators;
import com.barnacle.pesky_scalies.registry.PSCreativeModeTabs;
import com.barnacle.pesky_scalies.registry.PSEntities;
import com.barnacle.pesky_scalies.registry.PSItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.Locale;

@Mod(PeskyScalies.MOD_ID)
public class PeskyScalies {
    public static final String MOD_ID = "pesky_scalies";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PeskyScalies(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        PSCreativeModeTabs.register(modEventBus);

        PSItems.register(modEventBus);

        PSEntities.register(modEventBus);

        modEventBus.addListener(DataGenerators::gatherData);
    }

    public static ResourceLocation modPrefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(PSEntities.SHAME_CREST.get(), ShameCrestRenderer::new);
            EntityRenderers.register(PSEntities.GRIDSECT.get(), GridsectRenderer::new);
        }
    }
}
