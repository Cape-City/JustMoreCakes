package einstein.jmc.init;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfigs {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue FIREY_CAKE_ON_FIRE_DUR = BUILDER.comment("How long the cake eater is set on fire for in ticks")
            .defineInRange("fireyCakeOnFireDuration", 20, 0, 32000);
    public static final ForgeConfigSpec.IntValue GLOWSTONE_CAKE_GLOWING_DUR = BUILDER.comment("How long mobs affected by the glowstone cake glow for in ticks")
            .defineInRange("glowstoneCakeGlowingDuration", 85, 0, 32000);
    public static final ForgeConfigSpec.DoubleValue CHORUS_CAKE_TELEPORT_RADIUS = BUILDER.comment("The radius around the player in which the they will be randomly teleported")
            .defineInRange("chorusCakeTeleportRadius", 10, 0, 10000D);
    public static final ForgeConfigSpec.DoubleValue ENDER_CAKE_TELEPORT_RADIUS = BUILDER.comment("The radius around the player in which the they will be randomly teleported")
            .defineInRange("enderCakeTeleportRadius", 50, 0, 10000D);
    public static final ForgeConfigSpec.BooleanValue EFFECTED_BY_REDSTONE = BUILDER.comment("Whether the TNT cake will explode when powered by Redstone")
            .define("effectedByRedstone", false);
    public static final ForgeConfigSpec.IntValue TNT_CAKE_EXPLOSION_SIZE = BUILDER.comment("How big the explosion for TNT cake is")
            .defineInRange("tntCakeExplosionSize", 5, 1, 50);
    public static final ForgeConfigSpec.IntValue ENCASING_ICE_MELT_SPEED = BUILDER.comment("How long it takes for encasing ice to melt. Larger numbers is slower")
            .defineInRange("encasingIceMeltSpeed", 1, 0, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue CAKE_BAKERY_GENERATION_WEIGHT = BUILDER.comment("How often do cake bakeries generate in villages. 0 to disable")
            .defineInRange("cakeBakeryGenerationWeight", 1, 0, 150);
    public static final ForgeConfigSpec.IntValue GLOWSTONE_CAKE_EFFECT_RADIUS = BUILDER.comment("The radius in blocks at which the glowstone cake will effect mobs")
            .defineInRange("glowstoneCakeEffectRadius", 20, 0, 100);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
