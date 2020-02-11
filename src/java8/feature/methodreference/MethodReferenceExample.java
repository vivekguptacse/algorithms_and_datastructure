package java8.feature.methodreference;

import java.util.function.BiFunction;

interface Sayable
{
	public void say();
}

class Message
{
	Message(String msg)
	{
		System.out.print(msg);
	}
}

interface Messageable
{
	Message getMessage(String msg);
}

class Arithmetic
{
	public static int add(int a, int b)
	{
		return a + b;
	}

	public static float add(int a, float b)
	{
		return a + b;
	}

	public static float add(float a, float b)
	{
		return a + b;
	}
	
	public int addNum(int a, int b)
	{
		return a+b;
	}
}

public class MethodReferenceExample
{
	public static void getMessage()
	{
		System.out.println("Jao tumhara bhala ho. ");
	}
	
	public void saySomething()
	{
		System.out.println("Lo Bol diya aur kuch bolun !!! ");
	}
	
	public static void threadStatus()
	{
		System.out.println("Thread is Running ... ");
	}
	
	public static int add(int a, int b)
	{
		return a+b;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		staticMethodReference();
		
		instanceMethodReference();
		
		
		constructoreMethodReference();
		

	}

	private static void constructoreMethodReference()
	{
		// Reference to a Constructor
		
		// You can refer a constructor by using the new keyword. Here, we are referring constructor with the help of functional interface.
		
		Messageable msg = Message::new;
		msg.getMessage("Hello World");
		
		
	}

	private static void instanceMethodReference() throws InterruptedException
	{
		// Reference to an Instance Method
		// Example 1  -- In the following example, we are referring non-static methods. You can refer methods by class object and anonymous object.
		
		System.out.println("*************************** Instance Method Reference Example 1 *************");
		
		MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
		// Referring non-static method using reference  
		Sayable sayable = methodReferenceExample::saySomething;
		// Calling interface method  
		sayable.say();
		
		 // Referring non-static method using anonymous object  
		Sayable sayable2 = new MethodReferenceExample()::saySomething;
		// Calling interface method 
		sayable2.say();
		
		// 

		// Example 2 --I n the following example, we are referring instance (non-static) method. Runnable interface contains only one abstract method. So, we can use it as functional interface.
		System.out.println("*************************** Instance Method Reference Example 2 *************");
		
		Thread thread = new Thread(new MethodReferenceExample()::saySomething);
		thread.start();
		Thread.sleep(1000);
		// Example 3 -- In the following example, we are using BiFunction interface. It is a predefined interface and contains a functional method apply(). Here, we are referring add method to apply method.
		System.out.println("*************************** Instance Method Reference Example 3 *************");
		BiFunction<Integer, Integer, Integer> adder = new Arithmetic()::addNum;
		System.out.println(adder.apply(25, 45));
		
		
		
	}

	private static void staticMethodReference() throws InterruptedException
	{
		// Reference to a Static Method

		// Example 1 -- In the following example, we have defined a functional
		// interface and referring a static method to it's functional method
		// say().
		System.out.println(
				"*********************************Example 1 *************");
		Sayable sayable = MethodReferenceExample::getMessage;
		sayable.say();

		// Example 2 -- In the following example, we are using predefined
		// functional interface Runnable to refer static method.
		System.out.println(
				"*********************************Example 2 *************");

		Thread t1 = new Thread(MethodReferenceExample::threadStatus);
		t1.start();

		Thread.sleep(1000);

		// Example 3 -- You can also use predefined functional interface to
		// refer methods. In the following example, we are using BiFunction
		// interface and using it's apply() method.
		System.out.println(
				"*********************************Example 3 *************");
		BiFunction<Integer, Integer, Integer> adder = MethodReferenceExample::add;
		int result = adder.apply(20, 10);
		System.out.println(result);

		// Example 4 -- You can also override static methods by referring
		// methods. In the following example, we have defined and overloaded
		// three add methods.
		System.out.println(
				"*********************************Example 4 *************");
		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
		BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
		BiFunction<Float, Float, Float> adder3 = Arithmetic::add;

		System.out.println(adder1.apply(13, 17));
		System.out.println(adder2.apply(10, 20f));
		System.out.println(adder3.apply(10f, 50f));
	}
	
}
