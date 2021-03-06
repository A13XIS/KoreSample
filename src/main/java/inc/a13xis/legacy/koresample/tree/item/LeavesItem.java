package inc.a13xis.legacy.koresample.tree.item;

import inc.a13xis.legacy.koresample.tree.block.LeavesBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeavesItem extends ItemBlock
{
    private final Block leaves;
    private static final String __OBFID = "CL_00000046";

    public LeavesItem(Block block)
    {
        super(block);
        if(!(block instanceof LeavesBlock)){
            throw new IllegalArgumentException("Block is not a LeavesBlock!");
        }
        this.leaves = block;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Converts the given ItemStack damage value into a metadata value to be placed in the world when this Item is
     * placed as a Block (mostly used with ItemBlocks).
     */
    public int getMetadata(int damage)
    {
        return damage | 4;
    }



    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + ((LeavesBlock)this.leaves).getWoodType(stack.getMetadata()).name();
    }
}
