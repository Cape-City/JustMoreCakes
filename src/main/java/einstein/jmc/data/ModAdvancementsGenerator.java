package einstein.jmc.data;

import einstein.jmc.JustMoreCakes;
import einstein.jmc.init.ModBlocks;
import einstein.jmc.init.ModItems;
import einstein.jmc.util.CakeBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModAdvancementsGenerator extends AdvancementProvider {

	public ModAdvancementsGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, existingFileHelper);
	}
	
	@Override
	protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
		Advancement craftCake = addCakes(Advancement.Builder.advancement().parent(new ResourceLocation("minecraft:husbandry/plant_seed")).requirements(RequirementsStrategy.OR)
			.display(Blocks.CAKE.asItem(), translatable("craft_cake.title"), translatable("craft_cake.description"), null, FrameType.TASK, true, true, false))
			.save(consumer, modLoc("husbandry/craft_cake"), fileHelper);
		addCakes(Advancement.Builder.advancement().parent(craftCake))
			.display(ModBlocks.CHOCOLATE_CAKE.get(), translatable("craft_all_cakes.title"), translatable("craft_all_cakes.description"), null, FrameType.CHALLENGE, true, true, false)
			.rewards(AdvancementRewards.Builder.experience(100)).save(consumer, modLoc("husbandry/craft_all_cakes"), fileHelper);
	}
	
	private Advancement.Builder addCakes(Advancement.Builder advancement) {
		advancement.addCriterion("cake", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Blocks.CAKE).build()));
		advancement.addCriterion("cupcake", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModItems.CUPCAKE.get()).build()));

		for (RegistryObject<?> cake : CakeBuilder.BUILDER_BY_CAKE.keySet()) {
			Item cakeItem = ((ItemLike) cake.get()).asItem();
			advancement.addCriterion(cake.getId().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(cakeItem).build()));
		}
		
		return advancement;
	}
	
	private Component translatable(String str) {
		return Component.translatable("advancements.husbandry." + str);
	}
	
	private ResourceLocation modLoc(String path) {
		return new ResourceLocation(JustMoreCakes.MOD_ID, path);
	}
	
	@Override
	public String getName() {
		return "JustMoreCakes advancements";
	}
}
