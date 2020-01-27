import java.util.ArrayList;
import java.util.Scanner;

public class HeapArrays
{
	final static long MB=1024*1024;

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String temp=null;

		System.out.println("Max int: " + Integer.MAX_VALUE);

		showMemStats();

		int size=(int)MB*40;

		System.out.println("SIZE: " + size*4);
		int[] a = new int[size];

		showMemStats();

		System.out.println("Press return...");
		temp = s.nextLine();

		size=(int)MB*20;

		System.out.println("SIZE: " + size*4);
		int[] b = new int[size];

		showMemStats();

		System.out.println("Press return...");
		temp = s.nextLine();

		size=(int)MB*20;

		System.out.println("SIZE: " + size*4);
		int[] c = new int[size];

		showMemStats();

		System.out.println("Press return...");
		temp = s.nextLine();
	}

	private static void showMemStats()
	{
		Runtime rt = Runtime.getRuntime();

		long max = rt.maxMemory()/MB;

		System.out.println("max: " + max);

		long total = rt.totalMemory()/MB;

		System.out.println("total: " + total);

		long free = rt.freeMemory()/MB;

		System.out.println("free: " + free);

		long used = total - free;

		System.out.println("used: " + used); 

		long available = max - total + free;

		System.out.println("Available: " + available);

		System.out.println();
	}
}
