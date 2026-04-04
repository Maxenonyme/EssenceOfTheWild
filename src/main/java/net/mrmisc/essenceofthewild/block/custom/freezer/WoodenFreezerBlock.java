package net.mrmisc.essenceofthewild.block.custom.freezer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.mrmisc.essenceofthewild.block.entity.custom.freezer.FreezerContent;
import net.mrmisc.essenceofthewild.block.entity.custom.freezer.WoodenFreezerBlockEntity;

import org.jetbrains.annotations.Nullable;

public class WoodenFreezerBlock extends BaseEntityBlock {

    public static final IntegerProperty CONE_COUNT = IntegerProperty.create("cone_count", 0, 3);
    public static final EnumProperty<FreezerContent> CONTENT = EnumProperty.create("content", FreezerContent.class);
    public static final IntegerProperty MILK_LEVEL = IntegerProperty.create("milk_level", 0, 3);

    public WoodenFreezerBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(CONE_COUNT, 0)
                .setValue(CONTENT, FreezerContent.NO_CONE)
                .setValue(MILK_LEVEL, 0)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CONE_COUNT, CONTENT, MILK_LEVEL);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return false;
    }

    @Override
    public float getShadeBrightness(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 1.0f;
    }

    @Override
    public int getLightBlock(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 0;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WoodenFreezerBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}