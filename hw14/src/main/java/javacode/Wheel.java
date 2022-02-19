package javacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Wheel {
    public Tyre tyre;

    public Tyre getTyre() {
        return tyre;
    }

    @Autowired
    @Qualifier("winterTyre")
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public String getTypeOfTyre() {
        return tyre.getName();
    }

    public int getSizeOfTyre() {
        return tyre.getSize();
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "tyre=" + tyre +
                '}';
    }
}
