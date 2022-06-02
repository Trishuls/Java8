public class ArraySubset {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};

        for (int i=0; i<arr.length; i++) {
            int sum = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                sum+=arr[j];
                if (sum == 12) {
                    System.out.println(sum+" -> ("+i+","+j+")");
                }
            }
        }
    }
}
