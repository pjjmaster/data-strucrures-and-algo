package com.practice.google;

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        /*PriorityQueue<Integer> heap = new PriorityQueue<>( (n1, n2) -> n1 - n2 );
        
        for(int num: nums) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.poll();
        **/
        StdRandom.shuffle(nums);
        int lo = 0;
        int hi = nums.length - 1;

        while(hi > lo) {
            int j = partition(nums, lo, hi);
            if(k < j) {
                hi = j - 1;
            } else if(k > j){
                lo = j + 1;
            } else {
                return nums[k];
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo + 1;
        int j = hi;

        while(true) {

            while(a[i] < a[lo]) {
                i++;
                if(i > hi) {
                    break;
                }
            }

            while(a[j] > a[lo]) {
                j--;
                if(j < lo) {
                    break;
                }
            }

            if(j < i) {
                break;
            }

            //exchange
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        //exchange the 
        int temp = a[j];
        a[j] = a[lo];
        a[lo] = temp;
        return j;
    }
}
