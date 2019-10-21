public class BinarySemaphore {
    private boolean state;

    public BinarySemaphore() {
        this(true);
    }

    public BinarySemaphore(boolean initialState) {
        this.state = initialState;
    }

    // P — opuszczanie semafora (hol. proberen), powoduje zmniejszenie wartości zmiennej semaforowej
    public synchronized void P() {
        while (!this.state) {
            try {
                this.wait();
            } catch (InterruptedException __) {}
        }
        this.state = false;
    }

    // V — podnoszenie semafora (hol. verhogen). powoduje zwiekszanie wartości zmiennej semaforowej
    public synchronized void V() {
        this.state = true;
        this.notify();
    }
}
