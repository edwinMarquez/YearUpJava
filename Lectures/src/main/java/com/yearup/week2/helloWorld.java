public class helloWorld {
  public static void main(String[] args) {
	//prints Hello world in command line.
	if(args.length>0){
	System.out.println("Hi from");
	System.out.println(args[0]);
	System.out.println("How are you?");}
	else {
		System.out.println("Please run the command with arguments");
	}
  }
}
