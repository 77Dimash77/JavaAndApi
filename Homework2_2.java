//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.



import java.io.FileWriter;
import java.io.IOException;

public class Homework2_2 {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 1};
        bubbleSort(array, "log.txt");
    }

    public static void bubbleSort(int[] array, String logFileName) {
        int n = array.length;
        boolean swapped;

        try {
            FileWriter writer = new FileWriter(logFileName);

            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }

                writer.write("Iteration " + (i + 1) + ": ");
                for (int num : array) {
                    writer.write(num + " ");
                }
                writer.write("\n");

                if (!swapped) {
                    break;
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
