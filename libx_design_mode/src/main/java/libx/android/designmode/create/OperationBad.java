package libx.android.designmode.create;

/**
 * Created by yule
 * on 2022/8/7
 * description :
 */
class OperationBad {

    public static double getResult(double numA, double numB, String operate) {
        double result = 0L;
        switch (operate) {
            case "+":
                result = numA + numB;
                break;
            case "-":
                result = numA - numB;
                break;
            case "*":
                result = numA * numB;
                break;
            case "/":
                result = numA / numB;
                break;
        }
        return result;
    }
}
