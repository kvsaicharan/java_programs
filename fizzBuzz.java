public class fizzBuzz{
  public static void main(String[] args){
    for (int n=1;n<100;n++){
      if(n%28 == 0) {System.out.println("FIZZBUZZ"); continue;}
      else if(n % 7 == 0) {System.out.println("FIZZ"); continue;}
      else if(n % 4 == 0) {System.out.println("BUZZ"); continue;}
      else System.out.println(String.valueOf(n));

    }
  }

}
