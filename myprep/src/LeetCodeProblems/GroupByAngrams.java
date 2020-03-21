class GroupByAngrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap();
        
        for (String str : strs) 
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            List<String> s = map.getOrDefault(key, new ArrayList());
            s.add(str);
            map.put(key, s);
        }
        
        List<List<String>> result = new ArrayList();
        
        map.forEach((key, value) -> {
            result.add(value);
        }); 
        
        return result;
    }
}
