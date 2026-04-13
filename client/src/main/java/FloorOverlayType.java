import deob.ObfuscatedName;

@ObfuscatedName("ry")
public class FloorOverlayType {

    @ObfuscatedName("ry.j")
    public FloorOverlayTypeList typeList;

    @ObfuscatedName("ry.a")
    public int id;

    @ObfuscatedName("ry.s")
    public int rgb = 0;

    @ObfuscatedName("ry.c")
    public int textureId = -1;

    @ObfuscatedName("ry.m")
    public boolean hideUnderlay = true;

    @ObfuscatedName("ry.t")
    public int secondaryRgb = -1;

    @ObfuscatedName("ry.l")
    public int hueMultiplier = 512;

    @ObfuscatedName("ry.f")
    public boolean blendable = true;

    @ObfuscatedName("ry.d")
    public int priority = 8;

    @ObfuscatedName("ry.z")
    public boolean field5097 = false;

    @ObfuscatedName("ry.n")
    public int field5102 = 1190717;

    @ObfuscatedName("ry.o")
    public int field5099 = 512;

    @ObfuscatedName("ry.q")
    public int field5100 = 256;

    @ObfuscatedName("ry.p")
    public int field5101 = 64;

    @ObfuscatedName("ry.w")
    public int field5090 = 0;

    @ObfuscatedName("ry.b")
    public int field5098 = 64;

    @ObfuscatedName("ry.u(Laet;I)V")
    public void decode(Packet arg0) {
        while (true) {
            int var2 = arg0.g1();
            if (var2 == 0) {
                return;
            }
            this.decodeOpcode(arg0, var2);
        }
    }

    @ObfuscatedName("ry.j(Laet;II)V")
    public void decodeOpcode(Packet arg0, int arg1) {
        if (arg1 == 1) {
            this.rgb = rgbToHsl16(arg0.g3());
        } else if (arg1 == 2) {
            this.textureId = arg0.g1();
        } else if (arg1 == 3) {
            this.textureId = arg0.g2();
            if (this.textureId == 65535) {
                this.textureId = -1;
            }
        } else if (arg1 == 5) {
            this.hideUnderlay = false;
        } else if (arg1 == 7) {
            this.secondaryRgb = rgbToHsl16(arg0.g3());
        } else if (arg1 == 8) {
            this.typeList.field5108 = this.id;
        } else if (arg1 == 9) {
            this.hueMultiplier = arg0.g2() << 2;
        } else if (arg1 == 10) {
            this.blendable = false;
        } else if (arg1 == 11) {
            this.priority = arg0.g1();
        } else if (arg1 == 12) {
            this.field5097 = true;
        } else if (arg1 == 13) {
            this.field5102 = arg0.g3();
        } else if (arg1 == 14) {
            this.field5099 = arg0.g1() << 2;
        } else if (arg1 == 16) {
            this.field5100 = arg0.g1();
        } else if (arg1 == 20) {
            this.field5101 = arg0.g2();
        } else if (arg1 == 21) {
            this.field5090 = arg0.g1();
        } else if (arg1 == 22) {
            this.field5098 = arg0.g2();
        }
    }

    @ObfuscatedName("ry.a(B)V")
    public void postDecode() {
        this.priority = this.priority << 8 | this.id;
    }

    @ObfuscatedName("lt.s(IB)I")
    public static int rgbToHsl16(int arg0) {
        return arg0 == 16711935 ? -1 : ColourUtils.method16884(arg0);
    }
}
