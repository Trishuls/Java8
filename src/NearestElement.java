public class NearestElement {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,8};
        System.out.println(findClosest(arr,4));
    }

    private static int findClosest(int[] arr, int target) {

        int n = arr.length;
        if (target < arr[0])
            return arr[0];
        if (target > arr[n-1])
            return arr[n-1];

        int i=0,j=n,mid=0;

        while (i<j){
            mid=(i+j)/2;
            if (target == arr[mid])
                return arr[mid];
            if (target<arr[mid]) {
                if (mid>0 && target>arr[mid-1])
                    return getClosest(arr[mid-1],arr[mid],target);
                j=mid;
            }
            else {
                if (mid<0 && target<arr[mid+1])
                    return getClosest(arr[mid],arr[mid+1],target);
                i=mid+1;
            }
        }
        return arr[mid];
    }

    private static int getClosest(int i, int i1, int target) {
        if (target - i >= i1 - target)
            return i1;
        else
            return i;
    }
}
