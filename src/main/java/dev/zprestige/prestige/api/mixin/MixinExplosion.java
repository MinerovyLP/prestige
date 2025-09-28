package dev.zprestige.prestige.api.mixin;

import dev.zprestige.prestige.api.interfaces.IExplosion;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={Explosion.class})
public class MixinExplosion implements IExplosion {
    @Shadow
    @Final
    @Mutable
    public World getWorld();
    @Shadow
    @Final
    @Mutable
    public Entity getEntity();
    @Shadow
    @Final
    @Mutable
    public double getPosition().y;
    @Shadow
    @Final
    @Mutable
    public double getPosition().x;
    @Shadow
    @Final
    @Mutable
    public double getPosition().z;
    @Shadow
    @Final
    @Mutable
    public float getPower();
    @Shadow
    @Final
    @Mutable
    public boolean canTriggerBlocks();
    @Shadow
    @Final
    @Mutable
    public Explosion.DestructionType getDestructionType();

    @Override
    public void set(Vec3d vec3d, float f, boolean bl) {
        world = MinecraftClient.getInstance().world;
        entity = null;
        x = vec3d.x;
        y = vec3d.y;
        z = vec3d.z;
        power = f;
        createFire = bl;
        destructionType = Explosion.DestructionType.DESTROY;
    }
}