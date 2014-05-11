package epam.students.prihodii.xmlTask.entity.types;

public class Parameters {

    private int length;
    private int width;
    private int height;

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Length: " + length + " width: " + width + " height: " + height;
    }
}
