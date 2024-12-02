// Quick Sort

public class Solution {
    private int partition(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        swap(nums, mid, left + 1);
        
        if (nums[left] > nums[right]) 
            swap(nums, left, right);
        if (nums[left + 1] > nums[right]) 
            swap(nums, left + 1, right);
        if (nums[left] > nums[left + 1]) 
            swap(nums, left, left + 1);
        
        int pivot = nums[left + 1];
        int i = left + 1;
        int j = right;
        
        while (true) {
            while (nums[++i] < pivot);
            while (nums[--j] > pivot);
            if (i > j) break;
            swap(nums, i, j);
        }
        
        nums[left + 1] = nums[j];
        nums[j] = pivot;
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (right <= left + 1) {
            if (right == left + 1 && nums[right] < nums[left])
                swap(nums, left, right);
            return;
        }
        
        int j = partition(nums, left, right);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}


//Merge Sort

public class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = l;
        int j = m + 1;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }


        while (i <= m) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= r) {
            temp.add(arr[j]);
            j++;
        }

        for (i = l; i <= r; i++) {
            arr[i] = temp.get(i - l);
        }
    }
}

