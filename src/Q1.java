import java.util.ArrayList;
import java.util.List;

class Products {
    private String name;
    private String category;
    private int price;
    private int stock;

    public Products(String name, String category, int price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}

public class Q1 {
    public static void main(String[] args) {
        List<Products> categories = new ArrayList<>();

        categories.add(new Products("Products 1", "Category 1", 1000, 5));
        categories.add(new Products("Products 2", "Category 2", 2000, 3));
        categories.add(new Products("Products 3", "Category 1", 1500, 2));
        categories.add(new Products("Products 4", "Category 2", 2500, 4));
        categories.add(new Products("Products 5", "Category 1", 1800, 6));

        List<String> stream =  categories.stream()
                .filter(x -> x.getStock() > 0)
                .filter(price -> price.getPrice() > 1000)
                .map(Products::getName)
                .toList();

        System.out.println(stream);
    }
}