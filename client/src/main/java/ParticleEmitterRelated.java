import deob.ObfuscatedName;

@ObfuscatedName("ql")
public class ParticleEmitterRelated {

    @ObfuscatedName("ql.u")
    public int x1;

    @ObfuscatedName("ql.j")
    public int y1;

    @ObfuscatedName("ql.a")
    public int z1;

    @ObfuscatedName("ql.s")
    public int x2;

    @ObfuscatedName("ql.c")
    public int y2;

    @ObfuscatedName("ql.m")
    public int z2;

    @ObfuscatedName("ql.t")
    public int x3;

    @ObfuscatedName("ql.l")
    public int y3;

    @ObfuscatedName("ql.f")
    public int z3;

    @ObfuscatedName("ql.d")
    public int centroidX;

    @ObfuscatedName("ql.z")
    public int centroidY;

    @ObfuscatedName("ql.n")
    public int centroidZ;

    @ObfuscatedName("ql.u(Lql;I)Z")
    public boolean equalCentroid(ParticleEmitterRelated arg0) {
        return this.centroidX == arg0.centroidX && this.centroidY == arg0.centroidY && this.centroidZ == arg0.centroidZ;
    }
}
