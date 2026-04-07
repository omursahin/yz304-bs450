package eru.testing.calculator;

public class StubReader implements Reader {

    @Override
    public double readDouble() {
        return 10.0;
    }

    @Override
    public String readWord() {
        return "+";
    }
}
