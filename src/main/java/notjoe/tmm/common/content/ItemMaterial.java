package notjoe.tmm.common.content;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import notjoe.tmm.TooManyMetals;
import notjoe.tmm.api.ResourceType;
import notjoe.tmm.api.TMaterial;
import notjoe.tmm.common.TabResources;

import java.util.Optional;

public class ItemMaterial extends Item {
    private final ResourceType resourceType;
    private final TMaterial tMaterial;

    public ItemMaterial(TMaterial tMaterial, ResourceType resourceType) {
        this.resourceType = resourceType;
        this.tMaterial = tMaterial;

        String internalName = tMaterial.getName() + "_" + resourceType.toString();

        setUnlocalizedName("tmm." + internalName);
        setRegistryName(TooManyMetals.MODID, internalName);

        setMaxDamage(0);
        setCreativeTab(TabResources.CREATIVE_TAB);
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public TMaterial getTMaterial() {
        return tMaterial;
    }

    public void registerModels() {
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(new ResourceLocation(TooManyMetals.MODID, "resource_" + resourceType.toString()), "inventory");

        Optional<String> customModelLocation = tMaterial.getCustomModelFor(resourceType);
        if (customModelLocation.isPresent()) {
            modelResourceLocation = new ModelResourceLocation(customModelLocation.get(), "inventory");
        }

        ModelLoader.setCustomModelResourceLocation(this, 0, modelResourceLocation);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return resourceType.getFormattedDisplayName(tMaterial.getNameCapitalized());
    }
}
