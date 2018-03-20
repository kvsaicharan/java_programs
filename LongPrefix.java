class LongPrefix{

  private String commonPrefix(String s1, String s2){
    StringBuilder sb = new StringBuilder("");
    int n = Math.min(s1.length(),s2.length());
    for(int i=0; i<n; i++){
      if(s1.charAt(i) != s2.charAt(i)) break;
      sb.append(s1.charAt(i));
    }
    return sb.toString();
  }

  private String dpmethod(String[] array, int low, int high){

    if(low == high) return (array[low]);

    else{
      int mid = low + (high-low)/2;
      String s1 = dpmethod(array,low,mid);
      String s2 = dpmethod(array,mid+1,high);
      return commonPrefix(s1,s2);
  }
}

  public static void main(String[] args) {
    LongPrefix obj = new LongPrefix();
    String[] arr = {"Saicharan","Saisantosh","Saidharm","Sainag"};
    int n = arr.length;
    String res = obj.dpmethod(arr,0,n-1);
    System.out.println(res);
  }
}
