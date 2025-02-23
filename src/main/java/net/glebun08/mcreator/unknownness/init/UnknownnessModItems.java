
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.glebun08.mcreator.unknownness.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.glebun08.mcreator.unknownness.UnknownnessMod;

public class UnknownnessModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, UnknownnessMod.MODID);
	public static final RegistryObject<Item> SHADOW_SPAWN_EGG = REGISTRY.register("shadow_spawn_egg", () -> new ForgeSpawnEggItem(UnknownnessModEntities.SHADOW, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> SHADOW_1_SPAWN_EGG = REGISTRY.register("shadow_1_spawn_egg", () -> new ForgeSpawnEggItem(UnknownnessModEntities.SHADOW_1, -1, -1, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
