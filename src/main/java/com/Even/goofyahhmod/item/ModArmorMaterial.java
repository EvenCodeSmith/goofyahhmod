package com.Even.goofyahhmod.item;

import com.Even.goofyahhmod.GoofyAhhMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;
import java.util.function.Supplier;

public enum  ModArmorMaterial implements IArmorMaterial {
        FBMATERIALBLUE("fbmaterialblue",7, new int[] {20, 30, 50, 20}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 11f, 100f, () -> {return Ingredient.fromItems(ModItems.AMETHYST.get());
        }),FBMATERIALBLACK("fbmaterialblack",7, new int[] {20, 30, 50, 20}, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 11f, 100f, () -> {return Ingredient.fromItems(ModItems.AMETHYST.get());
    }),TONNEROLIUM("tonnerolium",40, new int[] {5, 8, 10, 4}, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5f, 0.1f, () -> {return Ingredient.fromItems(ModItems.TONNEROLIUM.get());
    }),MACCERONIUM("macceronium",69420, new int[] {10, 16, 20, 8}, 34, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 10f, 0.3f, () -> {return Ingredient.fromItems(ModItems.MACCERONIUM.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue(repairMaterial);
    }


    public int getDurability(EquipmentSlotType p_200896_1_) {
        return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType p_200902_1_) {
        return this.damageReductionAmountArray[p_200902_1_.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return (Ingredient)this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return GoofyAhhMod.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
