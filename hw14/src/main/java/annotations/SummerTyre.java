package annotations;

import org.springframework.stereotype.Component;

@Component
public class SummerTyre extends Tyre {
    @Override
    public String driveAccordingToTheSeason() {
        return "I can drive at summer";
    }
}
