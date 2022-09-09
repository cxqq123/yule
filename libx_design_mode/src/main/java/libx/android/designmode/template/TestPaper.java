package libx.android.designmode.template;

/**
 * Created by yule
 * on 2022/8/13
 * description :
 */
abstract class TestPaper {

    public void testQuestion1() {
        answer1();
    }

    public void testQuestion2() {
        answer2();
    }

    public void testQuestion3() {
        answer3();
    }

    protected abstract String answer1();
    protected abstract String answer2();
    protected abstract String answer3();


    public static void main(String[] args) {
        TestPaper stuA = new TestPaperA();
        stuA.testQuestion1();
        stuA.testQuestion2();
        stuA.testQuestion3();

        TestPaperB stuB = new TestPaperB();
        stuB.testQuestion1();
        stuB.testQuestion2();
        stuB.testQuestion3();
    }
}
