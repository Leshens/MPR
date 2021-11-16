package leshen.org.MPR5.car;

public class Car {
    private long id;
    private String engine;
    private String brand;
    private String color;

    public Car(String engine, String brand, String color) {
        this.engine = engine;
        this.brand = brand;
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }
}
