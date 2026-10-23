class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> map = new HashMap<>();

        if(s.length()!=t.length()) return false;

        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c:t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for(Map.Entry<Character,Integer> a: map.entrySet()){
            if (a.getValue()!=0) return false;
        }

    return true;

    }
}
