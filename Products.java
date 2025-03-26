/*
 * Clase de products donde van todos los elementos de los productos.
 */

public class Products {
    private int SKU;
    private String name;
    private String description;
    private String cantpersize;

    public Products(int SKU, String name, String description, String cantpersize) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.cantpersize = cantpersize;
    }

    public int getSKU() {
        return SKU;
    }

    public void setSKU(int sKU) {
        SKU = sKU;
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

    public String getCantpersize() {
        return cantpersize;
    }

    public void setCantpersize(String cantpersize) {
        this.cantpersize = cantpersize;
    }

}
