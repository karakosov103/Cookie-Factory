package ai.leantech.dto;

import java.util.List;

public class BatchRequest {
    private List<CookieBatchRequest> cookies;

    public List<CookieBatchRequest> getCookies() {
        return cookies;
    }

    public void setCookies(List<CookieBatchRequest> cookies) {
        this.cookies = cookies;
    }
}
