# Rafael's Useful Cactus Mod Changelog & Development Guidelines

## Development Rules 📋

### Client-Server Code Separation
- ❌ Never use `net.minecraft.client.world.ClientWorld` in common code
- ❌ Avoid `MinecraftClient` in items/blocks
- ✅ Use `@Environment(EnvType.CLIENT)` for client-specific code
- ✅ Place client-side logic in `*Client.java` classes

### Biome Handling
- ✅ Use `BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE` for desert checks
- ✅ Always null-check world and player before biome operations
- ❌ Never access biome data during data generation

### Time Constants
- Day cycle: 24000 ticks
- Daytime: 0-13000 ticks
- Noon peak: 6000-6500 ticks
- ✅ Always use modulo: `world.getTimeOfDay() % 24000`

### Registration Guidelines
- ✅ Register items before blocks
- ✅ Use `Item.Settings()` instead of vanilla `FabricItemSettings()`
- ✅ Register effects last to avoid dependency issues

### Mixin Best Practices
- ✅ Target specific classes (e.g., CactusBlock, not AbstractBlock)
- ✅ Use @Inject with proper cancellation handling
- ❌ Avoid client-side mixins in common code

## Latest Changes (Desert-Mechanics Branch)

### Added Features 🎉
- Desert thorn effect texture
- Desert-specific mechanics:
  - Mining speed boost (25% in desert)
  - Durability preservation (20% chance)
  - Time-based bonuses
  - Biome-specific tooltips

### Fixed Issues 🔧
- Mixin targeting in CactusBlockMixin
- Effect registration system
- Data generation compatibility
- Client-side code separation

### Known Issues 🐛
- Desert thorn effect needs cooldown system
- Tooltip refresh rate optimization needed

## Latest Features (Armor Update) 🎮

### Added Cactus Armor Set
- Implemented full cactus armor set (helmet, chestplate, leggings, boots)
- Added custom armor material properties
- Integrated with existing desert bonus mechanics
- Added armor textures and models

### Technical Implementation
- Created new armor item classes
- Set up proper armor material registration
- Integrated with existing mod systems
- Added appropriate crafting recipes

## Feature Implementation Details

### Desert Mechanics
```java
// Example of proper desert bonus implementation
if (world != null && !world.isClient()) {
    if (world.getBiome(pos).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
        // Desert-specific logic here
    }
}
```

### Time-Based Features
```java
long time = world.getTimeOfDay() % 24000;
if (time >= 6000 && time <= 6500) {
    // Noon bonus logic
}
```

## Testing Guidelines
- ✅ Test data generation before commits
- ✅ Verify both client and server environments
- ✅ Check desert mechanics in multiple biomes
- ✅ Validate time-based features across day cycle

## Important Keypoints 🌵
- **Correct Method Names**:
  - Use `getMiningSpeed` not `getMiningSpeedMultiplier`
  - Use `postMine` for durability modifications
  - Use `getEnchantability` for enchantment bonuses

- **Biome Tags**:
  - Use `BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE` not `BiomeTags.IS_DESERT`
  - Always check world and player for null before biome checks

- **Time Constants**:
  - Day cycle: 24000 ticks total
  - Daytime: 0-13000 ticks
  - Noon: 6000-6500 ticks

## Features Implementation

### CactusPickaxeItem Features
- ⛏️ Mining speed boost in desert (25% faster)
- 🛡️ Durability preservation in desert (20% chance)
- ✨ Fortune bonus in desert biomes
- ☀️ Time-based bonuses:
  - Daytime: Additional speed boost
  - Noon: Extra fortune chance

### Code Structure
```java
// Important method signatures
public float getMiningSpeed(ItemStack stack, BlockState state)
public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
public int getEnchantability()
```

### Technical Implementation
- **World Access**:
  ```java
  World world = MinecraftClient.getInstance().world;
  PlayerEntity player = MinecraftClient.getInstance().player;
  ```
- **Biome Checks**:
  ```java
  world.getBiome(player.getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)
  ```
- **Time Checks**:
  ```java
  long timeOfDay = world.getTimeOfDay() % 24000;
  if (timeOfDay >= 0 && timeOfDay < 13000) { // Daytime
      if (timeOfDay >= 6000 && timeOfDay <= 6500) { // Noon
          // Noon-specific code
      }
  }
  ```

## Development Notes

### Current Implementation
- ✅ Basic desert speed boost
- ✅ Durability preservation system
- ✅ Fortune bonus implementation
- ✅ Time-based mechanics

### Known Issues
- ⚠️ Resource management with MinecraftClient singleton
- ⚠️ Need for comprehensive testing
- ⚠️ Performance optimization needed for frequent biome checks

### Development Environment
- 🎮 Minecraft Version: 1.21
- 🧰 Fabric API
- ☕ Java 21

