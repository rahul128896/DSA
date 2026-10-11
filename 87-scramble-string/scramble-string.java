class Solution {
    static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
    public boolean isScramble(String S1, String S2) {
        
        if (S1.length() != S2.length()) {
            return false;
        }
   
        int n = S1.length();
   
       
        if (n == 0) {
            return true;
        }
   
       
        if (S1.equals(S2)) {
            return true;
        }
       
        String copy_S1 = S1, copy_S2 = S2;
        char[] t1 = copy_S1.toCharArray();
        char[] t2 = copy_S2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        copy_S1 = new String(t1);
        copy_S2 = new String(t2);
   
        if (!copy_S1.equals(copy_S2)) {
            return false;
        }
   
       
        String key = (S1 + " " + S2);
               if (mp.containsKey(key)) {
            return mp.get(key);
        }
   
        
        boolean flag = false;
   
        for (int i = 1; i < n; i++) {
   
           
            if (isScramble(S1.substring(0, i), S2.substring(0, i))
                && isScramble(S1.substring(i, n), S2.substring(i, n))) {
                flag = true;
                 mp.put(key, flag);
                return true;
            }

            if (isScramble(S1.substring(0, i), S2.substring(n - i, n))
                && isScramble(S1.substring(i, n),
                              S2.substring(0, n - i))) {
                flag = true;
                  mp.put(key, flag); 
                return true;
            }
        }
   
        mp.put(key, flag);
   
        
        return false;
    }
}