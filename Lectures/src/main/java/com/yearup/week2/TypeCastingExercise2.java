class TypeCastingExercise2
{
public static void main(String[] args)
{
//Snippet 1
double power = Math.pow(3, 2);
System.out.println(power); //pow (3,2) = 3 * 3;
//Snippet 2
int exp = (int)Math.pow(3, 2); //Explicit casting 
System.out.println(exp);
}
}