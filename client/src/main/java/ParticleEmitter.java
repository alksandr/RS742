import deob.ObfuscatedName;

@ObfuscatedName("qo")
public class ParticleEmitter {

    @ObfuscatedName("qo.u")
    public final ModelParticleEmitter modelEmitter;

    @ObfuscatedName("qo.j")
    public ParticleEmitterType type;

    @ObfuscatedName("qo.a")
    public final ParticleSystem system;

    @ObfuscatedName("qo.s")
    public int emitAccumulator = 0;

    @ObfuscatedName("qo.c")
    public LinkQueue particles;

    @ObfuscatedName("qo.m")
    public int activeCount;

    @ObfuscatedName("qo.t")
    public long startTime;

    @ObfuscatedName("qo.l")
    public boolean disabled = false;

    @ObfuscatedName("qo.f")
    public ParticleEmitterRelated current = new ParticleEmitterRelated();

    @ObfuscatedName("qo.d")
    public ParticleEmitterRelated previous = new ParticleEmitterRelated();

    @ObfuscatedName("qo.z")
    public int normalX;

    @ObfuscatedName("qo.n")
    public int normalY;

    @ObfuscatedName("qo.o")
    public int normalZ;

    @ObfuscatedName("qo.q")
    public int emitYawCenter;

    @ObfuscatedName("qo.p")
    public int emitYawSpread;

    @ObfuscatedName("qo.w")
    public int emitPitchCenter;

    @ObfuscatedName("qo.b")
    public int emitPitchSpread;

    @ObfuscatedName("qo.x")
    public boolean degenerate = false;

    @ObfuscatedName("qo.i")
    public boolean normalComputed = false;

    public ParticleEmitter(RendererToolkit arg0, ModelParticleEmitter arg1, ParticleSystem arg2, long arg3) {
        this.modelEmitter = arg1;
        this.system = arg2;
        this.startTime = arg3;
        this.type = this.modelEmitter.getType();
        if (!arg0.method765() && this.type.lowDetailTypeId != -1) {
            this.type = ParticleEmitterType.get(this.type.lowDetailTypeId);
        }
        this.particles = new LinkQueue();
        this.emitAccumulator = (int) ((double) this.emitAccumulator + Math.random() * 64.0D);
        this.method8069();
        this.previous.x1 = this.current.x1;
        this.previous.y1 = this.current.y1;
        this.previous.z1 = this.current.z1;
        this.previous.x2 = this.current.x2;
        this.previous.y2 = this.current.y2;
        this.previous.z2 = this.current.z2;
        this.previous.x3 = this.current.x3;
        this.previous.y3 = this.current.y3;
        this.previous.z3 = this.current.z3;
    }

    @ObfuscatedName("qo.u(I)V")
    public void method8069() {
        this.current.x1 = this.modelEmitter.x1;
        this.current.y1 = this.modelEmitter.y1;
        this.current.z1 = this.modelEmitter.z1;
        this.current.x2 = this.modelEmitter.x2;
        this.current.y2 = this.modelEmitter.y2;
        this.current.z2 = this.modelEmitter.z2;
        this.current.x3 = this.modelEmitter.x3;
        this.current.y3 = this.modelEmitter.y3;
        this.current.z3 = this.modelEmitter.z3;
        if (this.current.x2 == this.current.x1 && this.current.x2 == this.current.x3 && this.current.y2 == this.current.y1 && this.current.y3 == this.current.y2 && this.current.z2 == this.current.z1 && this.current.z3 == this.current.z2) {
            this.degenerate = true;
        } else if (this.degenerate) {
            this.degenerate = false;
            this.previous.x1 = this.current.x1;
            this.previous.y1 = this.current.y1;
            this.previous.z1 = this.current.z1;
            this.previous.x2 = this.current.x2;
            this.previous.y2 = this.current.y2;
            this.previous.z2 = this.current.z2;
            this.previous.x3 = this.current.x3;
            this.previous.y3 = this.current.y3;
            this.previous.z3 = this.current.z3;
        }
    }

