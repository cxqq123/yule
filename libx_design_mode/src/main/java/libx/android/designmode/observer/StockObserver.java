package libx.android.designmode.observer;

/**
 * Created by yule
 * on 2022/8/13
 * description :
 */
class StockObserver {
    private String name;
    private Secretary sub;

    public StockObserver(String name, Secretary sub) {
        this.name = name;
        this.sub = sub;
    }

    public void update() {

    }
}
