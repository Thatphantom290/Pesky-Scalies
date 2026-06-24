package com.barnacle.pesky_scalies.client.models.entity;

import com.barnacle.pesky_scalies.PeskyScalies;
import com.barnacle.pesky_scalies.client.animations.entity.ShameCrestAnimations;
import com.barnacle.pesky_scalies.entity.mob.release.ShameCrest;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ShameCrestModel<T extends ShameCrest> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PeskyScalies.MOD_ID, "shame_crest"), "main");

    private final ModelPart root;
    private final ModelPart torso;
    private final ModelPart tail;
    private final ModelPart tail_tip;
    private final ModelPart left_Arm;
    private final ModelPart right_Arm;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart left_leg;
    private final ModelPart left_toe;
    private final ModelPart right_leg;
    private final ModelPart right_toe;

    public ShameCrestModel(ModelPart root) {
        this.root = root.getChild("root");
        this.torso = this.root.getChild("torso");
        this.tail = this.torso.getChild("tail");
        this.tail_tip = this.tail.getChild("tail_tip");
        this.left_Arm = this.torso.getChild("left_Arm");
        this.right_Arm = this.torso.getChild("right_Arm");
        this.head = this.torso.getChild("head");
        this.body = this.torso.getChild("body");
        this.left_leg = this.root.getChild("left_leg");
        this.left_toe = this.left_leg.getChild("left_toe");
        this.right_leg = this.root.getChild("right_leg");
        this.right_toe = this.right_leg.getChild("right_toe");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 1.0F));

        PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(20, 13).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));

        PartDefinition tail_tip = tail.addOrReplaceChild("tail_tip", CubeListBuilder.create().texOffs(20, 23).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition left_Arm = torso.addOrReplaceChild("left_Arm", CubeListBuilder.create().texOffs(14, 24).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -5.0F));

        PartDefinition right_Arm = torso.addOrReplaceChild("right_Arm", CubeListBuilder.create().texOffs(14, 29).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -5.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

        PartDefinition body = torso.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(10, 31).addBox(0.0F, 3.0F, 1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -8.0F, 2.0F));

        PartDefinition left_toe = left_leg.addOrReplaceChild("left_toe", CubeListBuilder.create().texOffs(30, 7).addBox(-1.5F, -0.1F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 8.0F, 1.0F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(12, 31).addBox(-1.0F, 3.0F, 1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -8.0F, 2.0F));

        PartDefinition right_toe = right_leg.addOrReplaceChild("right_toe", CubeListBuilder.create().texOffs(30, 10).addBox(-1.5F, -0.1F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 8.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 48, 48);
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
    public void setupAnim(ShameCrest entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float deg = ((float) Math.PI / 180F);
        this.animateWalk(ShameCrestAnimations.SHAME_CREST_WALK, limbSwing, limbSwingAmount, 2, 4);
        this.animate(entity.idleAnimationState, ShameCrestAnimations.SHAME_CREST_IDLE, ageInTicks, 1f);
        if (this.young) this.applyStatic(ShameCrestAnimations.SHAME_CREST_BABY_TRANSFORM);

        this.head.xRot += headPitch * deg / 2;
        this.head.yRot += netHeadYaw * deg / 2;
    }
}
