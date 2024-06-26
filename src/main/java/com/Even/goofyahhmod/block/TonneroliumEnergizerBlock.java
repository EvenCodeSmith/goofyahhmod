package com.Even.goofyahhmod.block;

import com.Even.goofyahhmod.container.TonneroliumEnergizerContainer;
import com.Even.goofyahhmod.tileentity.ModTileEntities;
import com.Even.goofyahhmod.tileentity.TonneroliumEnergizerTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class TonneroliumEnergizerBlock extends Block {
    public TonneroliumEnergizerBlock(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if(!player.isCrouching())
            {
                if(tileentity instanceof TonneroliumEnergizerTile){
                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                    NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileentity.getPos());
                } else {
                    throw new IllegalStateException("Container provider is missing!" );
                }

            } else {
                if(tileentity instanceof TonneroliumEnergizerTile){
                    if(worldIn.isThundering()){
                        EntityType.LIGHTNING_BOLT.spawn(((ServerWorld) worldIn), null, player, pos, SpawnReason.TRIGGERED, true, true);

                        ((TonneroliumEnergizerTile) tileentity).lightningHasStruck();
                    }
                }

            }
        }


        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.goofyahhmod.tonnerolium_energizer");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new TonneroliumEnergizerContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.TONNEROLIUM_ENERGIZER_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
