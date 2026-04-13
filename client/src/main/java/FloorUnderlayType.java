import deob.ObfuscatedName;

@ObfuscatedName("uc")
public class FloorUnderlayType {

    @ObfuscatedName("uc.u")
    public int rgb = 0;

    @ObfuscatedName("uc.j")
    public int textureId = -1;

    @ObfuscatedName("uc.a")
    public int hueMultiplier = 512;

    @ObfuscatedName("uc.s")
    public boolean field6719 = true;

    @ObfuscatedName("uc.c")
    public boolean blendable = true;

    @ObfuscatedName("uc.m")
    public int hue;

    @ObfuscatedName("uc.t")
    public int saturation;

    @ObfuscatedName("uc.l")
    public int lightness;

    @ObfuscatedName("uc.f")
    public int chromaWeight;

    @ObfuscatedName("uc.u(Laet;B)V")
    public void decode(Packet arg0) {
        while (true) {
            int var2 = arg0.g1();
            if (var2 == 0) {
                return;
            }
            this.decodeOpcode(arg0, var2);
        }
    }

    @ObfuscatedName("uc.j(Laet;II)V")
    public void decodeOpcode(Packet arg0, int arg1) {
        if (arg1 == 1) {
            this.rgb = arg0.g3();
            this.calculateHsl(this.rgb);
        } else if (arg1 == 2) {
            this.textureId = arg0.g2();
            if (this.textureId == 65535) {
                this.textureId = -1;
            }
        } else if (arg1 == 3) {
            this.hueMultiplier = arg0.g2() << 2;
        } else if (arg1 == 4) {
            this.field6719 = false;
        } else if (arg1 == 5) {
            this.blendable = false;
        }
    }

    @ObfuscatedName("uc.a(IB)V")
    public void calculateHsl(int arg0) {
        double var2 = (double) (arg0 >> 16 & 0xFF) / 256.0D;
        double var4 = (double) (arg0 >> 8 & 0xFF) / 256.0D;
        double var6 = (double) (arg0 & 0xFF) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }
        if (var6 < var8) {
            var8 = var6;
        }
        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }
        if (var6 > var10) {
            var10 = var6;
        }
        double var12 = 0.0D;
        double var14 = 0.0D;
        double var16 = (var8 + var10) / 2.0D;
        if (var8 != var10) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var8 + var10);
            }
            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }
            if (var2 == var10) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = (var6 - var2) / (var10 - var8) + 2.0D;
            } else if (var6 == var10) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }
        double var18 = var12 / 6.0D;
        this.saturation = (int) (var14 * 256.0D);
        this.lightness = (int) (var16 * 256.0D);
        if (this.saturation < 0) {
            this.saturation = 0;
        } else if (this.saturation > 255) {
            this.saturation = 255;
        }
        if (this.lightness < 0) {
            this.lightness = 0;
        } else if (this.lightness > 255) {
            this.lightness = 255;
        }
        if (var16 > 0.5D) {
            this.chromaWeight = (int) ((1.0D - var16) * var14 * 512.0D);
        } else {
            this.chromaWeight = (int) (var14 * var16 * 512.0D);
        }
        if (this.chromaWeight < 1) {
            this.chromaWeight = 1;
        }
        this.hue = (int) ((double) this.chromaWeight * var18);
    }
}
