package task2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class Homework extends Teacher {
    Random r = new Random();
    MathContext scale = new MathContext(2, RoundingMode.HALF_UP);

    public List giveGradesForHw(int numberOfHw) {
        double min = 2;
        double max = 5;
        List<BigDecimal> hwGrades = new ArrayList<>();
        for (int i = 0; i < numberOfHw; i++) {
            double hwGrade = min + (max - min) * r.nextDouble();
            BigDecimal grade = new BigDecimal(hwGrade, scale);
            hwGrades.add(grade);
        }
        return hwGrades;
    }

    public List madeItToTheDeadline(int numberOfHw) {
        List<String> deadline = new ArrayList<>();
        for (int i = 0; i < numberOfHw; i++) {
            boolean beOnTime = r.nextBoolean();
            if (beOnTime) {
                deadline.add("+");
            } else {
                deadline.add("-");
            }
        }
        return deadline;
    }

}
