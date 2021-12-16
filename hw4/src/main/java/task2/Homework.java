package task2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class Homework {

    public static List giveGradesForHw(int numberOfHw) {
        double min = 2;
        double max = 5;
        List<BigDecimal> hwGrades = new ArrayList<>();
        Random random = new Random();
        MathContext scale = new MathContext(2, RoundingMode.HALF_UP);
        for (int i = 0; i < numberOfHw; i++) {
            double hwGrade = min + (max - min) * random.nextDouble();
            BigDecimal grade = new BigDecimal(hwGrade, scale);
            hwGrades.add(grade);
        }
        return hwGrades;
    }

    public static List madeItToTheDeadline(int numberOfHw) {
        List<String> deadline = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfHw; i++) {
            boolean beOnTime = random.nextBoolean();
            if (beOnTime) {
                deadline.add("+");
            } else {
                deadline.add("-");
            }
        }
        return deadline;
    }

}
