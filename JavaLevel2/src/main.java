public class main {
    public static void main(String[] args) {
        SingleStreamCalc singleStreamCalc = new SingleStreamCalc();
        singleStreamCalc.calc();
        DoubleStreamCalc doubleStreamCalc = new DoubleStreamCalc();
        try {
            doubleStreamCalc.calc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
