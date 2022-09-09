package libx.android.designmode.strategy;

/**
 * Created by yule
 * on 2022/8/8
 * description : 上下文
 */
class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Context(String type) {
        switch (type) {
            case "A":
                strategy = new ConcreteStrategyA();
                break;
            case "B":
                strategy = new ConcreteStrategyB();
                break;
            case "C":
                strategy = new ConcreteStrategyC();
                break;
        }
    }

    public void contextInterface() {
        strategy.algo();
    }

    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();

        Context context2 = new Context("A");
        context2.contextInterface();
    }
}
