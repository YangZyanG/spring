package bean.cycle;

public class CycleB {

    private CycleA a;

    public CycleB(){
        a = new CycleA();
    }

    public CycleA getA() {
        return a;
    }

    public void setA(CycleA a) {
        this.a = a;
    }
}
