package net.mrmisc.essenceofthewild.block.entity.custom.freezer;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum FreezerContent implements StringRepresentable {
    NO_CONE("no_cone"),
    CONE("cone"),
    ICECREAM("icecream");

    private final String name;

    FreezerContent(String name) {
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}
