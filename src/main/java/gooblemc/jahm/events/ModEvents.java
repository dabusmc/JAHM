package gooblemc.jahm.events;

import gooblemc.jahm.item.hammers.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEvents
{
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event)
    {
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();

        if (!(stack.getItem() instanceof HammerItem))
            return;

        if (player.isShiftKeyDown())
            return;

        if (event.getPosition().isEmpty())
            return;

        BlockPos origin = event.getPosition().get();

        float originalHardness = event.getState().getDestroySpeed(player.level(), origin);
        float hardestBlock = originalHardness;

        int radius = 1;
        Direction direction = player.getDirection();

        for (int a = -radius; a <= radius; a++)
        {
            for (int b = -radius; b <= radius; b++)
            {
                BlockPos targetPos;

                if (direction == Direction.NORTH || direction == Direction.SOUTH)
                {
                    targetPos = origin.offset(a, b, 0);
                }
                else
                {
                    targetPos = origin.offset(0, b, a);
                }

                BlockState targetState = player.level().getBlockState(targetPos);

                if (targetState.isAir())
                    continue;

                if (targetState.getDestroySpeed(player.level(), targetPos) < 0)
                    continue;

                if (!stack.isCorrectToolForDrops(targetState))
                    continue;

                float hardness = targetState.getDestroySpeed(player.level(), targetPos);

                if (hardness > hardestBlock)
                {
                    hardestBlock = hardness;
                }
            }
        }

        if (hardestBlock > originalHardness)
        {
            float multiplier = originalHardness / hardestBlock;
            event.setNewSpeed(event.getOriginalSpeed() * multiplier);
        }
    }
}
