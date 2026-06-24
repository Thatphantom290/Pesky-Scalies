package com.barnacle.pesky_scalies.client.models.entity;

import com.barnacle.pesky_scalies.PeskyScalies;
import com.barnacle.pesky_scalies.entity.mob.release.Gridsect;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class GridsectModel<T extends Gridsect> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PeskyScalies.MOD_ID, "gridsect"), "main");

    private final ModelPart root;

    public GridsectModel(ModelPart root) {
        this.root = root.getChild("root");
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-1.8F, -0.5F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-3.8F, -2.5F, -4.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 12).addBox(-4.8F, -0.5F, -1.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-0.8F, -0.5F, -5.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 14).addBox(-1.8F, -0.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 14).addBox(-4.8F, -0.5F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 23.5F, 0.5F, 0.0F, -0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Gridsect entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.resetPose();

        this.root.yRot = (float) Math.sin(limbSwing * 0.1062F) * 0.5F * limbSwingAmount;
    }
}
