package ninja.shadowfox.shadowfox_botany.common.crafting

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.CraftingManager
import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.oredict.ShapedOreRecipe
import net.minecraftforge.oredict.ShapelessOreRecipe
import ninja.shadowfox.shadowfox_botany.common.blocks.ShadowFoxBlocks
import ninja.shadowfox.shadowfox_botany.common.item.ShadowFoxItems
import vazkii.botania.api.BotaniaAPI
import vazkii.botania.common.lib.LibOreDict
import vazkii.botania.common.block.ModBlocks as BotaniaBlocks
import vazkii.botania.common.item.ModItems as BotaniaItems

public object ModRecipes {
    var recipesColoredDirt: List<IRecipe>
    var recipesWoodPanel: List<IRecipe>
    var recipesSlabs: List<IRecipe>
    var recipesStairsL: List<IRecipe>
    var recipesStairsR: List<IRecipe>
    var recipesSlabsFull: List<IRecipe>
    var recipesColoredSkyDirtRod: List<IRecipe>
    var recipesLightningRod: IRecipe
    var recipesLeafDyes: List<IRecipe>

    init {

        for (i in 0..15)
            GameRegistry.addShapedRecipe(ItemStack(ShadowFoxBlocks.coloredDirtBlock, 8, i),
                    "DDD",
                    "DPD",
                    "DDD", 'P', ItemStack(BotaniaBlocks.petalBlock, 1, i), 'D', ItemStack(Blocks.dirt, 1))

        recipesColoredDirt = BotaniaAPI.getLatestAddedRecipes(16)

        for (i in 0..15) {
            addShapelessOreDictRecipe(ItemStack(vazkii.botania.common.item.ModItems.dye, 1, i), ShadowFoxBlocks.LEAVES[i], "pestleAndMortar")
        }

        recipesLeafDyes = BotaniaAPI.getLatestAddedRecipes(16)
        for (i in 0..15) {
            addShapelessOreDictRecipe(ItemStack(ShadowFoxBlocks.coloredPlanks, 4, i), ShadowFoxBlocks.WOOD[i])
        }

        recipesWoodPanel = BotaniaAPI.getLatestAddedRecipes(16)
        
        for (i in 0..15)
            GameRegistry.addRecipe(ItemStack(ShadowFoxBlocks.coloredSlabs, 6, i),
                "QQQ",
                'Q', ItemStack(ShadowFoxBlocks.coloredPlanks, 1, i))

        recipesSlabs = BotaniaAPI.getLatestAddedRecipes(16)

        for (i in 0..15)
        {
            var wood: Block
            when (i) {
                0,1,2,3 -> wood = ShadowFoxBlocks.coloredStairs0
                4,5,6,7 -> wood = ShadowFoxBlocks.coloredStairs1
                8,9,10,11 -> wood = ShadowFoxBlocks.coloredStairs2
                else -> {wood = ShadowFoxBlocks.coloredStairs3}
            }
            GameRegistry.addRecipe(ItemStack(wood, 4, (i % 4) * 4),
                    "  Q", " QQ", "QQQ",
                    'Q', ItemStack(ShadowFoxBlocks.coloredPlanks, 1, i))
        }
        recipesStairsR = BotaniaAPI.getLatestAddedRecipes(16)

        for (i in 0..15)
        {
            var wood: Block
            when (i) {
                0,1,2,3 -> wood = ShadowFoxBlocks.coloredStairs0
                4,5,6,7 -> wood = ShadowFoxBlocks.coloredStairs1
                8,9,10,11 -> wood = ShadowFoxBlocks.coloredStairs2
                else -> {wood = ShadowFoxBlocks.coloredStairs3}
            }
            GameRegistry.addRecipe(ItemStack(wood, 4, (i % 4) * 4),
                    "Q  ", "QQ ", "QQQ",
                    'Q', ItemStack(ShadowFoxBlocks.coloredPlanks, 1, i))
        }
        
        recipesStairsL = BotaniaAPI.getLatestAddedRecipes(16)

        for (i in 0..15)
            GameRegistry.addShapelessRecipe(ItemStack(ShadowFoxBlocks.coloredPlanks, 1, i),
                ItemStack(ShadowFoxBlocks.coloredSlabs, 1, i), ItemStack(ShadowFoxBlocks.coloredSlabs, 1, i))

        recipesSlabsFull = BotaniaAPI.getLatestAddedRecipes(16)
        
        for (i in 0..15)
            addOreDictRecipe(ItemStack(ShadowFoxItems.colorfulSkyDirtRod, 1, i),
                    " PN",
                    " RP",
                    "A  ",
                    'P', ItemStack(ShadowFoxBlocks.coloredDirtBlock, 1, i),
                    'R', ItemStack(BotaniaItems.skyDirtRod, 1),
                    'A', LibOreDict.RUNE[3], 'N', LibOreDict.RUNE[14])
        
        recipesColoredSkyDirtRod = BotaniaAPI.getLatestAddedRecipes(16)

        addOreDictRecipe(ItemStack(ShadowFoxItems.lightningRod, 1),
                " DW",
                " SD",
                "E  ",
                'E', LibOreDict.ENDER_AIR_BOTTLE,
                'D', LibOreDict.DRAGONSTONE,
                'S', LibOreDict.DREAMWOOD_TWIG,
                'W', LibOreDict.RUNE[13])

        recipesLightningRod = BotaniaAPI.getLatestAddedRecipe()

        
        for (i in 0..15)
            addShapelessOreDictRecipe(ItemStack(ShadowFoxBlocks.coloredPlanks, 4, i), ShadowFoxBlocks.WOOD[i])

        recipesWoodPanel = BotaniaAPI.getLatestAddedRecipes(16)

        BotaniaAPI.registerPureDaisyRecipe(Blocks.sapling, ShadowFoxBlocks.irisSapling, 0)
    
    }

    private fun addOreDictRecipe(output: ItemStack, vararg recipe: Any) {
        CraftingManager.getInstance().recipeList.add(ShapedOreRecipe(output, *recipe))
    }

    private fun  addShapelessOreDictRecipe(output: ItemStack, vararg recipe: Any) {
        CraftingManager.getInstance().recipeList.add(ShapelessOreRecipe(output, *recipe));
    }
}