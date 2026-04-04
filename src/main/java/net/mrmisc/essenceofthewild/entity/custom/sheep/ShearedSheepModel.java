package net.mrmisc.essenceofthewild.entity.custom.sheep;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.client.model.HierarchicalModel;
import net.mrmisc.essenceofthewild.EssenceOfTheWildMod;

public class ShearedSheepModel extends HierarchicalModel<SheepEntity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EssenceOfTheWildMod.MOD_ID, "sheared_sheep"), "main");
	private final ModelPart bone;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart body;
	private final ModelPart head;

	public ShearedSheepModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.leg1 = this.bone.getChild("leg1");
		this.leg2 = this.bone.getChild("leg2");
		this.leg3 = this.bone.getChild("leg3");
		this.leg4 = this.bone.getChild("leg4");
		this.body = this.bone.getChild("body");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 27.0F, 0.0F));

		PartDefinition leg1 = bone.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(36, 25).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -12.0F, 7.0F));

		PartDefinition leg2 = bone.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -12.0F, 7.0F));

		PartDefinition leg3 = bone.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(12, 34).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -12.0F, -5.0F));

		PartDefinition leg4 = bone.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(24, 25).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -12.0F, -5.0F));

		PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -9.0F, 7.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 55).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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
	public void setupAnim(SheepEntity sheep, float limbSwing, float limbSwingAmount, float ageInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (sheep.isEating()) {
			this.animate(sheep.eatAnimationState, ShearedSheepAnimations.sheep_eat, ageInTicks);
			return;
		}

		if (limbSwingAmount < 0.01F) {
			this.animate(sheep.idleAnimationState, ShearedSheepAnimations.sheep_idle, ageInTicks);
		} else {
			double speed = sheep.getDeltaMovement().horizontalDistance();

			if (speed > 0.2D) {
				this.animateWalk(ShearedSheepAnimations.sheep_run, limbSwing, limbSwingAmount, 3.5F, 2.5F);
			} else {
				this.animateWalk(ShearedSheepAnimations.sheep_walk, limbSwing, limbSwingAmount, 1.6F, 1.3F);
			}
		}
	}
}