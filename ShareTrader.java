import java.util.Scanner;

public class ShareTrader {

    private static int maxProfit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            // Input the number of stock prices
            System.out.print("Enter the number of stock prices: ");
            int n = scanner.nextInt();

            // Input the stock prices
            int[] prices = new int[n];
            System.out.print("Enter the stock prices separated by spaces: ");
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            findMaxProfit(prices);

            // Ask the user if they wish to continue
            System.out.print("Do you wish to continue (yes or no)? ");
            String continueInput = scanner.next().toLowerCase();

            if (continueInput.equals("no")) {
                System.out.println("Thank you!");
                break;
            }

        } while (true);

        scanner.close();
    }

    public static void findMaxProfit(int[] prices) {
        maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int profitFirstTransaction = findProfit(prices, 0, i);
            int profitSecondTransaction = findProfit(prices, i + 1, prices.length - 1);

            int totalProfit = profitFirstTransaction + profitSecondTransaction;
            maxProfit = Math.max(maxProfit, totalProfit);
        }

        System.out.println("Output: " + maxProfit);
    }

    private static int findProfit(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (prices[j] > prices[i]) {
                    int currentProfit = prices[j] - prices[i] + findProfit(prices, start, i - 1)
                            + findProfit(prices, j + 1, end);
                    profit = Math.max(profit, currentProfit);
                }
            }
        }

        return profit;
    }
}