class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        int mid=0;

        for(int i:piles){
            max= Math.max(max,i);
        }
        
        int result = max;
        while(min<=max){
            mid = (min + max)/2;
            int time=0;

            for(int b:piles){
                int x =(int) Math.ceil ((double)b / mid);
                time = time+ x;
            }
            if(time>h){
                min=mid+1;
            }
            else{
                max=mid-1;
                result=mid;
            }

        }
        
        return result;
    }
}
