package net.mrmisc.essenceofthewild.entity.custom.cow;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CowRenderer extends MobRenderer<CowEntity, CowModel<CowEntity>> {
    public CowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CowModel<>(pContext.bakeLayer(CowModel.LAYER_LOCATION)), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(CowEntity pEntity) {
        return pEntity.getVariant().location();
    }
}
