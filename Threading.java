class Threading {
    public static void main(String args[]) {
        
        // Named Threading$1 -> anonymous inner class
        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        };

        // Named Threading$2
        Thread t2 = new Thread() {
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        };

        MyThread m1 = new MyThread("Hello there", 1000, 6);
        MyThread m2 = new MyThread("General Kenobi", 1000, 6);

        m1.start();
        m2.start();

        // The thread does not start until .start() like Python
        // t1.join();
    }
}

class MyThread extends Thread {
    private String message;
    private int delay;
    private int inc;

    MyThread(String message, int delay, int inc) {
        this.message = message;
        this.delay = delay;
        this.inc = inc;
    }

    @Override
    public void run() {
        for(int i = 0; i < inc; i++) {
            System.out.println(this.message);
            try {
                Thread.sleep(this.delay);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
