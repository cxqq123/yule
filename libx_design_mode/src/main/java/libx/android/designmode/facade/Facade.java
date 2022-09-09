package libx.android.designmode.facade;

/**
 * Created by yule
 * on 2022/8/13
 * description :
 */
class Facade {

    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
    }

    public void methodA() {
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }

    public void methodB() {
        two.methodTwo();
        three.methodThree();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
