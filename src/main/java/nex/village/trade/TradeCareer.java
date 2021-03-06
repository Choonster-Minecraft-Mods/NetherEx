/*
 * NetherEx
 * Copyright (c) 2016-2017 by LogicTechCorp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nex.village.trade;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import nex.init.NetherExLootTables;

import java.util.List;

public class TradeCareer
{
    private String name;
    private List<TradeOffer> trades;

    public String getName()
    {
        return name;
    }

    public List<TradeOffer> getTrades()
    {
        return trades;
    }

    public static class Weighted extends WeightedRandom.Item
    {
        private EnumType type;

        public Weighted(EnumType typeIn)
        {
            super(typeIn.getWeight());
            type = typeIn;
        }

        public EnumType getType()
        {
            return type;
        }
    }

    public enum EnumType
    {
        FARMER(TradeProfession.EnumType.FARMER, 4, NetherExLootTables.ENTITY_PIGTIFICATE_FARMER),
        TOOLSMITH(TradeProfession.EnumType.BLACKSMITH, 8, NetherExLootTables.ENTITY_PIGTIFICATE_TOOLSMITH),
        BUTCHER(TradeProfession.EnumType.BUTCHER, 5, NetherExLootTables.ENTITY_PIGTIFICATE_BUTCHER);

        private TradeProfession.EnumType profession;
        private int weight;
        private ResourceLocation lootTable;

        EnumType(TradeProfession.EnumType professionIn, int weightIn, ResourceLocation lootTableIn)
        {
            profession = professionIn;
            weight = weightIn;
            lootTable = lootTableIn;
        }

        public static EnumType fromIndex(int index)
        {
            EnumType career = values()[index];
            return career != null ? career : FARMER;
        }

        public static EnumType fromCareer(TradeCareer career)
        {
            return valueOf(career.getName().toUpperCase());
        }

        public int getWeight()
        {
            return weight;
        }

        public ResourceLocation getLootTable()
        {
            return lootTable;
        }

        public TradeProfession.EnumType getProfession()
        {
            return profession;
        }
    }
}
