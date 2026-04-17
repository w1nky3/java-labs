package task4;

public class ImmutableRectangle {
    private final double width;
    private final double height;

    public ImmutableRectangle(double width, double height){
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("Высота и ширина должны быть положительными");
        }

        this.height = height;
        this.width = width;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return (height + width) * 2;
    }

    public ImmutableRectangle withWidth(double newWidth){
        return new ImmutableRectangle(newWidth, this.height);
    }

    public ImmutableRectangle withHeight(double newHeight){
        return new ImmutableRectangle(this.width, newHeight);
    }

    // геттеры
    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    @Override
    public String toString() {
        return "ImmutableRectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
