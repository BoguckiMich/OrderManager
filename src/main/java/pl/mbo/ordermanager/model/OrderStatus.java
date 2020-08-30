package pl.mbo.ordermanager.model;

public enum OrderStatus {
    DELIVERED("Delivered"),
    WAITING("Waiting"),
    ONTHEWAY("On the way"),
    RECEIVED("Received"),
    PREPARED("Prepared"),
    ;

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
    public String getDescription(){return description;}
}
