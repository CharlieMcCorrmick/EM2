package com.charlie.em2.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class EnergyTile extends TileEntity
{

    public EnergyTile(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public EnergyTile() { this(ModTileEntities.ENERGY_TILE.get()); }
}
