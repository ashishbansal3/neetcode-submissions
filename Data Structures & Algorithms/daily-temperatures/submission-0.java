class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] result = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            while(!q.isEmpty()&&q.peek()[0]<temperatures[i]){
                result[q.peek()[1]] = i - q.peek()[1];
                q.poll();
            }
            q.add(new int[]{temperatures[i],i});
        } 
        return result;
        
    }
}
