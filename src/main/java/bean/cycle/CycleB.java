package bean.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CycleB {

    @Autowired
    private CycleA a;

    public CycleB(){
    }

    public CycleA getA() {
        return a;
    }

    public void setA(CycleA a) {
        this.a = a;
    }
}
