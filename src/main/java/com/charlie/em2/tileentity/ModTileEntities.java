package com.charlie.em2.tileentity;

import com.charlie.em2.EM2;
import com.charlie.em2.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities
{
     public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
             DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, EM2.MOD_ID);

     public static RegistryObject<TileEntityType<QuarryOneTile>> QUARRY_ONE_TILE =
             TILE_ENTITIES.register("quarry_one_tile", () -> TileEntityType.Builder.create(
                QuarryOneTile::new, ModBlocks.QUARRY_ONE_BLOCK.get()).build(null)
             );

     public static RegistryObject<TileEntityType<EnergyTile>> ENERGY_TILE =
             TILE_ENTITIES.register("energy_tile", () -> TileEntityType.Builder.create(
                     EnergyTile::new, ModBlocks.ENERGY_BLOCK.get()).build(null)
             );

     public static void register(IEventBus eventBus)
     {
         TILE_ENTITIES.register(eventBus);
     }
}
