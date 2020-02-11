package java8.feature.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

interface Sayable {
	
	public void say(String message);
}

interface Drawable
{
	public void draw();
}

interface Addable
{
	public int add(int a, int b);
}
public class LambdaExample
{
	public static void main(String[] args)
	{
		int width = 10;

		// ************* 1 *******************************
		System.out.println("************* 1 *******************************");
		Drawable d = () ->
		{
			System.out.println("Drwaing " + width);
		};
		d.draw();

		// ************* 2 *******************************
		System.out.println("************* 2 *******************************");
		Sayable say = (msg) ->
		{
			System.out.println("I have this msg to Say : " + msg);
		};

		say.say("Keep Moving !!!");

		// ************* 3 *******************************

		// Java Lambda Expression Example: Multiple Parameters
		System.out.println("************* 3 *******************************");
		Addable addable1 = (a, b) ->
		{
			return a + b;
		};

		System.out.println(addable1.add(3, 6));
		// ************* 4 *******************************
		// Java Lambda Expression Example: with or without return keyword
		System.out.println("************* 4 *******************************");
		Addable addable = (a, b) -> a + b;
		System.out.println(addable.add(3, 2));

		// ************* 5 *******************************
		// Java Lambda Expression Example: Foreach Loop
		System.out.println("************* 5 *******************************");
		List<String> list = new ArrayList<>();
		list.add("Vivek");
		list.add("Rahul");
		list.add("Prashant");
		list.add("Manish");
		list.add("Pankaj");

		list.forEach((name) -> System.out.println(name));

		// ************* 6 *******************************
		// Java Lambda Expression Example: Multiple Statements
		System.out.println("************* 6 *******************************");
		Sayable sayMessage = (msg) ->
		{
			String msg1 = "I want to say that, ";
			msg1 = msg1 + msg;
			System.out.println(msg1);
		};

		sayMessage.say("Hello Bangalore");
		// ************* 7 *******************************
		// Java Lambda Expression Example: Creating Thread
		System.out.println("************* 7 *******************************");
		Runnable r = () ->
		{
			System.out.println("Started New thread");
		};

		Thread t = new Thread(r);
		t.start();
		// ************* 8 *******************************
		// Java Lambda Expression Example: Comparator
		System.out.println("************* 8 *******************************");

		Collections.sort(list, (name1, name2) ->
		{
			return name1.compareTo(name2);
		});

		list.forEach((name) -> System.out.println(name));
		
		// ************* 9 *******************************
		// Java Lambda Expression Example: Filter Collection Data
		System.out.println("************* 9 *******************************");
		List<Product> list1=new ArrayList<Product>();  
		list1.add(new Product(1,"Samsung A5",17000f));  
		list1.add(new Product(3,"Iphone 6S",65000f));  
		list1.add(new Product(2,"Sony Xperia",25000f));  
		list1.add(new Product(4,"Nokia Lumia",15000f));  
		list1.add(new Product(5,"Redmi4 ",26000f));  
		list1.add(new Product(6,"Lenevo Vibe",19000f));  
		
		Stream<Product> filter = list1.stream().filter((Product name)-> name.name.startsWith("S"));
		filter.forEach((name)-> System.out.println(name.name));
		

	}
	
	static class Product
	{
		int id;
		String name;
		float price;

		public Product(int id, String name, float price)
		{
			super();
			this.id = id;
			this.name = name;
			this.price = price;
		}
	}
	

}
