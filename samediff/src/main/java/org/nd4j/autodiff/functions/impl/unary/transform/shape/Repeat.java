package org.nd4j.autodiff.functions.impl.unary.transform.shape;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractUnaryFunction;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.opstate.OpState;
import org.nd4j.autodiff.samediff.SameDiff;

import java.util.List;

public class Repeat  extends AbstractUnaryFunction {

    private int axis;

    public Repeat(SameDiff sameDiff, DifferentialFunction i_v, int axis) {
        super(sameDiff, i_v, i_v.getValue(true).getInput().getShape(), OpState.OpType.SHAPE,new Object[]{axis});
        this.axis = axis;
    }
    @Override
    public ArrayField doGetValue() {
        return a().repeat(arg().getValue(true),axis);
    }


    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String functionName() {
        return "repeat";
    }
}
