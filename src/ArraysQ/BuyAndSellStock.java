package ArraysQ;

public class BuyAndSellStock {
    public static int buyAndSellStock(int[] arr){
        int minPrice=arr[0];
        int profit=0;
        for (int i=0; i<arr.length; i++){
            int curProfit=arr[i]-minPrice;
           profit=Math.max(profit,curProfit);
           minPrice=Math.min(minPrice,arr[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
    int[] price={7,1,5,3,6,4};
        int i = buyAndSellStock(price);
        System.out.println(i);
    }
}
