package com.barnacle.pesky_scalies.client.renderer.entity;

import com.barnacle.pesky_scalies.PeskyScalies;
import com.barnacle.pesky_scalies.client.models.entity.GridsectModel;
import com.barnacle.pesky_scalies.entity.mob.release.Gridsect;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GridsectRenderer extends MobRenderer<Gridsect, GridsectModel<Gridsect>> {
    public GridsectRenderer(EntityRendererProvider.Context context) {
        super(context, new GridsectModel<>(context.bakeLayer(GridsectModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(Gridsect entity) {
        return ResourceLocation.fromNamespaceAndPath(PeskyScalies.MOD_ID, "textures/entity/gridsect.png");
    }

    @Override
    public void render(Gridsect entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}