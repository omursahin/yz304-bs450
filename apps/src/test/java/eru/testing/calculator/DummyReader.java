package eru.testing.calculator;

public class DummyReader implements Reader {

    @Override
    public double readDouble() {
        return 0.0;
    }

    @Override
    public String readWord() {
        return "";
    }
}
