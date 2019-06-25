package bean.cycle;

/***
 * 循环依赖问题展现
 */
public class CycleA {

    private CycleB b;

    public CycleA(){
        b = new CycleB();
    }

    public CycleB getB() {
        return b;
    }

    public void setB(CycleB b) {
        this.b = b;
    }
}
