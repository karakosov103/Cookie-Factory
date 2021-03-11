package ai.leantech.dto;

public class CookieBatchRequest {
    private long cookieId;
    private double weight;

    public long getCookieId() {
        return cookieId;
    }

    public void setCookieId(long cookieId) {
        this.cookieId = cookieId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
