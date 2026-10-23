class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num:nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        
        for(Map.Entry<Integer,Integer> map:count.entrySet()){
            // list.add(new int[]{map.getValue(),map.getKey()});
            q.add(new int[]{map.getKey(),map.getValue()});
        }

        // list.sort((a,b)-> b[0]-a[0]);

        int[] result = new int[k];

        for(int i=0;i<k;i++){
            result[i] = q.poll()[0];
        }    
    return result;
    }
}
