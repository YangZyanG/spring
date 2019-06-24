package factoryBean;

/***
 * bean的传统配置方式，需要在配置文件中提供大量配置信息。
 * 配置方式的灵活性受限。
 */
public class Car {

    private int maxSpeed;
    private String brand;
    private double price;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return brand + "," + maxSpeed + "," + price;
    }
}
