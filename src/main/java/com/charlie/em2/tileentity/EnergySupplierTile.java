package com.charlie.em2.tileentity;

import com.charlie.em2.util.CustomEnergyStorage;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class EnergySupplierTile extends TileEntity implements ITickableTileEntity
{
    protected int MAX_OUTPUT;
    protected CustomEnergyStorage energyStorage = createEnergy();
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> createEnergy());

    public EnergySupplierTile()
    {
        super(ModTileEntities.ENERGY_SUPPLIER_TILE.get());
        MAX_OUTPUT = 1000;
    }

    protected void generatePower()
    {
        energyStorage.addEnergy(10000);
    }

    @Override
    public void tick()
    {
        generatePower();
        sendOutPower();
    }

    private void sendOutPower()
    {
        AtomicInteger capacity = new AtomicInteger(energyStorage.getEnergyStored());
        if(capacity.get() > 0)
        {
            for(Direction direction : Direction.values())
            {
                TileEntity tileEntity = world.getTileEntity(pos.offset(direction));
                if(tileEntity != null)
                {
                    boolean doContinue = tileEntity.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                        if(handler.canReceive()) {
                            int recieved = handler.receiveEnergy(Math.min(capacity.get(), MAX_OUTPUT), false);
                            capacity.addAndGet(-recieved);
                            energyStorage.consumeEnergy(recieved);
                            markDirty();
                            return capacity.get() > 0;
                        }
                        else
                        {
                            return true;
                        }
                }).orElse(true);
                    if(!doContinue)
                    {
                        return;
                    }
                }
            }
        }
    }

    private CustomEnergyStorage createEnergy()
    {
        return new CustomEnergyStorage(Integer.MAX_VALUE, 0);
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
