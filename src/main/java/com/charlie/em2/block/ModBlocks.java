package com.charlie.em2.block;

import com.charlie.em2.EM2;
import com.charlie.em2.item.ModItemGroup;
import com.charlie.em2.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks
{

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EM2.MOD_ID);

    public static final RegistryObject<Block> QUARRY_ONE_BLOCK = registerBlock("quarry_one",
            () -> new QuarryOneBlock(AbstractBlock.Properties.create(Material.ROCK)));

    public static final RegistryObject<Block> ENERGY_BLOCK = registerBlock("energy",
            () -> new EnergyBlock(AbstractBlock.Properties.create(Material.ROCK)));

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }


    // Helper Methods
    private static <T extends Block>RegistryObject<T>registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(),
                        new Item.Properties().group(ModItemGroup.SGB_GROUP)));
    }
}
