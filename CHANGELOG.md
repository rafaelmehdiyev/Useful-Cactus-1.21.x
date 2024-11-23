# Rafael's Useful Cactus Mod Changelog

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
