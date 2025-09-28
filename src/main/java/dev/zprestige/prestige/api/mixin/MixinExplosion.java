package dev.zprestige.prestige.api.mixin;

import dev.zprestige.prestige.api.interfaces.IExplosion;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionImpl;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ExplosionImpl.class)
public abstract class MixinExplosionImpl implements IExplosion {

    // === Accessors for private final fields in ExplosionImpl ===
    @Accessor("power")
    public abstract void setPower(float value);

    @Accessor("pos")
    public abstract void setPos(Vec3d pos);

    @Accessor("world")
    public abstract void setWorld(ServerWorld world);

    @Accessor("entity")
    public abstract void setEntity(@Nullable Entity entity);

    @Accessor("destructionType")
    public abstract void setDestructionType(Explosion.DestructionType type);

    @Accessor("createFire")
    public abstract void setCreateFire(boolean createFire);

    // === IExplosion implementation ===
    @Override
    public void set(Vec3d vec3d, float f, boolean bl) {
        setWorld(MinecraftClient.getInstance().world);
        setPos(vec3d);
        setPower(f);
        setCreateFire(bl);
        setDestructionType(Explosion.DestructionType.DESTROY);
        setEntity(null);
    }
}