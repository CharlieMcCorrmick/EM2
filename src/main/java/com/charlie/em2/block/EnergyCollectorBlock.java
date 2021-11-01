package com.charlie.em2.block;

import com.charlie.em2.tileentity.EnergyCollectorTile;
import com.charlie.em2.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EnergyCollectorBlock extends Block
{
    public EnergyCollectorBlock(Properties properties)
    {
        super(properties);
    }

//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
//                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        if(!worldIn.isRemote()) {
//            TileEntity tileEntity = worldIn.getTileEntity(pos);
//
//            if(!player.isCrouching()) {
//                if(tileEntity instanceof EnergyCollectorTile)
//                {
//                    ((EnergyCollectorTile) tileEntity).
////                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);
////
////                    NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
//                }
////                else
////                {
////                    throw new IllegalStateException("Our Container provider is missing!");
////                }
//            }
//        }
//        return ActionResultType.SUCCESS;
//    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return ModTileEntities.ENERGY_COLLECTOR_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
}
