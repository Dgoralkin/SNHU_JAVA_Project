
public class tst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Monkey monk = new Monkey();
		
		monk.setTailLength("10");
		monk.setHeight("12");
		monk.setBodyLength("11");
		monk.setSpecies("13");

		monk.getTailLength();
		monk.getHeight();
		monk.getBodyLength();
		monk.getSpecies();
		
		
		System.out.println(monk.getTailLength() + monk.getHeight() + 
				monk.getBodyLength() + monk.getSpecies());
	}
	

}
