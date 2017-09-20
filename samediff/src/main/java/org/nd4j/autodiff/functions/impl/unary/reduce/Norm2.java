package org.nd4j.autodiff.functions.impl.unary.reduce;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractReduceUnaryFunction;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;

import java.util.Collections;
import java.util.List;

public class Norm2 extends AbstractReduceUnaryFunction {

    public Norm2(SameDiff sameDiff, DifferentialFunction i_v, int[] dimensions) {
        super(sameDiff, i_v, dimensions);
    }

    @Override
    public ArrayField doGetValue() {
        return a().norm1(arg().doGetValue(),dimensions);
    }


    @Override
    public String functionName() {
        return new org.nd4j.linalg.api.ops.impl.accum.Norm2().name();
    }



    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v1) {
        DifferentialFunction ret = f().doNormGrad(this,i_v1.get(0),"norm2",dimensions);

        return Collections.singletonList(ret);
    }
}
