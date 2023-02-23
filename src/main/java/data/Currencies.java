package data;

public enum Currencies {
    AUD("AUD"), CAD("CAD"), GBP("GBP"), USD("USD"), EUR("EUR");

    public String getCurrency() {
        return currency;
    }

    private String currency;

    Currencies (String cur){
        this.currency=cur;
    }

}
