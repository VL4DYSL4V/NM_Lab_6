package command;

import framework.command.DefaultRunCommand;
import framework.utils.ConsoleUtils;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class RunCommand extends DefaultRunCommand {

    @Override
    public void execute(String[] strings) {
        BivariateFunction function = (BivariateFunction) applicationState.getVariable("function");
        Vector2D point = (Vector2D) applicationState.getVariable("point");
        double xN = (Double) applicationState.getVariable("xN");
        double n = (Double) applicationState.getVariable("n");

        double step = (xN - point.getX()) / n;
        ConsoleUtils.println(String.format("%n  X\t\t  Y"));
        ConsoleUtils.println("----------------");

        for(int i = 0; i < n; i++) {
            double yN = point.getY() + step * function.value(point.getX(), point.getY());
            ConsoleUtils.println(String.format("%.3f\t%.3f", point.getX(), point.getY()));
            point = new Vector2D(point.getX() + step, yN);
        }

        ConsoleUtils.println(String.format("%nAt x = %.3f y = %.3f", point.getX(), point.getY()));
    }

}
