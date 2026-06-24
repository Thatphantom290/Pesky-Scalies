package com.barnacle.pesky_scalies.client.renderer.entity;

import com.barnacle.pesky_scalies.PeskyScalies;
import com.barnacle.pesky_scalies.client.models.entity.ShameCrestModel;
import com.barnacle.pesky_scalies.client.variants.ShameCrestVariant;
import com.barnacle.pesky_scalies.entity.mob.release.ShameCrest;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class ShameCrestRenderer extends MobRenderer<ShameCrest, ShameCrestModel<ShameCrest>> {
    private static final Map<ShameCrestVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ShameCrestVariant.class), map -> {
                map.put(ShameCrestVariant.COMMON,
                        ResourceLocation.fromNamespaceAndPath(PeskyScalies.MOD_ID, "textures/entity/shame_crest/common_shame_crest.png"));
                map.put(ShameCrestVariant.GIGGLE,
                        ResourceLocation.fromNamespaceAndPath(PeskyScalies.MOD_ID, "textures/entity/shame_crest/giggle_shame_crest.png"));
                map.put(ShameCrestVariant.ZEB,
                        ResourceLocation.fromNamespaceAndPath(PeskyScalies.MOD_ID, "textures/entity/shame_crest/zeb_shame_crest.png"));
            });

    public ShameCrestRenderer(EntityRendererProvider.Context context) {
        super(context, new ShameCrestModel<>(context.bakeLayer(ShameCrestModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShameCrest entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(ShameCrest entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}