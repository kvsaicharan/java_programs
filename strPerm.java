class strPerm{

void permuation(String str){
	permuation(str,"");
}

void permuation(String str,String pref){
	
	if(str.length() == 0){
		System.out.print(pref);
	}
	
	else{
		for(int i=0;i<str.length();i++){
			String rem = str.substring(0,i) +  str.substring(i+1);
			permuation(rem,pref+str.charAt(i));
			
		}
	}
}

public static void main(String args[]){
	String str = "sai";
	strPerm perm = new strPerm();
	perm.permuation(str);
}
}
