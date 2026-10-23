class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Map<Integer, Integer> track = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            
            if(track.containsKey(nums[i])) return true;
            track.put(nums[i], track.getOrDefault(nums[i], 0)+1 );
        }
        return false;
    }
}