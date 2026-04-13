import deob.ObfuscatedName;

@ObfuscatedName("rd")
public class FloorOverlayTypeList {

    @ObfuscatedName("rd.u")
    public final Js5 js5;

    @ObfuscatedName("rd.j")
    public int capacity;

    @ObfuscatedName("rd.a")
    public final SoftLruHashTable cache = new SoftLruHashTable(64);

    @ObfuscatedName("rd.s")
    public int field5108 = 0;

    public FloorOverlayTypeList(ModeGame arg0, Language arg1, Js5 arg2) {
        this.js5 = arg2;
        this.capacity = this.js5.getGroupCapacity(Js5ConfigGroup.FLOTYPE.field1668);
    }

    @ObfuscatedName("rd.u(IS)Lry;")
    public FloorOverlayType get(int arg0) {
        SoftLruHashTable var2 = this.cache;
        FloorOverlayType var3;
        synchronized (this.cache) {
            var3 = (FloorOverlayType) this.cache.get((long) arg0);
        }
        if (var3 != null) {
            return var3;
        }
        Js5 var5 = this.js5;
        byte[] var6;
        synchronized (this.js5) {
            var6 = this.js5.fetchFile(Js5ConfigGroup.FLOTYPE.field1668, arg0);
        }
        FloorOverlayType var8 = new FloorOverlayType();
        var8.typeList = this;
        var8.id = arg0;
        if (var6 != null) {
            var8.decode(new Packet(var6));
        }
        var8.postDecode();
        SoftLruHashTable var9 = this.cache;
        synchronized (this.cache) {
            this.cache.method7937(var8, (long) arg0);
            return var8;
        }
    }

    @ObfuscatedName("rd.j(I)V")
    public void clear() {
        SoftLruHashTable var1 = this.cache;
        synchronized (this.cache) {
            this.cache.method7922();
        }
    }

    @ObfuscatedName("rd.a(IB)V")
    public void method8501(int arg0) {
        SoftLruHashTable var2 = this.cache;
        synchronized (this.cache) {
            this.cache.method7921(arg0);
        }
    }

    @ObfuscatedName("rd.s(I)V")
    public void removeSoft() {
        SoftLruHashTable var1 = this.cache;
        synchronized (this.cache) {
            this.cache.removeSoft();
        }
    }
}
