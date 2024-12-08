package net.rafael.usefulcactus.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.item.ModItems;

public class ModRecipeProvider extends FabricRecipeProvider {
        public ModRecipeProvider(FabricDataOutput output,
                        CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
                super(output, registriesFuture);
        }

        @Override
        public String getName() {
                return "Rafaels Useful Cactus Recipes";
        }

        @Override
        protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
                return new RecipeGenerator(registryLookup, exporter) {
                        @Override
                        public void generate() {
                                // Dried Cactus -> Cactus Planks
                                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CACTUS_PLANKS, 4)
                                                .input(ModBlocks.DRIED_CACTUS)
                                                .criterion(hasItem(ModBlocks.DRIED_CACTUS),
                                                                conditionsFromItem(ModBlocks.DRIED_CACTUS))
                                                .offerTo(exporter);

                                // Cactus Skin -> Green Dye (Shapeless Recipe)
                                createShapeless(RecipeCategory.BUILDING_BLOCKS, net.minecraft.item.Items.GREEN_DYE, 1)
                                                .input(ModItems.CACTUS_SKIN) // Input item
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                // Slab Recipe: 6 Cactus Planks -> 6 Slabs
                                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CACTUS_SLAB, 6)
                                                .pattern("###")
                                                .input('#', ModBlocks.CACTUS_PLANKS)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Pressure Plate Recipe: 2 Cactus Planks -> Pressure Plate
                                createShaped(RecipeCategory.REDSTONE, ModBlocks.CACTUS_PRESSURE_PLATE)
                                                .pattern("##")
                                                .input('#', ModBlocks.CACTUS_PLANKS)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Button Recipe: 1 Cactus Plank -> Button
                                createShapeless(RecipeCategory.REDSTONE, ModBlocks.CACTUS_BUTTON)
                                                .input(ModBlocks.CACTUS_PLANKS)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Door Recipe: 6 Cactus Planks -> 3 Doors
                                createShaped(RecipeCategory.REDSTONE, ModBlocks.CACTUS_DOOR, 3)
                                                .pattern("##")
                                                .pattern("##")
                                                .pattern("##")
                                                .input('#', ModBlocks.CACTUS_PLANKS)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Fence Recipe: 4 Cactus Planks + 2 Sticks -> 3 Fences
                                createShaped(RecipeCategory.DECORATIONS, ModBlocks.CACTUS_FENCE, 3)
                                                .pattern("#|#")
                                                .pattern("#|#")
                                                .input('#', ModBlocks.CACTUS_PLANKS)
                                                .input('|', Items.STICK)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Fence Gate Recipe: 4 Sticks + 2 Cactus Planks -> Fence Gate
                                createShaped(RecipeCategory.REDSTONE, ModBlocks.CACTUS_FENCE_GATE)
                                                .pattern("|#|")
                                                .pattern("|#|")
                                                .input('#', ModBlocks.CACTUS_PLANKS)
                                                .input('|', Items.STICK)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Trapdoor Recipe: 6 Cactus Planks -> 2 Trapdoors
                                createShaped(RecipeCategory.REDSTONE, ModBlocks.CACTUS_TRAPDOOR, 2)
                                                .pattern("###")
                                                .pattern("###")
                                                .input('#', ModBlocks.CACTUS_PLANKS)
                                                .criterion(hasItem(ModBlocks.CACTUS_PLANKS),
                                                                conditionsFromItem(ModBlocks.CACTUS_PLANKS))
                                                .offerTo(exporter);

                                // Cactus Tool Recipes
                                createShaped(RecipeCategory.COMBAT, ModItems.CACTUS_SWORD)
                                                .pattern(" C ")
                                                .pattern(" C ")
                                                .pattern(" S ")
                                                .input('C', ModItems.CACTUS_SKIN)
                                                .input('S', Items.STICK)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.TOOLS, ModItems.CACTUS_PICKAXE)
                                                .pattern("CCC")
                                                .pattern(" S ")
                                                .pattern(" S ")
                                                .input('C', ModItems.CACTUS_SKIN)
                                                .input('S', Items.STICK)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.TOOLS, ModItems.CACTUS_AXE)
                                                .pattern("CC ")
                                                .pattern("CS ")
                                                .pattern(" S ")
                                                .input('C', ModItems.CACTUS_SKIN)
                                                .input('S', Items.STICK)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.TOOLS, ModItems.CACTUS_SHOVEL)
                                                .pattern(" C ")
                                                .pattern(" S ")
                                                .pattern(" S ")
                                                .input('C', ModItems.CACTUS_SKIN)
                                                .input('S', Items.STICK)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.TOOLS, ModItems.CACTUS_HOE)
                                                .pattern("XX ")
                                                .pattern(" # ")
                                                .pattern(" # ")
                                                .input('X', ModItems.CACTUS_SKIN)
                                                .input('#', Items.STICK)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.TOOLS, ModItems.CACTUS_HAMMER)
                                                .pattern("CCC")
                                                .pattern("CCC")
                                                .pattern(" S ")
                                                .input('C', ModItems.CACTUS_SKIN)
                                                .input('S', Items.STICK)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                // Armor Recipes
                                createShaped(RecipeCategory.COMBAT, ModItems.CACTUS_HELMET)
                                                .pattern("###")
                                                .pattern("# #")
                                                .input('#', ModItems.CACTUS_SKIN)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.COMBAT, ModItems.CACTUS_CHESTPLATE)
                                                .pattern("# #")
                                                .pattern("###")
                                                .pattern("###")
                                                .input('#', ModItems.CACTUS_SKIN)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.COMBAT, ModItems.CACTUS_LEGGINGS)
                                                .pattern("###")
                                                .pattern("# #")
                                                .pattern("# #")
                                                .input('#', ModItems.CACTUS_SKIN)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                                createShaped(RecipeCategory.COMBAT, ModItems.CACTUS_BOOTS)
                                                .pattern("# #")
                                                .pattern("# #")
                                                .input('#', ModItems.CACTUS_SKIN)
                                                .criterion(hasItem(ModItems.CACTUS_SKIN),
                                                                conditionsFromItem(ModItems.CACTUS_SKIN))
                                                .offerTo(exporter);

                        }

                };
        }


}
