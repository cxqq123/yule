package libx.android.designmode.create;

/**
 * Created by yule
 * on 2022/8/7
 * description :
 */
public abstract class Operation {
    private double numA = 0;
    private double numB = 0;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public abstract double getResult();
}
