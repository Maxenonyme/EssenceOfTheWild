package net.mrmisc.essenceofthewild.entity.custom.cow;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.mrmisc.essenceofthewild.EssenceOfTheWildMod;

public class CowModel extends HierarchicalModel<CowEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EssenceOfTheWildMod.MOD_ID, "cow"), "main");
	private final ModelPart bone;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart Neck;
	private final ModelPart right_ear;
	private final ModelPart left_ear;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart Utter;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public CowModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.body = this.bone.getChild("body");
		this.head = this.body.getChild("head");
		this.Neck = this.head.getChild("Neck");
		this.right_ear = this.head.getChild("right_ear");
		this.left_ear = this.head.getChild("left_ear");
		this.bone2 = this.body.getChild("bone2");
		this.bone3 = this.bone2.getChild("bone3");
		this.Utter = this.body.getChild("Utter");
		this.leg1 = this.bone.getChild("leg1");
		this.leg2 = this.bone.getChild("leg2");
		this.leg3 = this.bone.getChild("leg3");
		this.leg4 = this.bone.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 7.0F));

		PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -12.0F, 10.0F, 14.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(68, 78).addBox(-5.0F, 9.0F, -12.0F, 10.0F, 3.0F, 20.0F, new CubeDeformation(0.01F))
		.texOffs(82, 105).addBox(-2.0F, -10.0F, -10.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -5.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, -4.0F, -6.0F, 5.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(100, 34).addBox(-3.5F, -4.99F, -7.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.001F))
		.texOffs(99, 58).addBox(-3.5F, -1.99F, -7.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 55).addBox(-2.5F, 2.0F, -7.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(7.5F, -9.0F, -5.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(33, 113).addBox(5.5F, -11.0F, -5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(37, 109).addBox(3.5F, -11.0F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 86).addBox(-9.5F, -9.0F, -5.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(51, 73).addBox(-7.5F, -11.0F, -5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 69).addBox(-5.5F, -11.0F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(73, 77).addBox(2.5F, -6.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 124).addBox(2.5F, -4.0F, -5.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(43, 124).addBox(2.5F, -4.0F, -5.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(114, 0).addBox(-7.5F, -4.0F, -5.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 124).addBox(-9.5F, -4.0F, -5.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(5, 94).addBox(-4.5F, -6.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -12.0F));

		PartDefinition Neck = head.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(101, 0).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(109, 120).addBox(-1.0F, 6.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(60, 3).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(75, 15).addBox(-5.0F, -1.0F, 0.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.0F, -2.0F));

		PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(60, 0).addBox(0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(79, 1).addBox(0.0F, -1.0F, 0.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -1.0F, -2.0F));

		PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(54, 42).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 8.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(12, 55).addBox(-1.0F, 0.0F, -0.99F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 1.0F));

		PartDefinition Utter = body.addOrReplaceChild("Utter", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 53).addBox(-1.0F, 2.0F, -2.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 2.0F));

		PartDefinition leg1 = bone.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(22, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 3.0F, 1.0F));

		PartDefinition leg2 = bone.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(38, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.0F, 1.0F));

		PartDefinition leg3 = bone.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(22, 47).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 3.0F, -14.0F));

		PartDefinition leg4 = bone.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(38, 47).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.0F, -14.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.bone;
	}

	@Override
	public void setupAnim(CowEntity cow, float limbSwing, float limbSwingAmount, float ageInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (limbSwingAmount < 0.01F) {
			this.animate(cow.idleAnimationState, CowAnimations.cow_idle, ageInTicks);
		} else {
			double speed = cow.getDeltaMovement().horizontalDistance();
			if (speed > 0.2D) {
				this.animateWalk(CowAnimations.cow_run, limbSwing, limbSwingAmount, 4.0f, 2.5F);
			} else {
				this.animateWalk(CowAnimations.cow_walk, limbSwing, limbSwingAmount, 2.8f, 1.3F);
			}
		}
	}
}