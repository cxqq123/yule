package libx.android.designmode.create;

/**
 * Created by yule
 * on 2022/8/7
 * description :
 */
class OperationAdd extends Operation {

    @Override
    public double getResult() {
        return getNumA() + getNumB();
    }
}

class OperationSub extends Operation {

    @Override
    public double getResult() {
        return getNumA() - getNumB();
    }
}

class OperationMul extends Operation {

    @Override
    public double getResult() {
        return getNumA() * getNumB();
    }
}

class OperationDiv extends Operation {

    @Override
    public double getResult() {
        return getNumA() / getNumB();
    }
}