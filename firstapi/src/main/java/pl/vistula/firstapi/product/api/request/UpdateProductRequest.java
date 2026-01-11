package pl.vistula.firstapi.product.api.request;

public class UpdateProductRequest {
    private String name;

    public UpdateProductRequest() {
    }

    public UpdateProductRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}