package com.Even.goofyahhmod.container;

import com.Even.goofyahhmod.GoofyAhhMod;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, GoofyAhhMod.MOD_ID);

    public static final RegistryObject<ContainerType<TonneroliumEnergizerContainer>> TONNEROLIUM_ENERGIZER_CONTAINER
            = CONTAINERS.register("tonnerolium_energizer_container", () -> IForgeContainerType.create(((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new TonneroliumEnergizerContainer(windowId, world, pos, inv, inv.player);
    })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
