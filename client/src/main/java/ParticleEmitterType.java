import deob.ObfuscatedName;

@ObfuscatedName("iu")
public class ParticleEmitterType {

    @ObfuscatedName("iu.c")
    public static SoftLruHashTable cache = new SoftLruHashTable(64);

    @ObfuscatedName("iu.m")
    public short yawMin;

    @ObfuscatedName("iu.t")
    public short yawMax;

    @ObfuscatedName("iu.l")
    public short pitchMin;

    @ObfuscatedName("iu.f")
    public short pitchMax;

    @ObfuscatedName("iu.d")
    public int speedMin;

    @ObfuscatedName("iu.z")
    public int speedMax;

    @ObfuscatedName("iu.n")
    public int dragMode = 0;

    @ObfuscatedName("iu.o")
    public int dragStrength;

    @ObfuscatedName("iu.q")
    public int speedTarget = -1;

    @ObfuscatedName("iu.p")
    public int speedBlendPercent = 100;

    @ObfuscatedName("iu.w")
    public int sizeMin;

    @ObfuscatedName("iu.b")
    public int sizeMax;

    @ObfuscatedName("iu.x")
    public int sizeTarget = -1;

    @ObfuscatedName("iu.i")
    public int sizeBlendPercent = 100;

    @ObfuscatedName("iu.v")
    public int startColour;

    @ObfuscatedName("iu.k")
    public int endColour;

    @ObfuscatedName("iu.h")
    public boolean field2693 = true;

    @ObfuscatedName("iu.r")
    public int targetColour;

    @ObfuscatedName("iu.g")
    public int colourBlendPercent = 100;

    @ObfuscatedName("iu.y")
    public int alphaBlendPercent = 100;

    @ObfuscatedName("iu.e")
    public int spriteId = -1;

    @ObfuscatedName("iu.ay")
    public int lifetimeMin;

    @ObfuscatedName("iu.af")
    public int lifetimeMax;

    @ObfuscatedName("iu.ar")
    public int emitRateMin;

    @ObfuscatedName("iu.an")
    public int emitRateMax;

    @ObfuscatedName("iu.ap")
    public int[] field2702;

    @ObfuscatedName("iu.ag")
    public int[] field2674;

    @ObfuscatedName("iu.as")
    public int[] field2698;

    @ObfuscatedName("iu.ai")
    public int[] field2705;

    @ObfuscatedName("iu.al")
    public int killAboveLevel = -2;

    @ObfuscatedName("iu.at")
    public int killBelowLevel = -2;

    @ObfuscatedName("iu.ax")
    public int initialEmissions = 0;

    @ObfuscatedName("iu.aw")
    public boolean field2743 = true;

    @ObfuscatedName("iu.aa")
    public boolean cycleLoops = true;

    @ObfuscatedName("iu.am")
    public int cycleThreshold = -1;

    @ObfuscatedName("iu.ad")
    public int cyclePeriod = -1;

    @ObfuscatedName("iu.az")
    public int minDetailLevel = 0;

    @ObfuscatedName("iu.ak")
    public boolean field2715 = true;

    @ObfuscatedName("iu.av")
    public int lowDetailTypeId = -1;

    @ObfuscatedName("iu.aj")
    public boolean field2694 = false;

    @ObfuscatedName("iu.ah")
    public boolean field2718 = true;

    @ObfuscatedName("iu.au")
    public boolean collidesWithEntities = false;

    @ObfuscatedName("iu.ae")
    public boolean killOnGroundContact = true;

    @ObfuscatedName("iu.ac")
    public boolean hasFloorClamp = false;

    @ObfuscatedName("iu.aq")
    public int startRed;

    @ObfuscatedName("iu.ab")
    public int endRed;

    @ObfuscatedName("iu.bq")
    public int deltaRed;

    @ObfuscatedName("iu.bz")
    public int startGreen;

    @ObfuscatedName("iu.bv")
    public int endGreen;

    @ObfuscatedName("iu.bj")
    public int deltaGreen;

    @ObfuscatedName("iu.bf")
    public int startBlue;

    @ObfuscatedName("iu.bt")
    public int endBlue;

    @ObfuscatedName("iu.bg")
    public int deltaBlue;

    @ObfuscatedName("iu.bl")
    public int startAlpha;

    @ObfuscatedName("iu.bk")
    public int endAlpha;

    @ObfuscatedName("iu.bs")
    public int deltaAlpha;

    @ObfuscatedName("iu.bn")
    public int colourBlendDuration;

    @ObfuscatedName("iu.ba")
    public int alphaBlendDuration;

