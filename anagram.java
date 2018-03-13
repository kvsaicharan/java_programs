import java.util.*;

class anagram{

	public boolean bySorting(String a, String b){
		String s1 = a.replaceAll("\\s","");
		char[] ch1 = s1.toCharArray();
		String s2 = b.replaceAll("\\s","");
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		return Arrays.equals(ch1,ch2);
	}

	public boolean byBrute(String a, String b){
		String s1 = a.replaceAll("\\s","");
		String s2 = b.replaceAll("\\s","");
		for(int i=0; i<s1.length();i++){
			if(s2.indexOf(s1.charAt(i)) == -1)
			return false;
		}
		return true;
	}

	public boolean byHash(String a, String b){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<a.length();i++){
			char ch = a.charAt(i);
		if(!map.containsKey(ch))
			map.put(ch,1);
		else{
		int j  = map.get(ch);
			map.put(ch,++j);
		}
	}
	for(int i=0; i<b.length();i++){
		char ch1 = b.charAt(i);
		if(!map.containsKey(ch1))
			return false;
		else{
		int j  = map.get(ch1);
			map.put(ch1,--j);
		}
	}
	for(int v : map.values())
		if(v != 0) return false;

		return true;
	}


	public static void main(String[] args){
		anagram obj = new anagram();
		String str1 = "sai charan";
		String str2 = "charan sai";
		if(str1.length() != str2.length())
		System.out.println(false);
		else{
		//boolean res = obj.bySorting(str1,str2);
		//boolean res1 = obj.byBrute(str1,str2);
		boolean res2 = obj.byHash(str1,str2);
		System.out.println("method "+ res2);
	}
	}
}
