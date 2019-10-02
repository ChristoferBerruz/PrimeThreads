/**
 * Prime Thread is the a Thread that finds the number of prime numbers on a given range.
 */
public class PrimeThread extends Thread {
    private Work work;
    private String name;
    private int bite_count = 0;
    private int n_primes;
    private long runningTime;

    public PrimeThread(Work work, String name){
        this.work = work;
        this.name = name;
    }

    /**
     * Tests whether or not an integer n is prime.
     * @return
     */
    public boolean isPrime(int n){
        if (n%2 == 0)
        {
            return false;
        }else{
            int maxCase = (int)Math.ceil(Math.sqrt(n));
            for (int c_odd = 3; c_odd <= maxCase; c_odd += 2){
                if(n % c_odd == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * Overriding Run method of the Thread class
     */
    public void run(){
        long t0 = System.nanoTime();
        while(work.isMoreWork()){
            bite_count++;
            Range nextRange = work.giveWork();
            for(int low = nextRange.getMin(); low <= nextRange.getMax(); low++){
                if(isPrime(low)) n_primes++;
            }
        }

        long t1 = System.nanoTime();
        runningTime = t1-t0;
        System.out.println("-------------------------");
        System.out.println(name);
        System.out.println("-------------------------");
        System.out.println("- Bite: " + bite_count);
        System.out.println("- Prime Count: " + n_primes);
        System.out.println("- Time: " + (runningTime/1000000000.0) + " secs");
    }


    public int getN_primes() {
        return n_primes;
    }
}
