package net.linearmatrix.fetchini.item.functional;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.linearmatrix.fetchini.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos posClicked=pContext.getClickedPos();
            Player player=pContext.getPlayer();
            boolean found=false;
            for(int i=0;i<=posClicked.getY()+64;i++){
                BlockState state=pContext.getLevel().getBlockState(posClicked.below(i));
                if(isValuable(state)){
                    valuableCoors(posClicked.below(i),player,state.getBlock());
                    found=true;
                    break;
                }
            }
            if(!found){
                player.sendSystemMessage(Component.literal("Metal Detector: Timeout - No valuables found!"));
            }
        }
        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),player->player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.fetchini.metal_detector"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void valuableCoors(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Metal Detector: Found "+ I18n.get(block.getDescriptionId())+" at coordinates ("+blockPos.getX()+", "+blockPos.getY()+", "+blockPos.getZ()+")."));
    }

    private boolean isValuable(BlockState state){
        return state.is(Blocks.ANCIENT_DEBRIS)||state.is(Blocks.DIAMOND_ORE)||state.is(Blocks.EMERALD_ORE)||state.is(Blocks.GOLD_ORE)||state.is(Blocks.LAPIS_ORE)||state.is(Blocks.REDSTONE_ORE)||state.is(Blocks.IRON_ORE)||state.is(Blocks.DEEPSLATE_DIAMOND_ORE)||state.is(Blocks.DEEPSLATE_EMERALD_ORE)||state.is(Blocks.DEEPSLATE_GOLD_ORE)||state.is(Blocks.DEEPSLATE_LAPIS_ORE)||state.is(Blocks.DEEPSLATE_REDSTONE_ORE)||state.is(Blocks.DEEPSLATE_IRON_ORE);
    }
}
