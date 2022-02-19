package xml;

public class Wheel {
    public Tyre tyre;

    public Tyre getTyre() {
        return tyre;
    }

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
