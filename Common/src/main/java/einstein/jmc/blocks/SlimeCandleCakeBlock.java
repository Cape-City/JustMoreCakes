package einstein.jmc.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SlimeCandleCakeBlock extends BaseCandleCakeBlock {

    public SlimeCandleCakeBlock(BaseCakeBlock originalCake, Properties properties) {
        super(originalCake, properties);
    }

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (entity.isSuppressingBounce()) {
			super.fallOn(level, state, pos, entity, fallDistance);
		} else {
			entity.causeFallDamage(fallDistance, 0, level.damageSources().fall());
		}
	}

	@Override
	public void updateEntityAfterFallOn(BlockGetter getter, Entity entity) {
		if (entity.isSuppressingBounce()) {
			super.updateEntityAfterFallOn(getter, entity);
		} else {
			SlimeCakeBlock.bounceUp(entity);
		}
	}

	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
		double d0 = Math.abs(entity.getDeltaMovement().y);
		if (d0 < 0.1D && !entity.isSteppingCarefully()) {
			double d1 = 0.4D + d0 * 0.2D;
			entity.setDeltaMovement(entity.getDeltaMovement().multiply(d1, 1, d1));
		}
		super.stepOn(level, pos, state, entity);
	}
}
