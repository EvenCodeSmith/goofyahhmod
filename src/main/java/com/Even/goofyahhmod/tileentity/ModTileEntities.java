package com.Even.goofyahhmod.tileentity;

import com.Even.goofyahhmod.GoofyAhhMod;
import com.Even.goofyahhmod.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GoofyAhhMod.MOD_ID);

    public static final RegistryObject<TileEntityType<TonneroliumEnergizerTile>> TONNEROLIUM_ENERGIZER_TILE =
            TILE_ENTITIES.register("tonnerolium_energizer_tile", () -> TileEntityType.Builder.create(
                    TonneroliumEnergizerTile::new, ModBlocks.TONNEROLIUM_ENERGIZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
