
public class ArrayStudy 
{
	public static void main(String[] args)
	{
		ArrayStack<Integer> study = new ArrayStack<Integer>();
		
		study.push(5);
		study.push(16);
		study.push(4);
		study.push(12);
		study.push(10);
		study.push(141);
		study.push(60);
		study.push(22);
		study.push(18);
		study.push(52);
		study.push(39);
		study.push(148);
		
		study.printAll(study);
		
		//study.transfer(study);
		//study.printAll(study);
	}
}
