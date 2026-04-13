import deob.ObfuscatedName;

@ObfuscatedName("ux")
public class FloorUnderlayTypeList {

    @ObfuscatedName("ux.u")
    public final Js5 js5;

    @ObfuscatedName("ux.j")
    public final SoftLruHashTable cache = new SoftLruHashTable(128);

    public FloorUnderlayTypeList(ModeGame arg0, Language arg1, Js5 arg2) {
        this.js5 = arg2;
        this.js5.getGroupCapacity(Js5ConfigGroup.FLUTYPE.field1668);
    }

    @ObfuscatedName("ux.u(IB)Luc;")
    public FloorUnderlayType get(int arg0) {
        SoftLruHashTable var2 = this.cache;
        FloorUnderlayType var3;
        synchronized (this.cache) {
            var3 = (FloorUnderlayType) this.cache.get((long) arg0);
        }
        if (var3 != null) {
            return var3;
        }
        Js5 var5 = this.js5;
        byte[] var6;
        synchronized (this.js5) {
            var6 = this.js5.fetchFile(Js5ConfigGroup.FLUTYPE.field1668, arg0);
        }
        FloorUnderlayType var8 = new FloorUnderlayType();
        if (var6 != null) {
            var8.decode(new Packet(var6));
        }
        SoftLruHashTable var9 = this.cache;
        synchronized (this.cache) {
            this.cache.method7937(var8, (long) arg0);
            return var8;
        }
    }

    @ObfuscatedName("ux.j(I)V")
    public void clear() {
        SoftLruHashTable var1 = this.cache;
        synchronized (this.cache) {
            this.cache.method7922();
        }
    }

    @ObfuscatedName("ux.a(IB)V")
    public void method11896(int arg0) {
        SoftLruHashTable var2 = this.cache;
        synchronized (this.cache) {
            this.cache.method7921(arg0);
        }
    }

    @ObfuscatedName("ux.s(B)V")
    public void removeSoft() {
        SoftLruHashTable var1 = this.cache;
        synchronized (this.cache) {
            this.cache.removeSoft();
        }
    }
}
