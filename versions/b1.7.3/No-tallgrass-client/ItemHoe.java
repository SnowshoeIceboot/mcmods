// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, World, Block, 
//            BlockGrass, ItemStack, EntityPlayer, EntityItem, 
//            StepSound

public class ItemHoe extends Item
{

    public ItemHoe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockId(i, j, k);
        int j1 = world.getBlockId(i, j + 1, k);
        if(world.rand.nextInt(8) == 0 && i1 == Block.grass.blockID)
        {
            int k1 = 1;
            for(int l1 = 0; l1 < k1; l1++)
            {
                float f = 0.7F;
                float f1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                float f2 = 1.2F;
                float f3 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                EntityItem entityitem = new EntityItem(world, (float)i + f1, (float)j + f2, (float)k + f3, new ItemStack(Item.seeds));
                entityitem.delayBeforeCanPickup = 10;
                world.entityJoinedWorld(entityitem);
            }

        }
        if(l != 0 && j1 == 0 && i1 == Block.grass.blockID || i1 == Block.dirt.blockID)
        {
            Block block = Block.tilledField;
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.func_1145_d(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            if(world.multiplayerWorld)
            {
                return true;
            } else
            {
                world.setBlockWithNotify(i, j, k, block.blockID);
                itemstack.damageItem(1, entityplayer);
                return true;
            }
        } else
        {
            return false;
        }
    }

    public boolean isFull3D()
    {
        return true;
    }
}
