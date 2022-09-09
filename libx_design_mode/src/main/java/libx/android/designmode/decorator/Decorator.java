package libx.android.designmode.decorator;

/**
 * Created by yule
 * on 2022/8/11
 * description : 装饰者模式：是为已有功能动态地添加更多功能的一种方式
 */
abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
