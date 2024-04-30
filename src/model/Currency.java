package model;

public final class Currency {
    private final String NAME, CODE;

    public Currency(String CODE, String NAME) {
        this.NAME = NAME;
        this.CODE = CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public String getCODE() {
        return CODE;
    }

    @Override
    public String toString() {
        return "{"+CODE+", "+NAME+"}";
    }

}
