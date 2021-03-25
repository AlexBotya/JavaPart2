import static java.lang.System.arraycopy;

public class TrueDoubleStreamCalc {
    static final int size = 10000000;
    static final int h = size / 2;
    private float[] arr = new float[size];
    private float[] a1 = new float[h];
    private float[] a2 = new float[h];
    private long startTime, allStartTime;
    private boolean endPoint1 = true;
    private boolean endPoint2 = true;
    float counter = 0.0f;
    String waitingMessage = "Waiting for calculation completed...";


    public void calc() throws InterruptedException {
        System.out.println("\n True two thread calc is running...");
        allStartTime = System.currentTimeMillis();
        setStartTime();
        arraycopy(arr, 0, a1, 0, h);
        arraycopy(arr, h, a2, 0, h);
        printDuration("Array breakDown time: ");
        new Thread ( ()->{
            setStartTime();
            calc(a1);
            printDuration("First Tread proceed time: ");
            endPoint1=false;
        }).start();
        new Thread( ()-> {
            setStartTime();
            calc(a2);
            printDuration("Second Tread proceed time: ");
            endPoint2=false;
        }).start();
        while(endPoint1|| endPoint2){
            Thread.sleep(100);
            counter+=0.1f;
            System.out.println(waitingMessage + counter + " second");

        }
        setStartTime();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        printDuration("Array concatenation time: ");


    }
    private void calc(float[] array){
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i]= (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }
    private void setStartTime(){
        startTime = System.currentTimeMillis();
    }

    private void printDuration(String whatWasDone){
        System.out.println(whatWasDone + (System.currentTimeMillis()-startTime));
    }

}
