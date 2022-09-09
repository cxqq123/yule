package libx.android.designmode.create;

/**
 * Created by yule
 * on 2022/8/7
 * description : 简单工厂模式
 */
public class OperationFactory {

    public static Operation createOperate(String operate) {
        Operation operation;

        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operate);
        }

        return operation;
    }

    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperate("+");
        operation.setNumA(1);
        operation.setNumB(2);
        Double result = operation.getResult();
        System.out.println("result : " + result);
    }
}
