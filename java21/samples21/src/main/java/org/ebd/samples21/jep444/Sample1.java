package org.ebd.samples21.jep444;

public class Sample1 {
    public static void doWork() {
        try {
            //code...
            //VT is unmounted from PT
            Thread.sleep(3000);
            //VT is mounted to PT again
            //code...
        } catch (InterruptedException e) {}
    }
    public static void main(String[] args) {
        int MAX=1000;
        for(var i=0; i<MAX; i++) {
            new Thread(Sample1::doWork).start();
            //Thread.startVirtualThread(Sample1::doWork);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Done!");
    }
}
