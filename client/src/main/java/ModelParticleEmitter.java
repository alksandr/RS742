import deob.ObfuscatedName;

@ObfuscatedName("dx")
public class ModelParticleEmitter {

    @ObfuscatedName("dx.u")
    public final int typeId;

    @ObfuscatedName("dx.j")
    public ModelParticleEmitter field1372;

    @ObfuscatedName("dx.a")
    public final int vertexA;

    @ObfuscatedName("dx.s")
    public final int vertexB;

    @ObfuscatedName("dx.c")
    public final int vertexC;

    @ObfuscatedName("dx.m")
    public final byte field1382;

    @ObfuscatedName("dx.t")
    public int x1;

    @ObfuscatedName("dx.l")
    public int y1;

    @ObfuscatedName("dx.f")
    public int z1;

    @ObfuscatedName("dx.d")
    public int x2;

    @ObfuscatedName("dx.z")
    public int y2;

    @ObfuscatedName("dx.n")
    public int z2;

    @ObfuscatedName("dx.o")
    public int x3;

    @ObfuscatedName("dx.q")
    public int y3;

    @ObfuscatedName("dx.p")
    public int z3;

    public ModelParticleEmitter(int arg0, int arg1, int arg2, int arg3, byte arg4) {
        this.typeId = arg0;
        this.vertexA = arg1;
        this.vertexB = arg2;
        this.vertexC = arg3;
        this.field1382 = arg4;
    }

    @ObfuscatedName("dx.u(B)Liu;")
    public ParticleEmitterType getType() {
        return ParticleEmitterType.get(this.typeId);
    }

    @ObfuscatedName("dx.j(IIIB)Ldx;")
    public ModelParticleEmitter method2701(int arg0, int arg1, int arg2) {
        return new ModelParticleEmitter(this.typeId, arg0, arg1, arg2, this.field1382);
    }
}
