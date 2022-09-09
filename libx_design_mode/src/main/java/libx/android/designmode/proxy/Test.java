package libx.android.designmode.proxy;


/**
 * Created by yule
 * on 2022/8/11
 * description :
 */
class Test {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("manmanzi");

        Proxy proxy = new Proxy(jiaojiao);
        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();
    }
}
