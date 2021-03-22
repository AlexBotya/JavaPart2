public class SingleStreamCalc {
    static final int size = 10000000;
    float[] arr = new float[size];
    long startTime;

    public void calc(){
        System.out.println("Single thread calc is running...");
        //startTime = System.currentTimeMillis();
        setStartTime();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        printDuration("Duration of singlestream calculate: ");


    }
    private void setStartTime(){
        startTime = System.currentTimeMillis();
    }
    private void printDuration(String whatWasDone){
        System.out.println(whatWasDone + (System.currentTimeMillis()-startTime) + "\n");
    }
}
