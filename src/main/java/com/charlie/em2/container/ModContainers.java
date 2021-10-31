package com.charlie.em2.container;

import com.charlie.em2.EM2;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers
{
    public static DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, EM2.MOD_ID);

    public static final RegistryObject<ContainerType<QuarryOneContainer>> QUARRY_ONE_CONTAINER =
            CONTAINERS.register("quarry_one_container",
                    () -> IForgeContainerType.create((((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new QuarryOneContainer(windowId, world, pos, inv, inv.player);
                    }))));

    public static final RegistryObject<ContainerType<EnergyContainer>> ENERGY_CONTAINER =
            CONTAINERS.register("energy_container",
                    () -> IForgeContainerType.create(((((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new EnergyContainer(windowId, world, pos, inv, inv.player);
                    })))));

    public static void register(IEventBus eventBus)
    {
        CONTAINERS.register(eventBus);
    }
}
