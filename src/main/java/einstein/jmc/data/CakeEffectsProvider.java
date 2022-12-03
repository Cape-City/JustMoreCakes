package einstein.jmc.data;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import cpw.mods.modlauncher.api.LamdbaExceptionUtils;
import einstein.jmc.blocks.BaseCakeBlock;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CakeEffectsProvider implements DataProvider {

    private final DataGenerator.PathProvider pathProvider;
    private final String modid;
    private final Map<String, JsonElement> map = new HashMap<>();

    public CakeEffectsProvider(DataGenerator generator, String modid) {
        pathProvider = generator.createPathProvider(DataGenerator.Target.DATA_PACK, "cake_effects");
        this.modid = modid;
    }

    protected abstract void addCakeEffects();

    @Override
    public void run(CachedOutput cache) {
        addCakeEffects();

        map.forEach(LamdbaExceptionUtils.rethrowBiConsumer((name, element) -> {
            DataProvider.saveStable(cache, element, pathProvider.json(new ResourceLocation(modid, name)));
        }));
    }

    public void add(RegistryObject<BaseCakeBlock> cake, CakeEffects.MobEffectHolder... mobEffects) {
        List<CakeEffects.MobEffectHolder> holders = List.of(mobEffects);

        JsonElement element = CakeEffects.CODEC.encodeStart(JsonOps.INSTANCE, new CakeEffects(holders)).getOrThrow(false, s -> {});
        map.put(cake.getId().getPath(), element);
    }

    @Override
    public String getName() {
        return "Cake Effects";
    }
}
