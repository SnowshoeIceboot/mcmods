// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            MapGenBase, MathHelper, Block, BlockGrass, 
//            World

public class MapGenRavine extends MapGenBase
{

    public MapGenRavine()
    {
        field_35627_a = new float[1024];
    }

    protected void func_35626_a(long l, int i, int j, byte abyte0[], double d, 
            double d1, double d2, float f, float f1, float f2, 
            int k, int i1, double d3)
    {
        Random random;
        double d4;
        double d5;
        float f3;
        float f4;
        boolean flag;
label0:
        {
            random = new Random(l);
            d4 = i * 16 + 8;
            d5 = j * 16 + 8;
            f3 = 0.0F;
            f4 = 0.0F;
            if(i1 <= 0)
            {
                int j1 = field_1306_a * 16 - 16;
                i1 = j1 - random.nextInt(j1 / 4);
            }
            flag = false;
            if(k == -1)
            {
                k = i1 / 2;
                flag = true;
            }
            float f5 = 1.0F;
            int k1 = 0;
            do
            {
                if(k1 >= 128)
                {
                    break label0;
                }
                if(k1 == 0 || random.nextInt(3) == 0)
                {
                    f5 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
                }
                field_35627_a[k1] = f5 * f5;
                k1++;
            } while(true);
        }
        for(; k < i1; k++)
        {
            double d6 = 1.5D + (double)(MathHelper.sin(((float)k * 3.141593F) / (float)i1) * f * 1.0F);
            double d7 = d6 * d3;
            d6 *= (double)random.nextFloat() * 0.25D + 0.75D;
            d7 *= (double)random.nextFloat() * 0.25D + 0.75D;
            float f6 = MathHelper.cos(f2);
            float f7 = MathHelper.sin(f2);
            d += MathHelper.cos(f1) * f6;
            d1 += f7;
            d2 += MathHelper.sin(f1) * f6;
            f2 *= 0.7F;
            f2 += f4 * 0.05F;
            f1 += f3 * 0.05F;
            f4 *= 0.8F;
            f3 *= 0.5F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4F;
            if(!flag && random.nextInt(4) == 0)
            {
                continue;
            }
            double d8 = d - d4;
            double d9 = d2 - d5;
            double d10 = i1 - k;
            double d11 = f + 2.0F + 16F;
            if((d8 * d8 + d9 * d9) - d10 * d10 > d11 * d11)
            {
                return;
            }
            if(d < d4 - 16D - d6 * 2D || d2 < d5 - 16D - d6 * 2D || d > d4 + 16D + d6 * 2D || d2 > d5 + 16D + d6 * 2D)
            {
                continue;
            }
            d8 = MathHelper.floor_double(d - d6) - i * 16 - 1;
            int l1 = (MathHelper.floor_double(d + d6) - i * 16) + 1;
            d9 = MathHelper.floor_double(d1 - d7) - 1;
            int i2 = MathHelper.floor_double(d1 + d7) + 1;
            d10 = MathHelper.floor_double(d2 - d6) - j * 16 - 1;
            int j2 = (MathHelper.floor_double(d2 + d6) - j * 16) + 1;
            if(d8 < 0)
            {
                d8 = 0;
            }
            if(l1 > 16)
            {
                l1 = 16;
            }
            if(d9 < 1)
            {
                d9 = 1;
            }
            if(i2 > 120)
            {
                i2 = 120;
            }
            if(d10 < 0)
            {
                d10 = 0;
            }
            if(j2 > 16)
            {
                j2 = 16;
            }
            boolean flag1 = false;
            for(int k2 = (int) d8; !flag1 && k2 < l1; k2++)
            {
                for(int i3 = (int) d10; !flag1 && i3 < j2; i3++)
                {
                    for(int j3 = i2 + 1; !flag1 && j3 >= d9 - 1; j3--)
                    {
                        int k3 = (k2 * 16 + i3) * 128 + j3;
                        if(j3 < 0 || j3 >= 128)
                        {
                            continue;
                        }
                        if(abyte0[k3] == Block.waterMoving.blockID || abyte0[k3] == Block.waterStill.blockID)
                        {
                            flag1 = true;
                        }
                        if(j3 != d9 - 1 && k2 != d8 && k2 != l1 - 1 && i3 != d10 && i3 != j2 - 1)
                        {
                            j3 = (int) d9;
                        }
                    }

                }

            }

            if(flag1)
            {
                continue;
            }
            for(int l2 = (int) d8; l2 < l1; l2++)
            {
                double d12 = (((double)(l2 + i * 16) + 0.5D) - d) / d6;
label1:
                for(int l3 = (int) d10; l3 < j2; l3++)
                {
                    double d13 = (((double)(l3 + j * 16) + 0.5D) - d2) / d6;
                    int i4 = (l2 * 16 + l3) * 128 + i2;
                    boolean flag2 = false;
                    if(d12 * d12 + d13 * d13 >= 1.0D)
                    {
                        continue;
                    }
                    int j4 = i2 - 1;
                    do
                    {
                        if(j4 < d9)
                        {
                            continue label1;
                        }
                        double d14 = (((double)j4 + 0.5D) - d1) / d7;
                        if((d12 * d12 + d13 * d13) * (double)field_35627_a[j4] + (d14 * d14) / 6D < 1.0D)
                        {
                            byte byte0 = abyte0[i4];
                            if(byte0 == Block.grass.blockID)
                            {
                                flag2 = true;
                            }
                            if(byte0 == Block.stone.blockID || byte0 == Block.dirt.blockID || byte0 == Block.grass.blockID)
                            {
                                if(j4 < 10)
                                {
                                    abyte0[i4] = (byte)Block.lavaMoving.blockID;
                                } else
                                {
                                    abyte0[i4] = 0;
                                    if(flag2 && abyte0[i4 - 1] == Block.dirt.blockID)
                                    {
                                        abyte0[i4 - 1] = (byte)Block.grass.blockID;
                                    }
                                }
                            }
                        }
                        i4--;
                        j4--;
                    } while(true);
                }

            }

            if(flag)
            {
                break;
            }
        }

    }

    protected void func_868_a(World world, int i, int j, int k, int l, byte abyte0[])
    {
        if(rand.nextInt(50) != 0)
        {
            return;
        }
        double d = i * 16 + rand.nextInt(16);
        double d1 = rand.nextInt(rand.nextInt(40) + 8) + 20;
        double d2 = j * 16 + rand.nextInt(16);
        int i1 = 1;
        for(int j1 = 0; j1 < i1; j1++)
        {
            float f = rand.nextFloat() * 3.141593F * 2.0F;
            float f1 = ((rand.nextFloat() - 0.5F) * 2.0F) / 8F;
            float f2 = (rand.nextFloat() * 2.0F + rand.nextFloat()) * 2.0F;
            func_35626_a(rand.nextLong(), k, l, abyte0, d, d1, d2, f2, f, f1, 0, 0, 3D);
        }

    }

    private float field_35627_a[];
}
