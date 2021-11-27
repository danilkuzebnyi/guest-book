package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lecture extends Homework{
    //Map<String, Lectures> lectureOfStudent = new HashMap<>();
    List<String> lectures = new ArrayList<>();

    public void giveLecture(int numberOfLectures) {
        for (int i = 0; i < numberOfLectures; i++) {
            boolean beOnLecture  = r.nextBoolean();
            if (beOnLecture) {
                lectures.add("+");

            }
            else {
                lectures.add("-");
            }
        }
    }
}