### File Structure
```
src/main/java/net/rafael/usefulcactus/
├── item/custom/
│   └── CactusPickaxeItem.java
└── mixin/
    └── CactusPickaxeMixin.java
```

## Future Considerations
- 🎯 Performance optimization for biome checks
- 🎯 Additional desert-themed mechanics
- 🎯 Comprehensive testing suite
- 🎯 Better resource management

## Common Mistakes to Avoid
1. ❌ Using wrong method names (getMiningSpeedMultiplier)
2. ❌ Using incorrect BiomeTags (IS_DESERT)
3. ❌ Forgetting null checks for world and player
4. ❌ Not handling resource cleanup

## Recent Fixes (Mixin Refactoring) 🛠️

### Identified Issues & Solutions
1. **CactusPickaxeMixin Implementation**:
   - ❌ Issue: Initially targeted `PickaxeItem` class directly
   - ✅ Solution: Target `Item` class instead, as mining speed is handled at Item level
   - Why: Allows proper injection into base functionality

2. **Injection Points**:
   - ❌ Issue: Used `@At("RETURN")` for method injections
   - ✅ Solution: Changed to `@At("HEAD")` for both getMiningSpeed and getEnchantability
   - Why: Ensures our custom logic runs before vanilla calculations

3. **MinecraftClient Usage**:
   - ❌ Issue: Direct MinecraftClient usage in item classes
   - ✅ Solution: Moved client-side logic to proper Client classes and mixins
   - Why: Maintains proper client-server code separation

### Best Practices Reinforced
- Always target the most base class possible in mixins
- Use HEAD injection point when overriding vanilla behavior
- Keep client-side logic in dedicated client packages
- Properly handle server-side block ticking

## Armor Implementation Updates 🛡️

### Important Changes
- Changed from enum-based `ModArmorMaterial` to registry-based `ModArmorMaterials`
- Using `RegistryEntry<ArmorMaterial>` instead of direct `ArmorMaterial` implementation
- Implemented new armor material registration system using Registry.registerReference

### Key Implementation Points
- **Correct Registration Method**:
  ```java
  Registry.registerReference(Registries.ARMOR_MATERIAL, 
    Identifier.of(MOD_ID, name), material.get())
  ```
- **Armor Values**:
  - Boots: 2 protection
  - Helmet: 4 protection
  - Chestplate: 6 protection
  - Leggings: 2 protection
  - Body: 4 protection
  - Durability: 20
  - Sound: ITEM_ARMOR_EQUIP_DIAMOND

### Common Mistakes to Avoid ❌
1. Using outdated enum-based armor material implementation
2. Not using RegistryEntry for armor materials
3. Using incorrect protection value mapping
4. Forgetting to include armor layer textures in registration

### Correct Usage
```java
// Register armor material
RegistryEntry<ArmorMaterial> MATERIAL = registerArmorMaterial("name",
    () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            // Protection values
        }),
        durability,
        soundEvent,
        repairIngredient,
        layers,
        toughness,
        knockbackResistance
    ));
```

### Required Imports
```java
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Util;
import java.util.EnumMap;
```

## Armor Implementation Fixes and Updates 🛡️

### Fixed Issues
1. **Equipment Slot to Type Migration**:
   - ❌ Old: Using deprecated `EquipmentSlot` (HEAD, CHEST, LEGS, FEET)
   - ✅ New: Using `ArmorItem.Type` (HELMET, CHESTPLATE, LEGGINGS, BOOTS)
   ```java
   new ModArmorItem(material, ArmorItem.Type.HELMET, settings)
   ```

2. **Armor Effects System**:
   - ❌ Old: Direct status effect application
   - ✅ New: Using ImmutableMap for effect mapping
   ```java
   private static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP
   ```

3. **Status Effect Application**:
   - Added proper full armor set detection
   - Implemented effect evaluation system
   - Effects only apply when wearing complete set

### Current Implementation
- **Full Set Bonuses**:
  - Strength II (400 ticks)
  - Fire Resistance (400 ticks)
  - Effects are non-visible (no particles)
  - Effects don't show icon

### Code Structure
```java
// Correct armor registration
public static final Item CACTUS_HELMET = registerItem("cactus_armor_helmet",
    new ModArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, 
        ArmorItem.Type.HELMET,
        new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
```

### Required Imports
```java
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import com.google.common.collect.ImmutableMap;
```

## Armor Effect Updates 🌵

### Changed Effects
- ❌ Removed non-thematic effects:
  - Removed Haste III effect
  - Removed Jump Boost II effect

- ✅ Added desert-themed effects:
  - Strength II (400 ticks) - represents cactus offensive capabilities
  - Fire Resistance (400 ticks) - represents desert survival adaptation

