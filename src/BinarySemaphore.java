public class BinarySemaphore {
    private boolean state;

    public BinarySemaphore() {
        this(true);
    }

    public BinarySemaphore(boolean initialState) {
        this.state = initialState;
    }

    public synchronized void P() { // P — opuszczanie semafora (hol. proberen), powoduje zmniejszenie wartości zmiennej semaforowej
        while (!this.state) {
            try {
                this.wait();
            } catch (InterruptedException __) {}
        }
        this.state = false;
    }

    public synchronized void V() { // V — podnoszenie semafora (hol. verhogen). powoduje zwiekszanie wartości zmiennej semaforowej
        this.state = true;
        this.notify();
    }
}
