package gooblemc.jahm.item.hammers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class HammerItem extends PickaxeItem
{
    private final int radius;

    public HammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, int pRadius, Properties pProperties)
    {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        radius = pRadius;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity)
    {
        if (!level.isClientSide && entity instanceof Player player)
        {
            if (!player.isShiftKeyDown())
            {
                breakExtraBlocks(stack, level, pos, player);
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, Player player)
    {
        Level level = player.level();

        if (!level.isClientSide && player.isCreative())
        {
            if (!player.isShiftKeyDown())
            {
                breakExtraBlocks(stack, level, pos, player);
            }
        }

        return false;
    }

    private Direction getHitDirection(Player player)
    {
        HitResult hitResult = player.pick(20.0D, 0.0F, false);

        if (hitResult instanceof BlockHitResult blockHitResult)
        {
            return blockHitResult.getDirection();
        }

        return player.getDirection();
    }

    private void breakExtraBlocks(ItemStack stack, Level level, BlockPos origin, Player player)
    {
        Direction direction = getHitDirection(player);

        for (int a = -radius; a <= radius; a++)
        {
            for (int b = -radius; b <= radius; b++)
            {
                if (!player.isCreative() && stack.getDamageValue() >= stack.getMaxDamage() - 1)
                    return;

                BlockPos targetPos;

                if (direction == Direction.UP || direction == Direction.DOWN)
                {
                    // Floor/ceiling: mine X/Z plane
                    targetPos = origin.offset(a, 0, b);
                }
                else if (direction == Direction.NORTH || direction == Direction.SOUTH)
                {
                    // North/south wall: mine X/Y plane
                    targetPos = origin.offset(a, b, 0);
                }
                else
                {
                    // East/west wall: mine Z/Y plane
                    targetPos = origin.offset(0, b, a);
                }

                if (targetPos.equals(origin))
                    continue;

                BlockState targetState = level.getBlockState(targetPos);

                if (targetState.isAir())
                    continue;

                if (targetState.getDestroySpeed(level, targetPos) < 0)
                    continue;

                if (!stack.isCorrectToolForDrops(targetState))
                    continue;

                if (level.destroyBlock(targetPos, !player.isCreative(), player))
                {
                    if (!player.isCreative())
                    {
                        stack.hurtAndBreak(1, player, (p) -> {
                            p.broadcastBreakEvent(player.getUsedItemHand());
                        });
                    }
                }
            }
        }
    }
}
