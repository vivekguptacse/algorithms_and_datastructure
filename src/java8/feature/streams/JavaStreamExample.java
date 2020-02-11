package java8.feature.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product
{
	int id;
	String name;
	float price;

	public Product(int id, String name, float price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public float getPrice()
	{
		return price;
	}

	@Override
	public String toString()
	{
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}
}
    
public class JavaStreamExample
{
	 public static void main(String[] args)
	{
		 List<Product> createProductList = createProductList();
		 System.out.println("****************** Example 1 *******************");
		 // Example 1 : Filtering Collection without using Stream
		 filterWithoutStream(createProductList);
		 System.out.println("****************** Example 2 *******************");
		 // Example 2: Filtering Collection by using Stream
		 filterWithStream(createProductList);
		 System.out.println("****************** Example 3 *******************");
		 // Example 3 : Stream Iterating Example
		 streamIteratingExample();
		 System.out.println("****************** Example 4 *******************");
		// Example 4 : Filtering and Iterating Collection
		 streamFilteringAndIterating(createProductList);
		 System.out.println("****************** Example 5 *******************");
		// Example 5 : reduce() Method in Collection
		 reduceMethodWithStream(createProductList);
		 System.out.println("****************** Example 6 *******************");
		 // Example 6 : Sum by using Collectors Methods
		 sumWithCollectorsMethod(createProductList);
		 System.out.println("****************** Example 7 *******************");
		 //Example 7 ; Find Max and Min Product Price
		 findMinMaxmethod(createProductList);
		System.out.println("****************** Example 8 *******************");
		// Example 8 : count() Method in Collection
		countMethodexample(createProductList);

		// stream allows you to collect your result in any various forms. You
		// can get you result as set, list or map and can perform manipulation
		// on the elements.
		// Example 9 : Convert List into Set
		System.out.println("****************** Example 9 *******************");
		convertToSet(createProductList);
		System.out.println("****************** Example 10 *******************");
		// Example 10 : Convert List into Map
		convertListTomap(createProductList);
		System.out.println("****************** Example 11 *******************");
		// Example 11 : Method Reference in stream
		methodreferencesInStreams(createProductList);
		 
	}

	 private static void methodreferencesInStreams(
			List<Product> createProductList)
	{
		 List<Float> collect = createProductList.stream()
		 .filter(product -> product.price < 30000)  // filtering dat
		 .map(Product::getPrice) // fetching price by referring getPrice method
		 .collect(Collectors.toList()); // collecting as list 
		 
		 System.out.println(collect);
	}

	/**
	  * Convert List to map. 
	  * 
	  * @param createProductList
	  */
	 private static void convertListTomap(List<Product> createProductList)
	{
		Map<Integer, String> collect = createProductList.stream()
				.collect(Collectors.toMap(product -> product.id,
						product -> product.name));

		System.out.println(collect);

	}

	 /**
	  * Convert list to Set using Streams 
	  * 
	  * @param createProductList
	  */
	private static void convertToSet(List<Product> createProductList)
	{
		 Set<Float> collect = createProductList.stream()
		 .filter(product -> product.price <30000)
		 .map(product -> product.price)
		 .collect(Collectors.toSet());
		 
		 System.out.println(collect);
	}

	/**
	  *  Counts the Elements.
	  *  
	  * @param createProductList
	  */
	private static void countMethodexample(List<Product> createProductList)
	{
		long count = createProductList.stream()
		.filter(product -> product.price < 30000)
		.count();
		
		System.out.println(count);
	}

	/**
	 * This example finds min and max product price by using stream. It provides
	 * convenient way to find values without using imperative approach.
	 * 
	 * @param createProductList
	 */
	private static void findMinMaxmethod(List<Product> createProductList)
	{
		Product product = createProductList.stream()
				.min((product1,product2) -> product1.price < product2.price ? -1:1)
				.get();
		System.out.println(product.price);
		
		Product product2 = createProductList.stream()
				.max((p1,p2) -> p1.price > p2.price ? 1 : -1)
				.get();
				
		System.out.println(product2.price);
		
	}

	/**
	 * We can also use collectors to compute sum of numeric values. In the
	 * following example, we are using Collectors class and it?s specified
	 * methods to compute sum of all the product prices.
	 * 
	 * @param createProductList
	 */
	private static void sumWithCollectorsMethod(List<Product> createProductList)
	{
		Double collect = createProductList.stream()
				.collect(Collectors.summingDouble(product -> product.price));
		System.out.println(collect);

	}

	/**
	 * This method takes a sequence of input elements and combines them into a
	 * single summary result by repeated operation. For example, finding the sum
	 * of numbers, or accumulating elements into a list.
	 * 
	 * In the following example, we are using reduce() method, which is used to
	 * sum of all the product prices.
	 * 
	 * @param createProductList
	 */
	private static void reduceMethodWithStream(List<Product> createProductList)
	{
		// This is more compact approach for filtering data
		Float reduce = createProductList.stream()
				.map((product) -> product.price)
				.reduce(0.0f, (sum, productprice) -> sum + productprice); // accumulating price  
		System.out.println(reduce);
		
		// More Precise code
		Float reduce2 = createProductList.stream()
		.map(product -> product.price)
		.reduce(0.0f, Float::sum);  // accumulating price, by referring method of Float class  

		System.out.println(reduce2);
	}

	private static void streamFilteringAndIterating(
			List<Product> createProductList)
	{
		// This is more compact approach for filtering data
		createProductList.stream().filter(product -> product.price == 30000)
				.forEach((product) -> System.out.println(product.name));

	}

	/**
	 * We use stream to iterate any number of times. Stream provides predefined
	 * methods to deal with the logic you implement. In the following example,
	 * we are iterating, filtering and passed a limit to fix the iteration.
	 */
	private static void streamIteratingExample()
	{
		Stream.iterate(1, element -> element + 1)
				.filter(element -> element % 5 == 0)
				.limit(5)
				.forEach(System.out::println);
	}

	/**
	 * we are filtering data by using stream. You can see that code is optimized
	 * and maintained. Stream provides fast execution
	 * 
	 * @param createProductList
	 */
	private static void filterWithStream(List<Product> createProductList)
	{
		List<Float> collect = createProductList.stream()
			.filter((product) -> product.price < 30000 ) // filter data 
			.map((product)-> product.price)  // fetching price 
			.collect(Collectors.toList()); // collecting as list
		System.out.println(collect);
	}

	/**
	 * we are filtering data without using stream. This approach we are used
	 * before the stream package was released.
	 * 
	 * @param createProductList
	 */
	private static void filterWithoutStream(List<Product> createProductList)
	{
		List<Float> productPriceList = new ArrayList<Float>();
		for (Product product : createProductList)
		{
			// filtering data of list
			if (product.price < 30000)
			{
				productPriceList.add(product.price); // adding price to a
														// productPriceList
			}
		}
		System.out.println(productPriceList); // displaying data
	}

	private static List<Product> createProductList()
	{
		List<Product> productsList = new ArrayList<Product>();  
	     //Adding Products
		 productsList.add(new Product(1,"HP Laptop",25000f));
	     productsList.add(new Product(2,"Dell Laptop",30000f));  
	     productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	     productsList.add(new Product(4,"Sony Laptop",28000f));  
	     productsList.add(new Product(5,"Apple Laptop",90000f));
	     
	     return productsList;
	}

}
