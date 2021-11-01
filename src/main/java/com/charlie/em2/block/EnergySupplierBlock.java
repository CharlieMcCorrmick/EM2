package com.charlie.em2.block;

import com.charlie.em2.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class EnergySupplierBlock extends Block
{
    public EnergySupplierBlock(Properties properties)
    {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return ModTileEntities.EST.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
}
