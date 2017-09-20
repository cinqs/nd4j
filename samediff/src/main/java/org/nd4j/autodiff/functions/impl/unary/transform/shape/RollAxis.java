package org.nd4j.autodiff.functions.impl.unary.transform.shape;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractUnaryFunction;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.opstate.OpState;
import org.nd4j.autodiff.samediff.SameDiff;

import java.util.Collections;
import java.util.List;

public class RollAxis extends AbstractUnaryFunction {

   private int axis;


    public RollAxis(SameDiff sameDiff, DifferentialFunction i_v, int axis) {
        super(sameDiff,i_v,null,
                OpState.OpType.SHAPE,
                new Object[]{axis});
        this.axis = axis;
    }

    @Override
    public ArrayField doGetValue() {
        return sameDiff.getArrayFactory().rollAxis(arg().getValue(true),axis);
    }



    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v) {
        DifferentialFunction ret = this;

        return Collections.singletonList(ret);
    }

    @Override
    public String functionName() {
        return "rollAxis";
    }

}