    @ObfuscatedName("qo.j(Lra;JIZI)V")
    public void method8070(RendererToolkit arg0, long arg1, int arg2, boolean arg3) {
        if (this.disabled) {
            arg3 = false;
        } else if (ParticleSystemRenderer.field4929 < this.type.minDetailLevel) {
            arg3 = false;
        } else if (ParticleSystemRenderer.field4926 > ParticleLimits.field1356[ParticleSystemRenderer.field4929]) {
            arg3 = false;
        } else if (this.degenerate) {
            arg3 = false;
        } else if (this.type.cyclePeriod != -1) {
            int var6 = (int) (arg1 - this.startTime);
            if (this.type.cycleLoops || var6 <= this.type.cyclePeriod) {
                var6 %= this.type.cyclePeriod;
            } else {
                arg3 = false;
            }
            if (!this.type.field2743 && var6 < this.type.cycleThreshold) {
                arg3 = false;
            }
            if (this.type.field2743 && var6 >= this.type.cycleThreshold) {
                arg3 = false;
            }
        }
        this.activeCount = 0;
        for (MovingParticle var7 = (MovingParticle) this.particles.method11649(); var7 != null; var7 = (MovingParticle) this.particles.method11644()) {
            var7.method16975(arg1, arg2);
            this.activeCount++;
        }
        if (arg3) {
            int var8 = (this.current.x3 + this.current.x2 + this.current.x1) / 3;
            int var9 = (this.current.y3 + this.current.y2 + this.current.y1) / 3;
            int var10 = (this.current.z3 + this.current.z2 + this.current.z1) / 3;
            if (this.current.centroidX != var8 || this.current.centroidY != var9 || this.current.centroidZ != var10 || !this.normalComputed) {
                this.current.centroidX = var8;
                this.current.centroidY = var9;
                this.current.centroidZ = var10;
                int var11 = this.current.x2 - this.current.x1;
                int var12 = this.current.y2 - this.current.y1;
                int var13 = this.current.z2 - this.current.z1;
                int var14 = this.current.x3 - this.current.x1;
                int var15 = this.current.y3 - this.current.y1;
                int var16 = this.current.z3 - this.current.z1;
                this.normalX = var12 * var16 - var13 * var15;
                this.normalY = var13 * var14 - var11 * var16;
                this.normalZ = var11 * var15 - var12 * var14;
                while (true) {
                    if (this.normalX <= 32767 && this.normalY <= 32767 && this.normalZ <= 32767 && this.normalX >= -32767 && this.normalY >= -32767 && this.normalZ >= -32767) {
                        int var17 = (int) Math.sqrt((double) (this.normalZ * this.normalZ + this.normalY * this.normalY + this.normalX * this.normalX));
                        if (var17 <= 0) {
                            var17 = 1;
                        }
                        this.normalX = this.normalX * 32767 / var17;
                        this.normalY = this.normalY * 32767 / var17;
                        this.normalZ = this.normalZ * 32767 / var17;
                        if (this.type.yawMax > 0 || this.type.pitchMax > 0) {
                            int var18 = (int) (Math.atan2((double) this.normalZ, (double) this.normalX) * 2607.5945876176133D);
                            int var19 = (int) (Math.atan2((double) this.normalY, Math.sqrt((double) (this.normalZ * this.normalZ + this.normalX * this.normalX))) * 2607.5945876176133D);
                            this.emitYawSpread = this.type.yawMax - this.type.yawMin;
                            this.emitYawCenter = this.type.yawMin + var18 - (this.emitYawSpread >> 1);
                            this.emitPitchSpread = this.type.pitchMax - this.type.pitchMin;
                            this.emitPitchCenter = this.type.pitchMin + var19 - (this.emitPitchSpread >> 1);
                        }
                        this.normalComputed = true;
                        break;
                    }
                    this.normalX >>= 0x1;
                    this.normalY >>= 0x1;
                    this.normalZ >>= 0x1;
                }
            }
            this.emitAccumulator += (int) ((double) arg2 * ((double) this.type.emitRateMin + Math.random() * (double) (this.type.emitRateMax - this.type.emitRateMin)));
            if (this.emitAccumulator > 63) {
                int var20 = this.emitAccumulator >> 6;
                this.emitAccumulator &= 0x3F;
                int var21 = (arg2 << 8) / var20;
                int var22 = 0;
                int var23 = 0;
                while (var23 < var20) {
                    int var24;
                    int var25;
                    int var26;
                    if (this.type.yawMax <= 0 && this.type.pitchMax <= 0) {
                        var24 = this.normalX;
                        var25 = this.normalY;
                        var26 = this.normalZ;
                    } else {
                        int var27 = this.emitYawCenter + (int) ((double) this.emitYawSpread * Math.random());
                        int var28 = var27 & 0x3FFF;
                        int var29 = Trig1.sin[var28];
                        int var30 = Trig1.cos[var28];
                        int var31 = this.emitPitchCenter + (int) ((double) this.emitPitchSpread * Math.random());
                        int var32 = var31 & 0x1FFF;
                        int var33 = Trig1.sin[var32];
                        int var34 = Trig1.cos[var32];
                        byte var35 = 13;
                        var24 = var30 * var33 >> var35;
                        var25 = (var34 << 1) * -1;
                        var26 = var29 * var33 >> var35;
                    }
                    float var36 = (float) Math.random();
                    float var37 = (float) Math.random();
                    if (var36 + var37 > 1.0F) {
                        var36 = 1.0F - var36;
                        var37 = 1.0F - var37;
                    }
                    float var38 = 1.0F - (var36 + var37);
                    int var39 = (int) ((float) this.current.x3 * var38 + (float) this.current.x2 * var37 + (float) this.current.x1 * var36);
                    int var40 = (int) ((float) this.current.y3 * var38 + (float) this.current.y2 * var37 + (float) this.current.y1 * var36);
                    int var41 = (int) ((float) this.current.z3 * var38 + (float) this.current.z2 * var37 + (float) this.current.z1 * var36);
                    int var42 = this.type.speedMin + (int) (Math.random() * (double) (this.type.speedMax - this.type.speedMin));
                    int var43 = this.type.lifetimeMin + (int) (Math.random() * (double) (this.type.lifetimeMax - this.type.lifetimeMin));
                    int var44 = this.type.sizeMin + (int) (Math.random() * (double) (this.type.sizeMax - this.type.sizeMin));
                    int var47;
                    if (this.type.field2693) {
                        double var45 = Math.random();
                        var47 = (int) ((double) this.type.deltaRed * var45 + (double) this.type.startRed) << 16 | (int) ((double) this.type.deltaGreen * var45 + (double) this.type.startGreen) << 8 | (int) ((double) this.type.deltaBlue * var45 + (double) this.type.startBlue) | (int) ((double) this.type.startAlpha + Math.random() * (double) this.type.deltaAlpha) << 24;
                    } else {
                        var47 = (int) ((double) this.type.startRed + Math.random() * (double) this.type.deltaRed) << 16 | (int) ((double) this.type.startGreen + Math.random() * (double) this.type.deltaGreen) << 8 | (int) ((double) this.type.startBlue + Math.random() * (double) this.type.deltaBlue) | (int) ((double) this.type.startAlpha + Math.random() * (double) this.type.deltaAlpha) << 24;
                    }
                    int var48 = this.type.spriteId;
                    if (!arg0.method765() && !this.type.field2694) {
                        var48 = -1;
                    }
                    MovingParticle var49;
                    if (ParticleSystemRenderer.field4922 == ParticleSystemRenderer.field4921) {
                        var49 = new MovingParticle(this, var39, var40, var41, var24, var25, var26, var42, var43, var47, var44, var48, this.type.field2715, this.type.field2718);
                    } else {
                        var49 = Statics.field4919[ParticleSystemRenderer.field4922];
                        ParticleSystemRenderer.field4922 = ParticleSystemRenderer.field4922 + 1 & 0x3FF;
                        var49.method16973(this, var39, var40, var41, var24, var25, var26, var42, var43, var47, var44, var48, this.type.field2715, this.type.field2718);
                    }
                    if (var22 > 256) {
                        var49.method16975(arg1, var22 >> 8);
                    }
                    this.activeCount++;
                    var23++;
                    var22 += var21;
                }
            }
        }
        if (!this.current.equalCentroid(this.previous)) {
            ParticleEmitterRelated var50 = this.previous;
            this.previous = this.current;
            this.current = var50;
            this.current.x1 = this.modelEmitter.x1;
            this.current.y1 = this.modelEmitter.y1;
            this.current.z1 = this.modelEmitter.z1;
            this.current.x2 = this.modelEmitter.x2;
            this.current.y2 = this.modelEmitter.y2;
            this.current.z2 = this.modelEmitter.z2;
            this.current.x3 = this.modelEmitter.x3;
            this.current.y3 = this.modelEmitter.y3;
            this.current.z3 = this.modelEmitter.z3;
            this.current.centroidX = this.previous.centroidX;
            this.current.centroidY = this.previous.centroidY;
            this.current.centroidZ = this.previous.centroidZ;
        }
        ParticleSystemRenderer.field4925 += this.activeCount;
    }

    @ObfuscatedName("qo.a(Loo;Lra;J)V")
    public void method8071(Scene arg0, RendererToolkit arg1, long arg2) {
        for (MovingParticle var5 = (MovingParticle) this.particles.method11649(); var5 != null; var5 = (MovingParticle) this.particles.method11644()) {
            var5.method16987(arg0, arg1, arg2);
        }
    }
}
