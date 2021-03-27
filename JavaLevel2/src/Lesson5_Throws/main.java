package Lesson5_Throws;

public class main {
    public static void main(String[] args) {
        SingleStreamCalc singleStreamCalc = new SingleStreamCalc();
        singleStreamCalc.calc();
        SyncDoubleStreamCalc doubleStreamCalc = new SyncDoubleStreamCalc();
        try {
            doubleStreamCalc.calc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TrueDoubleStreamCalc trueDoubleStreamCalc = new TrueDoubleStreamCalc();
        try {
            trueDoubleStreamCalc.calc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
