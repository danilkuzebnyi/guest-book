package task2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homework {
    Random r = new Random();
    List<BigDecimal> hwGrades = new ArrayList<>();
    MathContext scale = new MathContext(2, RoundingMode.HALF_UP);
    List<String> deadline = new ArrayList<>();

    public void giveGradesForHw(int numberOfHw) {
        double min = 2;
        double max = 5;
        for (int i = 0; i < numberOfHw; i++) {
            double hwGrade = min + (max - min) * r.nextDouble();
            BigDecimal result = new BigDecimal(hwGrade, scale);
            hwGrades.add(result);
        }
    }

    public void madeItToTheDeadline(int numberOfHw) {
        for (int i = 0; i < numberOfHw; i++) {
            boolean beOnTime  = r.nextBoolean();
            if (beOnTime) {
                deadline.add("+");
            }
            else {
                deadline.add("-");
            }
        }
    }

}
