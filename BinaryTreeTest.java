import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    private BinaryTree<String, Products> byName;
    private BinaryTree<String, Products> bySKU;

    @BeforeEach
    public void setUp() {

        byName = Factory.createBinaryTree("name");
        bySKU = Factory.createBinaryTree("sku");

        Products p1 = new Products(123, "Jersey", "Playera de tela", "s:10");
        Products p2 = new Products(456, "Chumpa", "Chumpa ligera", "m:20");
        Products p3 = new Products(789, "Pantalón", "Pantalón deportivo", "l:15");

        byName.insert("Jersey", p1);
        byName.insert("Chumpa", p2);
        byName.insert("Pantalón", p3);

        bySKU.insert("123", p1);
        bySKU.insert("456", p2);
        bySKU.insert("789", p3);
    }

    @Test
    public void testSearchBySKU() {
        Products product = bySKU.search("123");
        assertNotNull(product, "Debería encontrar el producto con SKU 123");
        assertEquals("Jersey", product.getName(), "El nombre del producto con SKU 123 debería ser Jersey");

        assertNull(bySKU.search("999"), "Debería devolver null para un SKU no existente");
    }

    @Test
    public void testSearchByName() {
        Products product = byName.search("Chumpa");
        assertNotNull(product, "Debería encontrar el producto con nombre Chumpa");
        assertEquals(456, product.getSKU(), "El SKU del producto con nombre Chumpa debería ser 456");

        assertNull(byName.search("Zapatillas"), "Debería devolver null para un nombre no existente");
    }

    @Test
    public void testListByName() {
        List<String> expectedNames = List.of("Chumpa", "Jersey", "Pantalón");
        List<String> actualNames = new ArrayList<>();

        Iterator<String> nameIt = byName.iterator();
        while (nameIt.hasNext()) {
            String key = nameIt.next();
            actualNames.add(key);
        }

        assertEquals(expectedNames, actualNames, "El listado por nombre debería estar en orden alfabético");
    }

    @Test
    public void testListBySKU() {
        List<String> expectedSKUs = List.of("123", "456", "789");
        List<String> actualSKUs = new ArrayList<>();

        Iterator<String> skuIt = bySKU.iterator();
        while (skuIt.hasNext()) {
            String key = skuIt.next();
            actualSKUs.add(key);
        }

        assertEquals(expectedSKUs, actualSKUs, "El listado por SKU debería estar en orden numérico");
    }
}
