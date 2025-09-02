package payment;

public interface Revertable {
    public boolean cancel();
    public boolean refund();
}