### Effect Implementation
```java
MATERIAL_TO_EFFECT_MAP = new ImmutableMap.Builder<>()
    .put(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL,
        List.of(
            // Offensive bonus
            new StatusEffectInstance(StatusEffects.STRENGTH, 400, 1, false, false),
            // Survival bonus
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false)
        ))
    .build();
```

### Design Rationale
- **Strength Effect**: Represents the offensive nature of cactus spikes
- **Fire Resistance**: Reflects cactus's natural desert survival adaptations
- Both effects are hidden (no particles) to maintain clean visual experience
- Effects only apply with full armor set

### Effect Properties
- Duration: 400 ticks (20 seconds)
- Strength Level: II (significant combat boost)
- Fire Resistance Level: I (complete fire immunity)
- Visual: No particles or ambient effects
- Application: Silent effect application

### Testing Points
- Full set bonus activation
- Individual piece durability
- Effect application timing
- Performance impact of effect checks

### Armor Effect System Details
1. **Effect Application Logic**:
   ```java
   private void addStatusEffectForMaterial(PlayerEntity player, 
       RegistryEntry<ArmorMaterial> material, 
       List<StatusEffectInstance> effects) {
       // Only apply if player doesn't have effects
       if (!hasPlayerEffect) {
           effects.forEach(effect -> player.addStatusEffect(new StatusEffectInstance(...)));
       }
   }
   ```

2. **Armor Set Validation**:
   - Checks for complete set (all slots filled)
   - Verifies correct material type
   - Inventory slot mapping:
     ```java
     boots = player.getInventory().getArmorStack(0)
     leggings = player.getInventory().getArmorStack(1)
     breastplate = player.getInventory().getArmorStack(2)
     helmet = player.getInventory().getArmorStack(3)
     ```

3. **Performance Considerations**:
   - Effect checks run every inventory tick
   - Uses stream for effect validation
   - Caches material-to-effect mapping in static final field

### Common Mistakes to Avoid
1. ❌ Using `==` for material comparison (use `.equals()` or direct `==` for registry entries)
2. ❌ Not checking for empty armor slots
3. ❌ Applying effects individually without checking existing effects
4. ❌ Missing null checks for armor items

### Best Practices
- ✅ Use ImmutableMap for static effect mappings
- ✅ Check for existing effects before applying new ones
- ✅ Validate complete armor set before applying effects
- ✅ Use proper armor slot indices (0-3)

## Data Generation Updates 🔧

### Model Generation
- Implemented proper armor model registration in `ModModelProvider`:
  - Using `itemModelGenerator.registerArmor()` for automatic layer handling
  - Added type casting for armor items
  - Ensures generation of both item models and armor layer models

### Recipe Generation
- Added standard Minecraft armor crafting recipes:
  - Helmet (5 Cactus Skin):
    ```
    ###
    # #
    ```
  - Chestplate (8 Cactus Skin):
    ```
    # #
    ###
    ###
    ```
  - Leggings (7 Cactus Skin):
    ```
    ###
    # #
    # #
    ```
  - Boots (4 Cactus Skin):
    ```
    # #
    # #
    ```
- All recipes:
  - Use `RecipeCategory.COMBAT`
  - Have proper crafting criteria
  - Use Cactus Skin as main ingredient

### Tag Generation
- Added armor pieces to vanilla tags:
  - All pieces registered in `ItemTags.TRIMMABLE_ARMOR`
  - Enables smithing table functionality
  - Supports armor trimming patterns

### Required Assets
For the armor to display correctly, create:
1. Armor Layer Textures (64x32):
   - `assets/usefulcactus/textures/models/armor/cactus_layer_1.png`
   - `assets/usefulcactus/textures/models/armor/cactus_layer_2.png`
2. Item Textures (16x16):
   - `assets/usefulcactus/textures/item/cactus_helmet.png`
   - `assets/usefulcactus/textures/item/cactus_chestplate.png`
   - `assets/usefulcactus/textures/item/cactus_leggings.png`
   - `assets/usefulcactus/textures/item/cactus_boots.png`

## Gradle Command Guidelines
### Common Mistakes and Corrections
- ❌ Using `gradlew` directly on Windows
- ❌ Using `./gradlew` on Windows
- ❌ Running `gradlew.bat` without proper path

### Correct Usage on Windows
```batch
# Correct way to build the project
cmd /c gradlew.bat build

# Other useful commands
cmd /c gradlew.bat runClient    # Run the client with mod
cmd /c gradlew.bat genSources   # Generate sources
```

### Important Notes
- Always use `cmd /c gradlew.bat` on Windows systems
- Run commands from the project root directory
- Ensure Gradle wrapper files exist:
  - gradlew.bat
  - gradle/wrapper/gradle-wrapper.jar
  - gradle/wrapper/gradle-wrapper.properties

## Useful Commands
```bash
# Gradle commands
./gradlew build
./gradlew runClient
./gradlew genSources
```

---
Last Updated: [Current Date]
Remember to update this file when making significant changes!
