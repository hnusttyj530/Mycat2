/**
 * Copyright (C) <2020>  <chen junwen>
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program.  If
 * not, see <http://www.gnu.org/licenses/>.
 */
package io.mycat.calcite.physical;

import com.google.common.collect.ImmutableList;
import io.mycat.calcite.Executor;
import io.mycat.calcite.ExecutorImplementor;
import io.mycat.calcite.ExplainWriter;
import io.mycat.calcite.MycatRel;
import org.apache.calcite.adapter.enumerable.EnumerableRelImplementor;
import org.apache.calcite.adapter.enumerable.EnumerableValues;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.Values;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexLiteral;

import java.util.List;

/**
 * Values operator implemented in Mycat convention.
 */
public class MycatValues extends Values implements MycatRel {
    protected MycatValues(RelOptCluster cluster, RelDataType rowType,
                          ImmutableList<ImmutableList<RexLiteral>> tuples, RelTraitSet traitSet) {
        super(cluster, rowType, tuples, traitSet);
    }

    public static MycatValues create(RelOptCluster cluster, RelDataType rowType,
                                     ImmutableList<ImmutableList<RexLiteral>> tuples, RelTraitSet traitSet) {
        return new MycatValues(cluster, rowType, tuples, traitSet);
    }

    @Override
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        assert inputs.isEmpty();
        return new MycatValues(getCluster(), rowType, tuples, traitSet);
    }


    @Override
    public ExplainWriter explain(ExplainWriter writer) {
        return writer.name("MycatValues").item("values", tuples).ret();
    }

    @Override
    public Executor implement(ExecutorImplementor implementor) {
        return implementor.implement(this);
    }

    public Result implement(EnumerableRelImplementor implementor, Prefer pref) {
        EnumerableValues enumerableValues = EnumerableValues.create(getCluster(), rowType, tuples);
        return enumerableValues.implement(implementor, pref);
    }
}