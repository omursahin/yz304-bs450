package eru.testing.calculator;

public class StubWriter implements Writer {
    String value;

    @Override
    public void write(String string) {
        this.value  = string;
    }

    public String getValue() {
        return value;
    }
}
