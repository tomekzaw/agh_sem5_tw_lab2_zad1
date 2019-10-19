public class Counter {
    private long value = 0;
    private BinarySemaphore sem;

    public Counter(BinarySemaphore sem) {
        this.sem = sem;
    }

    public long getValue() {
        return this.value;
    }

    // public void increment() {
    public void increment() {
        this.sem.P();
        ++this.value;
        this.sem.V();
    }

    // public void decrement() {
    public void decrement() {
        this.sem.P();
        --this.value;
        this.sem.V();
    }
}
