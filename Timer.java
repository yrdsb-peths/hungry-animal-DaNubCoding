public class Timer  
{
    private boolean dormant;
    private long start_time;
    private int total_time;

    public Timer(int total_time) {
        this.start_time = System.currentTimeMillis();
        this.total_time = total_time;
        this.dormant = false;
    }
    
    public Timer(int total_time, boolean dormant) {
        this.start_time = System.currentTimeMillis();
        this.total_time = total_time;
        this.dormant = true;
    }

    public boolean ended() {
        return !this.dormant && System.currentTimeMillis() - this.start_time > this.total_time;
    }

    public void restart() {
        this.start_time = System.currentTimeMillis();
    }

    public void start() {
        this.dormant = false;
        this.restart();
    }
}
