
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	public static int ARRAY_LENGTH = readN();;
	private static int[] array = new int[ARRAY_LENGTH];
	private static Random generator = new Random();

	// считываем размер массива с консоли
	public static int readN() {
		Scanner in = new Scanner(System.in);
		System.out.print("Input a size of array: ");
		return in.nextInt();
	}
	
	// заполняем случайными числами
	public static void init() {
		for (int i = 0; i < ARRAY_LENGTH; i++) {
			array[i] = generator.nextInt(10);
		}
	}

	// преобразование массива: четные справа, нечетные - слева
	public static void swapOddEven(int[] array, int n) {
		int left = 0, right = n-1 ;

		while (left < right) {
			while (array[left] % 2 == 0) {
				left++;
			}

			while (array[right] % 2 != 0 && left < right)
				right--;

			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;

			}

		}
	}
	
	// печать массива
	public static void printArray() {
		for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[ARRAY_LENGTH - 1]);
	}

	// сортируем массива
	public static void Sort() {
		int first = 0;
		int last = ARRAY_LENGTH - 1;
		swapOddEven(array,ARRAY_LENGTH);
		QuickSortingUp(first, last - odd(array));
		QuickSortingDown(last - odd(array) + 1, last );
		
	}

	// меняем местами элементы
	private static void Swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// считаем количество нечетных элементов
	public static int odd(int[] array) {
		int countOdd = 0;
		for (int i=0; i < ARRAY_LENGTH; i++  ) {
			if (array[i] % 2 != 0) {
				countOdd++;
			}
		}
			return countOdd;
	}

	// реализация сортировки по возрастанию четных чисел
	private static void QuickSortingUp(int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int middle = (i + j) / 2;
		while (i < j) {
			while ((i < middle) && (array[i] <= array[middle]))
				i++;
			while ((j > middle) && (array[middle] <= array[j]))
				j--;
			if (i < j) {
				Swap(i, j);
				if (i == middle)
					middle = j;
				else if (j == middle)
					middle = i;
			}
		}
		QuickSortingUp(start, middle);
		QuickSortingUp(middle + 1, end);
	}
	
	// реализация сортировки по убыванию нечетных чисел
	private static void QuickSortingDown(int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int middle = (i + j) / 2;
		while (i < j) {
			while ((i < middle) && (array[i] >= array[middle]))
				i++;
			while ((j > middle) && (array[middle] >= array[j]))
				j--;
			if (i < j) {
				Swap(i, j);
				if (i == middle)
					middle = j;
				else if (j == middle)
					middle = i;
			}
		}
		QuickSortingDown(start, middle);
		QuickSortingDown(middle + 1, end);
	}

	public static void main(String[] args) {
		init();
		printArray();
		Sort();
		printArray();
	}
}