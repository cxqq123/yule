package libx.android.designmode.strategy;

/**
 * Created by yule
 * on 2022/8/8
 * description : 策略模式
 *
 * 策略模式就是用来封装算法的，但在实践中，我们发现可以用它来封装几乎任何类型规则，只要
 * 在分析过程中听到需要在不同时间应用不同的业务规则，就可以用策略模式
 */
abstract class Strategy {

    public abstract void algo();
}
