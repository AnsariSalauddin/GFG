package StringQ.Striver;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutNonRepeating {
    public static int longrstSubStringWithoutNonRepeating(String str) {
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (hash.containsKey(ch) && hash.get(ch) >= left) {
                left = hash.get(ch) + 1;
            }
            hash.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static String longestSubStringWithoutNonRepeating11(String str) {
        int left = 0;
        int start = 0;
        int maxLen = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (hash.containsKey(ch) && hash.get(ch) >= left) {
                left = hash.get(ch) + 1;
            }
            hash.put(ch, right);
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }
        }
        return str.substring(start, start + maxLen);
    }

    //brute force
    public static String longestSubStringWithoutNonRepeating12(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                if (unique(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    public static boolean unique(String str) {
        boolean[] hash = new boolean[256];
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            if (hash[ch]) return false;
            hash[ch] = true;
        }
        return true;
    }

    //LongestSubStringWithoutNotRepeatingElement using hashSet

    public static String longestSubStringUsingHashSet(String str){
        int left=0;
        int maxLen=0;
        int start=0;
        HashSet<Character> res=new HashSet<>();
        for (int i=0; i<str.length(); i++){
            while (res.contains(str.charAt(i))){
                res.remove(str.charAt(left));
                left++;
            }
            res.add(str.charAt(i));
            if(i-left+1>maxLen){
                maxLen=i-left+1;
                start=left;
            }
        }
        return str.substring(start,start+maxLen);
    }


    public static void main(String[] args) {
        String str = "bacdefab";
//        int i = longrstSubStringWithoutNonRepeating(str);
//        System.out.println(i);
//        String s = longestSubStringWithoutNonRepeating11(str);
//        System.out.println(s);
        String s = longestSubStringWithoutNonRepeating12(str);
        System.out.println(s);
        String s1 = longestSubStringUsingHashSet(str);
        System.out.println(s1);

    }
}
