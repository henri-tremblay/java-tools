package pro.tremblay.javatools;

public class ThreadLock {

   public static void main(String[] args) throws InterruptedException {
      Thread t1 = new Thread() {
         @Override
         public void run() {
            try {
               synchronized (this) {
                  wait();
               }
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
         }
      };
      t1.start();
      t1.join();
   }
}

