package net.mrmisc.essenceofthewild.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.essenceofthewild.EssenceOfTheWildMod;
import net.mrmisc.essenceofthewild.block.EOTWBlocks;
import net.mrmisc.essenceofthewild.block.entity.custom.freezer.WoodenFreezerBlockEntity;

import java.util.Set;

public class EOTWBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EssenceOfTheWildMod.MOD_ID);

    public static RegistryObject<BlockEntityType<WoodenFreezerBlockEntity>> WOODEN_FREEZER = BLOCK_ENTITY.register("wooden_freezer",
            ()-> new BlockEntityType<>(WoodenFreezerBlockEntity::new, Set.of(EOTWBlocks.WOODEN_FREEZER.get()), null));
}
