// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelEnderman, EntityEnderman, OpenGlHelper, 
//            Block, RenderBlocks, EntityLiving, Entity

public class RenderEnderman extends RenderLiving
{

    private ModelEnderman endermanModel;
    private Random rnd;

    public RenderEnderman()
    {
        super(new ModelEnderman(), 0.5F);
        rnd = new Random();
        endermanModel = (ModelEnderman)super.mainModel;
        setRenderPassModel(endermanModel);
    }

    public void renderEnderman(EntityEnderman entityenderman, double d, double d1, double d2, 
            float f, float f1)
    {
        endermanModel.isCarrying = entityenderman.getCarried() > 0;
        endermanModel.isAttacking = entityenderman.isAttacking;
        if(entityenderman.isAttacking)
        {
            double d3 = 0.02D;
            d += rnd.nextGaussian() * d3;
            d2 += rnd.nextGaussian() * d3;
        }
        super.doRenderLiving(entityenderman, d, d1, d2, f, f1);
    }

    protected void renderCarrying(EntityEnderman entityenderman, float f)
    {
        super.renderEquippedItems(entityenderman, f);
        if(entityenderman.getCarried() > 0)
        {
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            GL11.glPushMatrix();
            float f1 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            f1 *= 1.0F;
            GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(f1, -f1, f1);
            loadTexture("/terrain.png");
            (new RenderBlocks()).renderBlockOnInventory(Block.blocksList[entityenderman.getCarried()], entityenderman.getCarryingData(), entityenderman.getEntityBrightness(f));
            GL11.glPopMatrix();
            GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        }
    }

    protected boolean renderEyes(EntityEnderman entityenderman, int i, float f)
    {
        if(i != 0)
        {
            return false;
        } else
        {
            loadTexture("/mob/enderman_eyes.png");
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return true;
        }
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return renderEyes((EntityEnderman)entityliving, i, f);
    }

    protected void renderEquippedItems(EntityLiving entityliving, float f)
    {
        renderCarrying((EntityEnderman)entityliving, f);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderEnderman((EntityEnderman)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderEnderman((EntityEnderman)entity, d, d1, d2, f, f1);
    }
}
