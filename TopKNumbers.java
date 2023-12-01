import java.util.Scanner;

public class TopKNumbers {

    private static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            System.out.print("Enter the array elements: ");
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            System.out.print("Enter the value of K: ");
            int k = scanner.nextInt();

            findTopKNumbers(k);

            System.out.print("Do you wish to continue (yes or no)? ");
            String continueInput = scanner.next().toLowerCase();

            if (continueInput.equals("no")) {
                System.out.println("Thank you!");
                break;
            }

        } while (true);

        scanner.close();
    }

    public static void findTopKNumbers(int k) {
        int[] frequency = new int[1001]; 

        for (int num : numbers) {
            frequency[num]++;
        }

        System.out.print("Output: ");
        for (int i = 0; i < k; i++) {
            int maxFrequency = -1;
            int maxIndex = -1;

            for (int j = 1; j < frequency.length; j++) {
                if (frequency[j] > maxFrequency) {
                    maxFrequency = frequency[j];
                    maxIndex = j;
                }
            }

            System.out.print(maxIndex + " ");
            frequency[maxIndex] = -1;
        }
        System.out.println();
    }
}