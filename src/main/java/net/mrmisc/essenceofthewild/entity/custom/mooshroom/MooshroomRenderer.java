package net.mrmisc.essenceofthewild.entity.custom.mooshroom;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mrmisc.essenceofthewild.entity.custom.cow.CowEntity;
import net.mrmisc.essenceofthewild.entity.custom.cow.CowModel;

public class MooshroomRenderer extends MobRenderer<MooshroomEntity, MooshroomModel<MooshroomEntity>> {
    public MooshroomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MooshroomModel<>(pContext.bakeLayer(MooshroomModel.LAYER_LOCATION)), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(MooshroomEntity pEntity) {
        return pEntity.getVariantMooshroom().location();
    }
}
