/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.items.tools.quartz;

import appeng.container.ContainerLocator;
import appeng.mixins.RemainderSetter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import appeng.api.features.AEFeature;
import appeng.api.implementations.guiobjects.IGuiItem;
import appeng.api.implementations.guiobjects.IGuiItemObject;
import appeng.items.AEBaseItem;
import appeng.util.Platform;

public class QuartzCuttingKnifeItem extends AEBaseItem implements IGuiItem {
    private final AEFeature type;

    public QuartzCuttingKnifeItem(Item.Settings props, final AEFeature type) {
        super(props);
        this.type = type;
        // See below for reasoning
        ((RemainderSetter)this).setRecipeRemainder(this);
    }

    @Override
    public TypedActionResult<ItemStack> use(final World w, final PlayerEntity p, final Hand hand) {
        if (Platform.isServer()) {
// FIXME FABRIC           ContainerOpener.openContainer(QuartzKnifeContainer.TYPE, p, ContainerLocator.forHand(p, hand));
            throw new IllegalStateException();
        }
        p.swingHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, p.getStackInHand(hand));
    }

    @Override
    public IGuiItemObject getGuiObject(final ItemStack is, int playerInventorySlot, final World world,
            final BlockPos pos) {
       // FIXME FABRIC return new QuartzKnifeObj(is);
        throw new IllegalStateException();
    }
}