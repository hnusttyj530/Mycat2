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
package io.mycat.hbt4;


import io.mycat.calcite.table.MycatTransientSQLTableScan;
import io.mycat.hbt3.MycatLookUpView;
import io.mycat.hbt3.View;
import io.mycat.hbt4.executor.MycatBatchNestedLoopJoin;
import io.mycat.hbt4.logical.rel.*;

public interface ExecutorImplementor {

    Executor implement(MycatNestedLoopJoin mycatJoin);

    Executor implement(MycatCalc mycatCalc);

    Executor implement(MycatProject mycatProject);

    Executor implement(MycatFilter mycatFilter);

    Executor implement(MycatHashAggregate mycatAggregate);

    Executor implement(MycatUnion mycatUnion);

    Executor implement(MycatIntersect mycatIntersect);

    Executor implement(MycatMinus mycatMinus);

    Executor implement(MycatTableModify mycatTableModify);

    Executor implement(MycatValues mycatValues);

    Executor implement(MycatMemSort mycatSort);

    Executor implement(QueryView gatherView);

    Executor implement(MycatMaterializedSemiJoin materializedSemiJoin);

    Executor implement(MycatMergeSort mergeSort);

    Executor implement(MycatSemiHashJoin semiHashJoin);

    Executor implement(MycatSortAgg sortAgg);

    Executor implement(MycatSortMergeJoin sortMergeJoin);

    Executor implement(MycatSortMergeSemiJoin sortMergeSemiJoin);

    Executor implement(MycatTopN topN);

    Executor implement(MycatQuery mycatQuery);

    Executor implement(View view);

    Executor implement(MycatTransientSQLTableScan mycatTransientSQLTableScan);

    Executor implement(MycatHashJoin mycatHashJoin);

    Executor implement(MycatCorrelate mycatCorrelate);

    Executor implement(MycatBatchNestedLoopJoin mycatBatchNestedLoopJoin);

    Executor implement(MycatLookUpView mycatLookUpView);

    Executor implement(MycatGather mycatGather);

//    Executor implement(BottomView bottomView);
}