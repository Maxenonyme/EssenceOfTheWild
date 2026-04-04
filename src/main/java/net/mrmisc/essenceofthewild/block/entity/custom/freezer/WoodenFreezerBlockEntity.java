package net.mrmisc.essenceofthewild.block.entity.custom.freezer;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.mrmisc.essenceofthewild.block.custom.freezer.WoodenFreezerBlock;
import net.mrmisc.essenceofthewild.block.entity.EOTWBlockEntities;
import org.jetbrains.annotations.Nullable;

public class WoodenFreezerBlockEntity extends BlockEntity implements MenuProvider {

    private int milkLevel = 0;
    private int coneCount = 0;
    private FreezerContent content = FreezerContent.NO_CONE;

    public WoodenFreezerBlockEntity(BlockPos pos, BlockState state) {
        super(EOTWBlockEntities.WOODEN_FREEZER.get(), pos, state);
    }

    public int getMilkLevel() {
        return milkLevel;
    }

    public int getConeCount() {
        return coneCount;
    }

    public FreezerContent getContent() {
        return content;
    }

    public void setMilkLevel(int level) {
        this.milkLevel = Mth.clamp(level, 0, 3);
        syncState();
        setChanged();
    }

    public void setConeCount(int count) {
        this.coneCount = Mth.clamp(count, 0, 3);

        if (this.coneCount == 0) {
            this.content = FreezerContent.NO_CONE;
        }

        syncState();
        setChanged();
    }

    public void setContent(FreezerContent content) {
        this.content = content == null ? FreezerContent.NO_CONE : content;
        syncState();
        setChanged();
    }

    private void syncState() {
        if (level == null || level.isClientSide) return;

        BlockState state = getBlockState();

        if (!state.hasProperty(WoodenFreezerBlock.CONE_COUNT)
                || !state.hasProperty(WoodenFreezerBlock.CONTENT)
                || !state.hasProperty(WoodenFreezerBlock.MILK_LEVEL)) {
            return;
        }

        level.setBlock(
                worldPosition,
                state.setValue(WoodenFreezerBlock.CONE_COUNT, coneCount)
                        .setValue(WoodenFreezerBlock.CONTENT, content)
                        .setValue(WoodenFreezerBlock.MILK_LEVEL, milkLevel),
                Block.UPDATE_CLIENTS
        );
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Wooden Freezer");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return null;
    }
}