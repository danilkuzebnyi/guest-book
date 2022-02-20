package annotations;

public abstract class Tyre {
    private int size;
    private String name;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String driveAccordingToTheSeason() {
        return "I can drive";
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