    @ObfuscatedName("iu.bd")
    public int colourRateRed;

    @ObfuscatedName("iu.bc")
    public int colourRateGreen;

    @ObfuscatedName("iu.br")
    public int colourRateBlue;

    @ObfuscatedName("iu.bp")
    public int colourRateAlpha;

    @ObfuscatedName("iu.bi")
    public int speedBlendDuration;

    @ObfuscatedName("iu.bx")
    public int speedRate;

    @ObfuscatedName("iu.bm")
    public int sizeBlendDuration;

    @ObfuscatedName("iu.bb")
    public int sizeRate;

    @ObfuscatedName("pp.u(Lls;I)V")
    public static void setJs5(Js5 arg0) {
        Statics.particleEmitterJs5 = arg0;
    }

    @ObfuscatedName("df.j(IB)Liu;")
    public static ParticleEmitterType get(int arg0) {
        ParticleEmitterType var1 = (ParticleEmitterType) cache.get((long) arg0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = Statics.particleEmitterJs5.fetchFile(0, arg0);
        ParticleEmitterType var3 = new ParticleEmitterType();
        if (var2 != null) {
            var3.decode(new Packet(var2));
        }
        var3.postDecode();
        cache.method7937(var3, (long) arg0);
        return var3;
    }

    @ObfuscatedName("iu.a(Laet;B)V")
    public void decode(Packet arg0) {
        while (true) {
            int var2 = arg0.g1();
            if (var2 == 0) {
                return;
            }
            this.decodeOpcode(arg0, var2);
        }
    }

    @ObfuscatedName("iu.s(Laet;II)V")
    public void decodeOpcode(Packet arg0, int arg1) {
        if (arg1 == 1) {
            this.yawMin = (short) arg0.g2();
            this.yawMax = (short) arg0.g2();
            this.pitchMin = (short) arg0.g2();
            this.pitchMax = (short) arg0.g2();
            byte var3 = 3;
            this.yawMin = (short) (this.yawMin << var3);
            this.yawMax = (short) (this.yawMax << var3);
            this.pitchMin = (short) (this.pitchMin << var3);
            this.pitchMax = (short) (this.pitchMax << var3);
        } else if (arg1 == 2) {
            arg0.g1();
        } else if (arg1 == 3) {
            this.speedMin = arg0.g4s();
            this.speedMax = arg0.g4s();
        } else if (arg1 == 4) {
            this.dragMode = arg0.g1();
            this.dragStrength = arg0.g1b();
        } else if (arg1 == 5) {
            this.sizeMin = this.sizeMax = arg0.g2() << 12 << 2;
        } else if (arg1 == 6) {
            this.startColour = arg0.g4s();
            this.endColour = arg0.g4s();
        } else if (arg1 == 7) {
            this.lifetimeMin = arg0.g2();
            this.lifetimeMax = arg0.g2();
        } else if (arg1 == 8) {
            this.emitRateMin = arg0.g2();
            this.emitRateMax = arg0.g2();
        } else if (arg1 == 9) {
            int var4 = arg0.g1();
            this.field2702 = new int[var4];
            for (int var5 = 0; var5 < var4; var5++) {
                this.field2702[var5] = arg0.g2();
            }
        } else if (arg1 == 10) {
            int var6 = arg0.g1();
            this.field2698 = new int[var6];
            for (int var7 = 0; var7 < var6; var7++) {
                this.field2698[var7] = arg0.g2();
            }
        } else if (arg1 == 12) {
            this.killAboveLevel = arg0.g1b();
        } else if (arg1 == 13) {
            this.killBelowLevel = arg0.g1b();
        } else if (arg1 == 14) {
            this.initialEmissions = arg0.g2();
        } else if (arg1 == 15) {
            this.spriteId = arg0.g2();
        } else if (arg1 == 16) {
            this.field2743 = arg0.g1() == 1;
            this.cycleThreshold = arg0.g2();
            this.cyclePeriod = arg0.g2();
            this.cycleLoops = arg0.g1() == 1;
        } else if (arg1 == 17) {
            this.lowDetailTypeId = arg0.g2();
        } else if (arg1 == 18) {
            this.targetColour = arg0.g4s();
        } else if (arg1 == 19) {
            this.minDetailLevel = arg0.g1();
        } else if (arg1 == 20) {
            this.colourBlendPercent = arg0.g1();
        } else if (arg1 == 21) {
            this.alphaBlendPercent = arg0.g1();
        } else if (arg1 == 22) {
            this.speedTarget = arg0.g4s();
        } else if (arg1 == 23) {
            this.speedBlendPercent = arg0.g1();
        } else if (arg1 == 24) {
            this.field2693 = false;
        } else if (arg1 == 25) {
            int var8 = arg0.g1();
            this.field2674 = new int[var8];
            for (int var9 = 0; var9 < var8; var9++) {
                this.field2674[var9] = arg0.g2();
            }
        } else if (arg1 == 26) {
            this.field2715 = false;
        } else if (arg1 == 27) {
            this.sizeTarget = arg0.g2() << 12 << 2;
        } else if (arg1 == 28) {
            this.sizeBlendPercent = arg0.g1();
        } else if (arg1 == 29) {
            arg0.g2s();
        } else if (arg1 == 30) {
            this.field2694 = true;
        } else if (arg1 == 31) {
            this.sizeMin = arg0.g2() << 12 << 2;
            this.sizeMax = arg0.g2() << 12 << 2;
        } else if (arg1 == 32) {
            this.field2718 = false;
        } else if (arg1 == 33) {
            this.collidesWithEntities = true;
        } else if (arg1 == 34) {
            this.killOnGroundContact = false;
        }
    }

    @ObfuscatedName("iu.c(I)V")
    public void postDecode() {
        if (this.killAboveLevel > -2 || this.killBelowLevel > -2) {
            this.hasFloorClamp = true;
        }
        this.startRed = this.startColour >> 16 & 0xFF;
        this.endRed = this.endColour >> 16 & 0xFF;
        this.deltaRed = this.endRed - this.startRed;
        this.startGreen = this.startColour >> 8 & 0xFF;
        this.endGreen = this.endColour >> 8 & 0xFF;
        this.deltaGreen = this.endGreen - this.startGreen;
        this.startBlue = this.startColour & 0xFF;
        this.endBlue = this.endColour & 0xFF;
        this.deltaBlue = this.endBlue - this.startBlue;
        this.startAlpha = this.startColour >> 24 & 0xFF;
        this.endAlpha = this.endColour >> 24 & 0xFF;
        this.deltaAlpha = this.endAlpha - this.startAlpha;
        if (this.targetColour != 0) {
            this.colourBlendDuration = this.lifetimeMax * this.colourBlendPercent / 100;
            this.alphaBlendDuration = this.lifetimeMax * this.alphaBlendPercent / 100;
            if (this.colourBlendDuration == 0) {
                this.colourBlendDuration = 1;
            }
            this.colourRateRed = ((this.targetColour >> 16 & 0xFF) - (this.deltaRed / 2 + this.startRed) << 8) / this.colourBlendDuration;
            this.colourRateGreen = ((this.targetColour >> 8 & 0xFF) - (this.deltaGreen / 2 + this.startGreen) << 8) / this.colourBlendDuration;
            this.colourRateBlue = ((this.targetColour & 0xFF) - (this.deltaBlue / 2 + this.startBlue) << 8) / this.colourBlendDuration;
            if (this.alphaBlendDuration == 0) {
                this.alphaBlendDuration = 1;
            }
            this.colourRateAlpha = ((this.targetColour >> 24 & 0xFF) - (this.deltaAlpha / 2 + this.startAlpha) << 8) / this.alphaBlendDuration;
            this.colourRateRed += this.colourRateRed > 0 ? -4 : 4;
            this.colourRateGreen += this.colourRateGreen > 0 ? -4 : 4;
            this.colourRateBlue += this.colourRateBlue > 0 ? -4 : 4;
            this.colourRateAlpha += this.colourRateAlpha > 0 ? -4 : 4;
        }
        if (this.speedTarget != -1) {
            this.speedBlendDuration = this.speedBlendPercent * this.lifetimeMax / 100;
            if (this.speedBlendDuration == 0) {
                this.speedBlendDuration = 1;
            }
            this.speedRate = (this.speedTarget - ((this.speedMax - this.speedMin) / 2 + this.speedMin)) / this.speedBlendDuration;
        }
        if (this.sizeTarget == -1) {
            return;
        }
        this.sizeBlendDuration = this.lifetimeMax * this.sizeBlendPercent / 100;
        if (this.sizeBlendDuration == 0) {
            this.sizeBlendDuration = 1;
        }
        this.sizeRate = (this.sizeTarget - ((this.sizeMax - this.sizeMin) / 2 + this.sizeMin)) / this.sizeBlendDuration;
    }

    @ObfuscatedName("jp.m(B)V")
    public static void clearCache() {
        cache.method7922();
    }
}
