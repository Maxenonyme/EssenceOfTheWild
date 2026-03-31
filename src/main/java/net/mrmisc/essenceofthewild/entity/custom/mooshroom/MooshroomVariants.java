package net.mrmisc.essenceofthewild.entity.custom.mooshroom;

import net.minecraft.resources.ResourceLocation;
import net.mrmisc.essenceofthewild.EssenceOfTheWildMod;
import net.mrmisc.essenceofthewild.entity.util.MobVariant;

import java.util.List;

public class MooshroomVariants {
    public static final MobVariant RED =
            new MobVariant("red",
                    ResourceLocation.fromNamespaceAndPath(EssenceOfTheWildMod.MOD_ID,
                            "textures/entity/mooshroom/mooshroom.png"),
                    false, false);
    public static final MobVariant BROWN =
            new MobVariant("brown",
                    ResourceLocation.fromNamespaceAndPath(EssenceOfTheWildMod.MOD_ID,
                            "textures/entity/mooshroom/brown_mooshroom.png"),
                    false, false);

    public static final List<MobVariant> ALL = List.of(RED, BROWN);
}
