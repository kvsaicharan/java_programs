class zeroNonZero{
  public static void main(String[] args) {
    int[] arr = {1,8,0,9,7,8,9,0,0,7,6};
    int[] arr1 = arr;
    int n = arr1.length-1;
    int count = 0;
    for(int i=0;i<arr.length;i++){
        if(arr[i] != 0) arr[count++] = arr[i];
    }
    while(count<arr.length) arr[count++] = 0;
    for (int a: arr)
    System.out.print(a+" ");

    for(int i=arr.length-1;i>=0;i--){
      if(arr[i] != 0) arr[n--] = arr[i];
    }
  while(n>=0) arr[n--] = 0;
  System.out.print("\n");
  for (int a : arr1)
  System.out.print(a +" ");
}
}
