package com.charlie.em2.tileentity;

import com.charlie.em2.util.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class EnergyCollectorTile extends TileEntity implements ITickableTileEntity
{
    private CustomEnergyStorage energyStorage = createEnergy();

    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    private int counter = 0;

    public EnergyCollectorTile() { this(ModTileEntities.ENERGY_COLLECTOR_TILE.get()); }

    public EnergyCollectorTile(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    @Override
    public void tick()
    {

    }

    private CustomEnergyStorage createEnergy()
    {
        return new CustomEnergyStorage(1000000, 1000)
        {
            @Override
            protected void onEnergyChanged()
            {
                markDirty();
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        if(cap == CapabilityEnergy.ENERGY)
        {
            return energy.cast();
        }

        return super.getCapability(cap, side);
    }
}
