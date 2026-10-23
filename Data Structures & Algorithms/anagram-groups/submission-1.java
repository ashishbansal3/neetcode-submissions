class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            int[] i = new int[26];
            for(char c:s.toCharArray()){
                i[c-'a']++;
            }

            StringBuilder so = new StringBuilder();
            
            for(int a:i){
                so.append(a).append("#");
                
            }
            String fs = so.toString();

map.putIfAbsent(fs.toString(), new ArrayList<>());
map.get(fs).add(s);

        }
        List<List<String>> result =new ArrayList<>();
for(Map.Entry<String,List<String>> mp: map.entrySet()){
result.add(mp.getValue());
}
return result;

        
    }
}
