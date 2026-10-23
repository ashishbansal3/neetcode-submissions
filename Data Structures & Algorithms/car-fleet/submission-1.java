class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> remaining_distance = new ArrayList<>();
        double[] pending = new double[position.length];

        for(int i=0;i<position.length;i++){
            remaining_distance.add(new int[]{target-position[i],speed[i]});
        }
        remaining_distance.sort((a,b) -> a[0]-b[0]);
        double max = 0.0;
        int fleet = 0;
        for(int i=0;i<position.length;i++){
            double val = (double) remaining_distance.get(i)[0] / remaining_distance.get(i)[1];

            if(val>max){
                fleet++;
                max= val;
            }
        }
        return fleet;
        
    }
}
