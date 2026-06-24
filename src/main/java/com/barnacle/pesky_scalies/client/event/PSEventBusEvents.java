package com.barnacle.pesky_scalies.client.event;

import com.barnacle.pesky_scalies.PeskyScalies;
import com.barnacle.pesky_scalies.client.models.entity.GridsectModel;
import com.barnacle.pesky_scalies.client.models.entity.ShameCrestModel;
import com.barnacle.pesky_scalies.entity.mob.release.Gridsect;
import com.barnacle.pesky_scalies.entity.mob.release.ShameCrest;
import com.barnacle.pesky_scalies.registry.PSEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = PeskyScalies.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PSEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GridsectModel.LAYER_LOCATION, GridsectModel::createBodyLayer);

        event.registerLayerDefinition(ShameCrestModel.LAYER_LOCATION, ShameCrestModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PSEntities.GRIDSECT.get(), Gridsect.createAttributes().build());

        event.put(PSEntities.SHAME_CREST.get(), ShameCrest.createAttributes().build());
    }
}