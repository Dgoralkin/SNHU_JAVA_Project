// Daniel Gorelkin - Feb/23/2024

public class Monkey extends RescueAnimal{
	
	// Instance variable
	private String tailLength, height, bodyLength, monkeySpecies;
	
    // Constructor
    public Monkey() {
    }
	
    // Constructor
    public Monkey(String name, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry,
	String tailLength, String monkeyHeight, String bodyLength,
	String monkeySpecies) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(monkeyHeight);
        setBodyLength(bodyLength);
        setSpecies(monkeySpecies);
        // setAnimalType(animalType);
    }
	
    // Sets monkey's tail length
    public void setTailLength(String lengthOfTail) {
    	tailLength = lengthOfTail;
    }
    
    // Gets monkey's tail length
    public String getTailLength() {
    	return tailLength;
    }
    
    // Sets monkey's Height
    public void setHeight(String monkeyHeight) {
    	height = monkeyHeight;
    }
    
    // Gets monkey's body height
    public String getHeight() {
    	return height;
    }
    
    // Sets monkey's Body Length
    public void setBodyLength(String lengthOfBody) {
    	bodyLength = lengthOfBody;
    }
    
    // Gets monkey's body length
    public String getBodyLength() {
    	return bodyLength;
    }
    
    // Sets monkey's species.
    public void setSpecies(String species) {
    	monkeySpecies = species;
    }
    
    // Gets monkey's species
    public String getSpecies() {
    	return monkeySpecies;
    }   
}



