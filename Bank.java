class Bank {
    public static void main(String args[]) {
        final int N = 1000000;
        Account a = new Account();

        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < N; i++) {
                    a.deposit(1);
                }
            }
        };

        t1.start();

        System.out.println(a.getBalance());
        
        for(int i = 0; i < N; i++) {
            a.withdraw(1);
        }
        System.out.println(a.getBalance());
    }
}
