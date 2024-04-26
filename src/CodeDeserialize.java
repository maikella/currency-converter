public final class CodeDeserialize {
    public CodeDeserialize(String USD, String ANG, String BRL, String EUR, String code, String codeValue, double currency) {
        this.USD = USD;
        this.ANG = ANG;
        this.BRL = BRL;
        this.EUR = EUR;
        this.code = code;
        this.codeValue = codeValue;
        this.currency = currency;
    }

    private final String USD, ANG, BRL, EUR;

    private final String code;
    private final String codeValue;
    private final double currency;

    public String getCode() {
        return code;
    }

    public double getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "{" + code + "=" + currency + "}";
    }
}
