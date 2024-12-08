package net.rafael.usefulcactus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        // Dried Cactus -> Cactus Planks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CACTUS_PLANKS,4)
                .input(ModBlocks.DRIED_CACTUS)
                .criterion(hasItem(ModBlocks.DRIED_CACTUS), conditionsFromItem(ModBlocks.DRIED_CACTUS))
                .offerTo(recipeExporter);

        // Cactus Skin -> Green Dye (Shapeless Recipe)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, net.minecraft.item.Items.GREEN_DYE, 1)
                .input(ModItems.CACTUS_SKIN) // Input item
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        // Slab Recipe: 6 Cactus Planks -> 6 Slabs
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CACTUS_SLAB, 6)
                .pattern("###")
                .input('#', ModBlocks.CACTUS_PLANKS)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Pressure Plate Recipe: 2 Cactus Planks -> Pressure Plate
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CACTUS_PRESSURE_PLATE)
                .pattern("##")
                .input('#', ModBlocks.CACTUS_PLANKS)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Button Recipe: 1 Cactus Plank -> Button
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CACTUS_BUTTON)
                .input(ModBlocks.CACTUS_PLANKS)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Door Recipe: 6 Cactus Planks -> 3 Doors
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CACTUS_DOOR, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.CACTUS_PLANKS)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Fence Recipe: 4 Cactus Planks + 2 Sticks -> 3 Fences
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CACTUS_FENCE, 3)
                .pattern("#|#")
                .pattern("#|#")
                .input('#', ModBlocks.CACTUS_PLANKS)
                .input('|', Items.STICK)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Fence Gate Recipe: 4 Sticks + 2 Cactus Planks -> Fence Gate
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CACTUS_FENCE_GATE)
                .pattern("|#|")
                .pattern("|#|")
                .input('#', ModBlocks.CACTUS_PLANKS)
                .input('|', Items.STICK)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Trapdoor Recipe: 6 Cactus Planks -> 2 Trapdoors
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CACTUS_TRAPDOOR, 2)
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.CACTUS_PLANKS)
                .criterion(hasItem(ModBlocks.CACTUS_PLANKS), conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                .offerTo(recipeExporter);

        // Cactus Tool Recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CACTUS_SWORD)
                .pattern(" P ")
                .pattern("CPC")
                .pattern(" S ")
                .input('C', ModItems.CACTUS_SKIN)
                .input('P', ModBlocks.CACTUS_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CACTUS_PICKAXE)
                .pattern("PPP")
                .pattern("CSC")
                .pattern(" S ")
                .input('C', ModItems.CACTUS_SKIN)
                .input('P', ModBlocks.CACTUS_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CACTUS_AXE)
                .pattern("PPC")
                .pattern("PS ")
                .pattern("CS ")
                .input('C', ModItems.CACTUS_SKIN)
                .input('P', ModBlocks.CACTUS_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CACTUS_SHOVEL)
                .pattern("CPC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', ModItems.CACTUS_SKIN)
                .input('P', ModBlocks.CACTUS_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CACTUS_HOE)
                .pattern("XXC")
                .pattern("C# ")
                .pattern(" # ")
                .input('X', ModBlocks.CACTUS_PLANKS)
                .input('C', ModItems.CACTUS_SKIN)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CACTUS_HAMMER)
                .pattern("PCP")
                .pattern("PCP")
                .pattern(" S ")
                .input('C', ModItems.CACTUS_SKIN)
                .input('P', ModBlocks.CACTUS_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);
        

        // Armor Recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CACTUS_HELMET)
                .pattern("###")
                .pattern("# #")
                .input('#', ModItems.CACTUS_SKIN)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CACTUS_CHESTPLATE)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.CACTUS_SKIN)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CACTUS_LEGGINGS)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.CACTUS_SKIN)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CACTUS_BOOTS)
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.CACTUS_SKIN)
                .criterion(hasItem(ModItems.CACTUS_SKIN), conditionsFromItem(ModItems.CACTUS_SKIN))
                .offerTo(recipeExporter);

    }
}
