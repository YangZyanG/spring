package factoryBean;

import org.springframework.beans.factory.FactoryBean;

/***
 * 实现FactoryBean的配置方式更灵活
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public Car getObject() throws Exception {
        Car car = new Car();

        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));

        return car;
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
