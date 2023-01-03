package einstein.jmc;

import einstein.jmc.init.*;
import einstein.jmc.platform.Services;
import einstein.jmc.util.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JustMoreCakes {

    public static final String MOD_ID = "jmc";
    public static final String MOD_NAME = "Just More Cakes!";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final CreativeModeTab JMC_TAB = Services.REGISTRY.registerTab("jmc_tab", () -> new ItemStack(ModBlocks.CHOCOLATE_CAKE.get()));

    public static void init() {
        ModItems.init();
        ModBlocks.init();
        ModBlockEntityTypes.init();
        ModMenuTypes.init();
        ModRecipes.init();
        ModVillagers.init();
        ModPotions.init();
    }

    public static void commonSetup() {
        Util.registerVillageBuilding("plains", "bakery_1");
        Util.registerVillageBuilding("plains", "bakery_2");
        Util.registerVillageBuilding("desert", "bakery_1");
        Util.registerVillageBuilding("savanna", "bakery_1");
        Util.registerVillageBuilding("snowy", "bakery_1");
        Util.registerVillageBuilding("snowy", "bakery_2");
        Util.registerVillageBuilding("taiga", "bakery_1");
        Items.CAKE.maxStackSize = 64;
    }

    public static void AddSupportedCandles() {
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.CANDLE, mcLoc(""));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.WHITE_CANDLE, mcLoc("white_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.ORANGE_CANDLE, mcLoc("orange_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.MAGENTA_CANDLE, mcLoc("magenta_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.LIGHT_BLUE_CANDLE, mcLoc("light_blue_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.YELLOW_CANDLE, mcLoc("yellow_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.LIME_CANDLE, mcLoc("lime_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.PINK_CANDLE, mcLoc("pink_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.GRAY_CANDLE, mcLoc("gray_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.LIGHT_GRAY_CANDLE, mcLoc("light_gray_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.CYAN_CANDLE, mcLoc("cyan_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.PURPLE_CANDLE, mcLoc("purple_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.BLUE_CANDLE, mcLoc("blue_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.BROWN_CANDLE, mcLoc("brown_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.GREEN_CANDLE, mcLoc("green_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.RED_CANDLE, mcLoc("red_"));
        ModBlocks.SUPPORTED_CANDLES.put(Blocks.BLACK_CANDLE, mcLoc("black_"));
    }

    public static ResourceLocation loc(String string) {
        return new ResourceLocation(MOD_ID, string);
    }

    public static ResourceLocation mcLoc(String string) {
        return new ResourceLocation("minecraft", string);
    }
}