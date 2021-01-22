// Initiates Philosopher class
public class Philosopher implements Runnable {
    private Object leftFork;
    private Object rightFork;
    // How many times each philospher will eat
    private int foodLeft = 5;

    // Creates the philosophers objects
    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    // Action to print eating turn, uses Threads for concurrency
    public void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((int) (Math.random() * 100));
    }

    // Here is the function that executes the fork pick-up arrangement
    @Override
    public void run() {
        try{
            // If philosopher still needs to eat, pick up left fork
            while(foodLeft>0){
                doAction(
                  "Food left : "+this.foodLeft+" : Thinking" );
                synchronized (leftFork){
                    doAction(
                     "Food left : "+this.foodLeft+ " : Picked up left fork");
                     // Synchronoze with other philosophers, is your fork available? If so other puts it doen and you pick it up.
                    synchronized (rightFork){
                        doAction(
                          "Food left: "+this.foodLeft+" : Picked up right fork and started eating");
                        doAction(
                          "Food left : "+this.foodLeft+" : Put down right fork");
                        this.foodLeft-=1;
                    }
                    // Put left down after eating
                    doAction(
                       "Food left : "+this.foodLeft+" : Put down left fork and start thinking");
                }
            }
            
            // error handler
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }
    
}