package filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Product{
    String name;
    double price;
    boolean inStock;

    public Product(String name, double price, boolean inStock){
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString(){
        String ans = "Product Name: " + name +", " + "Product Price: " + price + ", " + "Is it in stock?: ";
        if(inStock){
            ans += "Yes";
        }
        else{
            ans += "No";
        }

        return ans;
    }

    public static void main(String[] args){
        List<Product> inventory = new ArrayList<>();
        inventory.add(new Product("Mechanical Keyboard", 45.00, true));
        inventory.add(new Product("Gaming Mouse", 60.00, true));
        inventory.add(new Product("USB-C Cable", 15.00, false)); 
        inventory.add(new Product("Webcam", 30.00, true));             
        inventory.add(new Product("Monitor", 150.00, false));

        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        inventory.removeIf(isAffordable.negate());

        System.out.println("Affordable Items:");
        inventory.forEach(System.out::println);
    }
}