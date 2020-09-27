package bean.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 循环依赖问题展现
 */

@Component
public class CycleA {

    @Autowired
    private CycleB b;

    public CycleA(){

    }

    public CycleB getB() {
        return b;
    }

    public void setB(CycleB b) {
        this.b = b;
    }
}
