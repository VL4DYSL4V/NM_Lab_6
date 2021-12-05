package state;

import framework.state.AbstractApplicationState;
import lombok.Getter;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

@Getter
public class LaboratoryState extends AbstractApplicationState {

    private final BivariateFunction function = (x, y) -> x + y;

    private final Vector2D vector2D = new Vector2D(0, 1);

    //    calculation point
    private final double xN = 0.5;

    //    amount of steps
    private final double n = 10;

    @Override
    protected void initVariableNameToGettersMap() {
        this.variableNameToGetter.put("point", this::getVector2D);
        this.variableNameToGetter.put("function", this::getFunction);
        this.variableNameToGetter.put("xN", this::getXN);
        this.variableNameToGetter.put("n", this::getN);
    }
}
