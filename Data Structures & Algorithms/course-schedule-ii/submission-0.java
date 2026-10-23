class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] dep = new int[numCourses];

        List<List<Integer>> comp = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            comp.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            dep[prerequisites[i][0]]++;
            comp.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (dep[i] == 0) {
                s.push(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!s.isEmpty()) {
            int val = s.pop();
            result[index++] = val;
            for (int o : comp.get(val)) {
                dep[o]--;
                if (dep[o] == 0) {
                    s.push(o);
                }
            }
        }
        if (index != numCourses) {
    return new int[0];
}

        return result;
    }
}
