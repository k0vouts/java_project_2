package pl.vistula.firstapi.product.api.request;

public class UpdateProductRequest {

    private final String name;

    public UpdateProductRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}