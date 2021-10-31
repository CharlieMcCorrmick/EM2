package com.charlie.em2.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MinecartItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class QuarryOneTile extends TileEntity
{
    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public QuarryOneTile(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public QuarryOneTile()
    {
        this(ModTileEntities.QUARRY_ONE_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt)
    {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(2)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }

            /**
             * Checks if item in a specified slot is valid,
             * always returns false here since no items can be input
             * @param slot being checked (theres only 1 is this necessary)
             * @param stack of items being inserted
             * @return false since so items should be inserted
             */
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {
                return true;
            }

            @Override
            public int getSlotLimit(int slot)
            {
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {
                //hypothetically unnecessary as isItemValid always returns false but hey whos counting
                if(!isItemValid(slot, stack)) return stack;
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    public void generateResource()
    {
        boolean valid = this.itemHandler.getStackInSlot(0).getCount() == 0;
                //&& this.getPos().getY() <= 69;
        if(valid)
        {
            this.itemHandler.insertItem(0, new ItemStack(MinecartItem.getItemById(1).getItem()), false);
        }
    }
}
