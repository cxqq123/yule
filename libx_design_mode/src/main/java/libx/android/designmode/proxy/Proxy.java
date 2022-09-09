package libx.android.designmode.proxy;

/**
 * Created by yule
 * on 2022/8/11
 * description : 代理模式，为其他对象提供一种代理以控制对这个对象的访问
 */
class Proxy implements IGiveGift {
    Pursuit gg;
    public Proxy(SchoolGirl mm) {
        gg = new Pursuit(mm);
    }
    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
