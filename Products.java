/*
 * Clase de productos donde van todos los elementos de los productos.
 */
public class Products {
    private int SKU;
    private String name;
    private String description;
    private String cantPerSize;

    public Products(int SKU, String name, String description, String cantPerSize) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.cantPerSize = cantPerSize;
    }

    public int getSKU() {
        return SKU;
    }

    public void setSKU(int SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCantPerSize() {
        return cantPerSize;
    }

    public void setCantPerSize(String cantPerSize) {
        this.cantPerSize = cantPerSize;
    }

    @Override
    public String toString() {
        return "SKU: " + SKU + ", Name: " + name + ", Description: " + description + ", Sizes: " + cantPerSize;
    }
}
