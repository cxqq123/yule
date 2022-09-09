package libx.android.designmode.decorator;

/**
 * Created by yule
 * on 2022/8/11
 * description :
 */
class ConcreteDecoratorA extends Decorator {

    // 本类的独有功能
    private String addedState;
    @Override
    public void operation() {
        super.operation();
        addedState = "New State";
    }
}


class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }

    private void addedBehavior() {

    }
}

class Test {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();
        d1.setComponent(component);
        d2.setComponent(d1);
        d2.operation();
    }
}