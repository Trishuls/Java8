import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistinctElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,2,2,4,5,7,7,7);
        Integer l = list.stream().distinct().map(i -> i * 2).reduce(5, Integer::sum);
        List<Integer> a = list.stream().distinct().filter(i -> i > 4).collect(Collectors.toList());
        System.out.println(l);
        System.out.println(a);

        List<Product> productsList = new ArrayList<Product>();

        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        productsList.stream().collect(Collectors.toMap(product -> product.id, product -> product.name)).forEach((integer, s) -> System.out.println(integer+s));

        String str = "JJJJJM";

        str.chars().mapToObj(c -> Character.toLowerCase((char) c)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        List<Integer> il = Arrays.asList(1,2,3,-1,-9);
        List<String> sl = il.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(sl);

        Optional<Integer> sum = il.stream().reduce(Integer::max);

        sum.ifPresent(System.out::println);

        //max
        List<String> max = Arrays.asList("G", "E", "E", "K",
                "g", "e", "e", "k");
        Integer ans = il.stream().max(Integer::compare).get();
        Integer revMax = il.stream().max(Comparator.reverseOrder()).get();
        max.stream().max(Comparator.comparing(String::valueOf));

        System.out.println(ans);
        System.out.println(revMax);

        int[] ints = {1,5,4,11,2,6};
        il.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println(Arrays.stream(ints).max().getAsInt());
    }
}
class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}