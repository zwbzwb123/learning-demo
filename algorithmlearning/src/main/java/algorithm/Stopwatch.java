package algorithm;

public class Stopwatch {

    long start;

    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    public void stop(String msg){
        long now = System.currentTimeMillis();
        System.out.println(msg + (now - start));
    }
}
