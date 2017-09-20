package org.nd4j.autodiff.functions.impl.binary.transform.gradient;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractBinaryFunction;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.opstate.OpState;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.ops.impl.transforms.LeakyReLUDerivative;

import java.util.Arrays;
import java.util.List;

public class LeakyReluDerivative  extends AbstractBinaryFunction {
    private double cutoff;


    public LeakyReluDerivative() {
    }

    public LeakyReluDerivative(SameDiff sameDiff, DifferentialFunction i_v1, DifferentialFunction i_v2) {
        super(sameDiff, i_v1, i_v2, OpState.OpType.GRADIENT);
    }

    public LeakyReluDerivative(SameDiff sameDiff) {
        super(sameDiff);
    }


    public LeakyReluDerivative(SameDiff sameDiff,
                               DifferentialFunction i_v,
                               DifferentialFunction i_v2,
                               double cutoff) {
        super(sameDiff, i_v, i_v2, OpState.OpType.GRADIENT,new Object[]{cutoff});
        this.cutoff = cutoff;
    }

    @Override
    public ArrayField doGetValue() {
        return a().leakyReluDerivative(larg().getValue(true),rarg().getValue(true) , cutoff);
    }


    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v) {
        DifferentialFunction ret = f().zero(getResultShape());

        return Arrays.asList(ret);
    }

    @Override
    public String functionName() {
        return new LeakyReLUDerivative().name();
    }

}
