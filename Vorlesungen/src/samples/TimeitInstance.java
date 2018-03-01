package samples;

public class TimeitInstance {
    double time = 0;

    public void code(Runnable code) {
        double start = System.nanoTime();

        try {
            code.run();
        } finally {
            long end = System.nanoTime();
            this.setTime((end - start) / 1.0e9);
            System.out.println("Time taken(s)" +  time);
        }

    }

    public double getTime() {
        return time;
    }

    public void setTime(double d) {
        this.time = d;
    }

    public boolean isFaster(TimeitInstance other) {
        return this.time < other.time;
    }

    public double fasterTimes(TimeitInstance other) {
        return other.time/this.time;
    }


}

