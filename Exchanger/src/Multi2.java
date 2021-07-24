/*
 Implementing Runnable interface
 */
//package multithreading;

class Multi2 implements Runnable{
    public void run(){
        System.out.println("Thread is running");
    }
    public static void main(String[] args){
        Multi2 t2 = new Multi2();
        Thread t1 = new Thread(t2);
        t1.start();
       
    }
}
