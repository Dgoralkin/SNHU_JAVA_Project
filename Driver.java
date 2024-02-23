// Daniel Gorelkin - Feb/23/2024

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;

public class Driver {
	
	// Set ArrayList to store Dogs
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    
    // Set ArrayList to store Monkeys
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // Set Array monkeySpecies to store Monkey species
    private static ArrayList<String> monkeySpecies = new ArrayList<String>();
    
    // Set Array dogTrainingStatus to store dog's training state.
    private static ArrayList<String> dogTrainingStatus = new ArrayList<String>();
    
    // Main() Driver
    public static void main(String[] args) throws IOException{
    	
    	// Declare variables
    	String userInput;
    	
    	// Populate ArrayList monkeySpecies with approved monkey species
    	monkeySpecies.add("capuchin");
    	monkeySpecies.add("guenon");
    	monkeySpecies.add("macaque");
    	monkeySpecies.add("marmoset");
    	monkeySpecies.add("squirrel monkey");
    	monkeySpecies.add("tamarin");
    	
    	// Populate ArrayList dogTrainingStatus with dog's training statuses.
    	dogTrainingStatus.add("intake");
    	dogTrainingStatus.add("phase_1");
    	dogTrainingStatus.add("phase_2");
    	dogTrainingStatus.add("phase_3");
    	dogTrainingStatus.add("phase_4");
    	dogTrainingStatus.add("phase_5");
    	dogTrainingStatus.add("in-service");
    	dogTrainingStatus.add("farm");

        // Set Scanner to read user input
        Scanner scnr = new Scanner(System.in);
    	
        initializeDogList();
        initializeMonkeyList();
        
        // Display Menu and read user's initial input.
        displayMenu();
        userInput = scnr.next();
        
        // Loop to continue reading user input until "q" or "Q" is seen.
        while(!userInput.equalsIgnoreCase("q")) {
        	
        	switch (userInput) {
        	  case "1":																// Intake a new dog
        		  intakeNewDog(scnr);
        		  break;

        	  case "2":																// Intake a new monkey
        		  intakeNewMonkey(scnr);
        		  break;
        		  
        	  case "3":																// Reserve an animal
        		  reserveAnimal(scnr);
        		  break;

        	  case "4":																// Print a list of all dogs
        		  printAnimals("dog");
        		  break;
        		  
        	  case "5":																// Print a list of all monkeys
        		  printAnimals("monkey");
        		  break;
        		  
        	  case "6":																// Print a list of all available animals
        		  printAnimals("available");
        		  break;

        	  default:
        		  System.out.println("\n");
        		  System.out.println("Unrecognized Command. Please try again...");
        		  // Read user's next command input.
        		  break;
        	}

        	displayMenu();
  		  	userInput = scnr.next();  		  
        }
        
        // Quit prompt
        System.out.println("Thank you for your cooperation - Grazioso Salvare.");
    }
    // ======================== End of Main() ========================  

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "Canada", "In-service", false, "Canada");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "In-service", true, "United States");
        Dog dog3 = new Dog("Spot2", "German Shepherd", "male", "1", "25.6", "05-12-2019", "Canada", "In-service", false, "Canada");
       
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Dany", "MonkeyGender", "15", "16",
    			"05-12-2019", "Belgium", "In-service", false,
    			"Belgium", "tailLength", "monkeyHeight", "bodyLength", "monkeySpecies");
    	Monkey monkey2 = new Monkey("Marina", "MonkeyGender2", "152", "162",
    			"05-12-20192", "Canada", "In-service", true,
    			"inServiceCountry2", "tailLength2", "monkeyHeight2", "bodyLength2", "monkeySpecies2");
    	Monkey monkey3 = new Monkey("Martin", "MonkeyGender3", "1522", "1623",
    			"05-12-2023", "Canada", "In-service", false,
    			"Canada", "tailLength2", "monkeyHeight2", "bodyLength2", "monkeySpecies2");
 	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }

    /* 	IntakeNewDog method validates that the dog doe's not exist in "Grazioso Salvare" 
     	and adds a new dog instance into the "dogList" list */
    public static void intakeNewDog(Scanner scnr) {
    	
    	String capitilizedName, capitilizedBreed, CapitalAcquisition, dogPhase, CapitalTrainingStatus, CapitalCountry;
    	String readStringInput = "";
    	double readDoubleInput;
    	
        // Set a loop to return to the menu in case of input error.
        while(true) {
        	// Catch errors on user input.
        	try {
                System.out.println("What is the dog's name?");
                scnr.nextLine();
                readStringInput = scnr.nextLine();
                
                // Validates input starts with a letter. 
                if (!Character.isLetter(readStringInput.charAt(0))) {
                	System.out.printf("\n\nDog's name must begin with a letter.\tPlease try again.");
                	break;
                }
                
                // Validates that the dog doe's not exist in the system
                for(Dog dog: dogList) {
                    if(dog.getName().equalsIgnoreCase(readStringInput)) {
                        System.out.printf("\n\nThis dog is already in our system");
                        return;	//returns to menu
                    }
                }

                // Instantiate a new dog
                Dog dog = new Dog();
                
                // Capitalize dog's name
                capitilizedName = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                
                // Set dog's name
                dog.setName(capitilizedName);
                
                // validate a string input and Set dog's breed.
                System.out.println("Enter dog's breed:");
                readStringInput = scnr.nextLine();
                capitilizedBreed = readStringInput.substring(0).toUpperCase();
                if (Character.isLetter(readStringInput.charAt(0))) {
                	dog.setBreed(capitilizedBreed);
                } else {
                	System.out.printf("\n\nDog's breed must be a string.\tPlease try again.");
                	break;
                	}
                
                // Validate input and Set dog's gender
                System.out.println("Enter dog's gender (M/F):");
                readStringInput = scnr.nextLine();
                if (readStringInput.equalsIgnoreCase("M") || readStringInput.equalsIgnoreCase("F") ) {
                	dog.setGender(readStringInput);
                } else {
                	System.out.printf("\n\nDog's gender must be 'M' for Male and 'F' for Female.\tPlease try again.");
                	break;
                }
                
                // Validate numeric input and Set dog's age
                System.out.println("Enter dog's age:");
                readDoubleInput = scnr.nextDouble();
                if (readDoubleInput > 0) {
                	dog.setAge(Double.toString(readDoubleInput));
                	scnr.nextLine();
                } else {
                	System.out.printf("\n\nDog's age must be positive and numeric.\tPlease try again.");
                	break;
                }
                
                // Validate numeric input and Set dog's weight
                System.out.println("Enter dog's weight:");
                readDoubleInput = scnr.nextDouble();
                if (readDoubleInput > 0) {
                	dog.setWeight(Double.toString(readDoubleInput));
                	scnr.nextLine();
                } else {
                	System.out.printf("\n\nDog's weight must be positive and numeric.\tPlease try again.");
                	break;
                }
                
                // Validate input, edit and Set dog's acquisition date
                System.out.println("Enter dog's acquisition date (mm dd yyyy):");
                readStringInput = scnr.nextLine();
                
                // Parse input into a valid mm-dd-yyyy format considering dog's age.
                int month = Integer.parseInt(readStringInput.substring(0, 2));
                int day = Integer.parseInt(readStringInput.substring(3, 5));
                int year = Integer.parseInt(readStringInput.substring(6, 10));
                if ((month > 0 && month <= 12) && (day > 0 && day <= 31) && (year >= (Year.now().getValue() - 13))) {

                	// Format and set acquisition date.
                	readStringInput = month + "-" + day + "-" + year;
                	dog.setAcquisitionDate(readStringInput);
                } else {
                	System.out.printf("\n\nDog's acquisition date must be in a valid 'mm dd yyyy' format.\tPlease try again.");
                	break;
                }
                
                // Validate input and Set dog's acquisition country
                System.out.println("Enter dog's acquisition country:");
                readStringInput = scnr.nextLine();
                if (Character.isLetter(readStringInput.charAt(0))) {
                	CapitalAcquisition = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                	dog.setAcquisitionLocation(CapitalAcquisition);
                } else {
                	System.out.printf("\n\nDog's acquisition country must be a string.\tPlease try again.");
                	break;
                	}
                
                // Validate and Set dog's training status
                System.out.println("Enter dog's training status:");
                readStringInput = scnr.nextLine();
                dogPhase = null;
                
                // Validate input status is a valid status for dogs.
                for (String dogStatus : dogTrainingStatus) {
                    if (readStringInput.toLowerCase().equals(dogStatus)) {
                    	CapitalTrainingStatus = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                    	dog.setTrainingStatus(CapitalTrainingStatus);
                    	dogPhase = readStringInput;
                    	break;
                    }
                }
                // Prompt if incorrect user input was entered.
                if (dogPhase == null) {
                	System.out.printf("\n\nDog's training status must be: intake/phase_1-5/in-service/farm.\tPlease try again.");
                	break;
                }
                
                // Validate and Set dog's reserved status
                System.out.println("Does the dog reserved? [Y/N]:");
                readStringInput = scnr.nextLine();
                if (readStringInput.equalsIgnoreCase("y")) {
                	dog.setReserved(true);
                }
                else if (readStringInput.equalsIgnoreCase("n")) {
                	dog.setReserved(false);
                } else {
                	System.out.printf("\n\nDog's reserved status must be: 'Y' for reserved / 'N' for not-reserved.\tPlease try again.");
                	break;
                }
                
                // Set dog's service country
                System.out.println("Enter dog's service country:");
                readStringInput = scnr.nextLine();
                if (Character.isLetter(readStringInput.charAt(0))) {
                	CapitalCountry = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                	dog.setInServiceCountry(CapitalCountry);
                } else {
                	System.out.printf("\n\nDog's service country must be a string.\tPlease try again.");
                	break;
                	}
                
                // Add new dog instance to the "dogList" list
                dogList.add(dog);
                
                System.out.println("\n" + dog.getName() + " has been added to Grazioso Salvare!");
            	
            	// Break the loop and continue.
                break;
        		
        	}
        	// Catch exception of no user input.
        	catch (StringIndexOutOfBoundsException noInput) {
        		System.out.print("\nYou must provide valid input!\tPlease try again.");
        		break;
        	}
        	// Catch exception of wrong input type.
        	catch (InputMismatchException inputType) {
        		System.out.printf("\n\nYou must provide numeric input!\tPlease try again.");
        		break;
        	}
        	// Catch exception of wrong input type.
        	catch (NumberFormatException inputType) {
        		System.out.printf("\n\nYou must provide numeric input!\tPlease try again.");
        		break;
        	}
        }
    }

    	/*	Adds the new monkey instance into the "monkeyList" list after validating that
    		monkey is not in the system and within the accepted monkey species */
        public static void intakeNewMonkey(Scanner scnr) {
        	
        	String capitilizedName, mokeySpecies, capitilizedSpecies, CapitalCountry, monkeyPhase, CapitalTrainingStatus, CapitalServiceCountry;
        	String readStringInput = "";
        	double readDoubleInput;
        	
            // Set a loop to return to the menu in case of input error.
            while(true) {
            	// Catch errors on user input.
            	try {
                    System.out.println("What is the monkey's name?");
                    scnr.nextLine();
                    readStringInput = scnr.nextLine();
                    
                    // Validates input starts with a letter. 
                    if (!Character.isLetter(readStringInput.charAt(0))) {
                    	System.out.printf("\n\nMonkey's name must begin with a letter.\tPlease try again.");
                    	break;
                    }
                    
                    // Validates that the monkey does not exist in the system
                    for(Monkey monkey: monkeyList) {
                        if(monkey.getName().equalsIgnoreCase(readStringInput)) {
                            System.out.printf("\n\nThis monkey is already in our system");
                            return;	//returns to menu
                        }
                    }

                    // Instantiate a new monkey
                    Monkey monkey = new Monkey();
                    
                    // Capitalize monkey's name
                    capitilizedName = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                    
                    // Set monkey's name
                    monkey.setName(capitilizedName);
                    
                    // Validate and Set monkey's training status
                    System.out.println("What is the monkey's species?");
                    readStringInput = scnr.nextLine();
                    mokeySpecies = null;
                    
                    // Validate monkey's species input is valid for training.
                    for (String monkeytype : monkeySpecies) {
                        if (readStringInput.toLowerCase().equals(monkeytype)) {
                        	monkey.setTrainingStatus(readStringInput);
                        	mokeySpecies = readStringInput;
                        	capitilizedSpecies = readStringInput.substring(0).toUpperCase();
                        	monkey.setSpecies(capitilizedSpecies);
                        	break;
                        }
                    }
                    // Return to menu if user's input monkey that is not in the "monkeySpecies" list
                    if (mokeySpecies == null) {
                    	System.out.printf("\n\n" + readStringInput + " is not eligebile for training!\n\n");
                    	break;
                    }
                    
                    // Validate input and Set monkey's gender
                    System.out.println("Enter monkey's gender (M/F):");
                    readStringInput = scnr.nextLine();
                    if (readStringInput.equalsIgnoreCase("M") || readStringInput.equalsIgnoreCase("F") ) {
                    	monkey.setGender(readStringInput);
                    } else {
                    	System.out.printf("\n\nMonkey's gender must be 'M' for Male and 'F' for Female.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate numeric input and Set monkey's age
                    System.out.println("Enter monkey's age:");
                    readDoubleInput = scnr.nextDouble();
                    if (readDoubleInput > 0) {
                    	monkey.setAge(Double.toString(readDoubleInput));
                    	scnr.nextLine();
                    } else {
                    	System.out.printf("\n\nMonkey's age must be positive and numeric.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate numeric input and Set monkey's weight
                    System.out.println("Enter monkey's weight:");
                    readDoubleInput = scnr.nextDouble();
                    if (readDoubleInput > 0) {
                    	monkey.setWeight(Double.toString(readDoubleInput));
                    	scnr.nextLine();
                    } else {
                    	System.out.printf("\n\nMonkey's weight must be positive and numeric.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate input, edit and Set monkey's acquisition date
                    System.out.println("Enter monkey's acquisition date (mm dd yyyy):");
                    readStringInput = scnr.nextLine();
                    
                    // Parse input into a valid mm-dd-yyyy format considering monkeys's age.
                    int month = Integer.parseInt(readStringInput.substring(0, 2));
                    int day = Integer.parseInt(readStringInput.substring(3, 5));
                    int year = Integer.parseInt(readStringInput.substring(6, 10));
                    if ((month > 0 && month <= 12) && (day > 0 && day <= 31) && (year >= (Year.now().getValue() - 40))) {

                    	// Format string date.
                    	readStringInput = month + "-" + day + "-" + year;
                    	monkey.setAcquisitionDate(readStringInput);
                    } else {
                    	System.out.printf("\n\nMonkey's acquisition date must be in a valid 'mm dd yyyy' format.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate input and Set monkey's acquisition country
                    System.out.println("Enter monkey's acquisition country:");
                    readStringInput = scnr.nextLine();
                    CapitalCountry = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                    if (Character.isLetter(readStringInput.charAt(0))) {
                    	monkey.setAcquisitionLocation(CapitalCountry);
                    } else {
                    	System.out.printf("\n\nMonkey's acquisition country must be a string.\tPlease try again.");
                    	break;
                    	}
                    
                    // Validate and Set monkey's training status
                    System.out.println("Enter monkey's training status:");
                    readStringInput = scnr.nextLine();
                    monkeyPhase = null;
                    
                    // Validate input status is a valid status for monkeys.
                    for (String monkeyStatus : dogTrainingStatus) {
                        if (readStringInput.toLowerCase().equals(monkeyStatus)) {
                        	CapitalTrainingStatus = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                        	monkey.setTrainingStatus(CapitalTrainingStatus);
                        	monkeyPhase = readStringInput;
                        	break;
                        }
                    }
                    if (monkeyPhase == null) {
                    	System.out.printf("\n\nDog's training status must be: intake/phase_1-5/in-service/farm.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate and Set monkey's reserved status
                    System.out.println("Does the monkey reserved? [Y/N]:");
                    readStringInput = scnr.nextLine();
                    if (readStringInput.equalsIgnoreCase("y")) {
                    	monkey.setReserved(true);
                    }
                    else if (readStringInput.equalsIgnoreCase("n")) {
                    	monkey.setReserved(false);
                    } else {
                    	System.out.printf("\n\nMonkey's reserved status must be: 'Y' for reserved / 'N' for not-reserved.\tPlease try again.");
                    	break;
                    }
                    
                    // Set monkey's service country
                    System.out.println("Enter monkey's service country:");
                    readStringInput = scnr.nextLine();
                    if (Character.isLetter(readStringInput.charAt(0))) {
                    	CapitalServiceCountry = readStringInput.substring(0, 1).toUpperCase() + readStringInput.substring(1).toLowerCase();
                    	monkey.setInServiceCountry(CapitalServiceCountry);
                    } else {
                    	System.out.printf("\n\nMonkey's service country must be a string.\tPlease try again.");
                    	break;
                    	}
                    
                    // Validate numeric input and Set monkey's tail length.
                    System.out.println("Enter monkey's tail length:");
                    readDoubleInput = scnr.nextDouble();
                    if (readDoubleInput > 0) {
                    	monkey.setTailLength(Double.toString(readDoubleInput));
                    	scnr.nextLine();
                    } else {
                    	System.out.printf("\n\nMonkey's tail must be positive and numeric.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate numeric input and Set monkey's height.
                    System.out.println("Enter monkey's height:");
                    readDoubleInput = scnr.nextDouble();
                    if (readDoubleInput > 0) {
                    	monkey.setHeight(Double.toString(readDoubleInput));
                    	scnr.nextLine();
                    } else {
                    	System.out.printf("\n\nMonkey's height must be positive and numeric.\tPlease try again.");
                    	break;
                    }
                    
                    // Validate numeric input and Set monkey's body length
                    System.out.println("Enter monkey's body length:");
                    readDoubleInput = scnr.nextDouble();
                    if (readDoubleInput > 0) {
                    	monkey.setBodyLength(Double.toString(readDoubleInput));
                    	scnr.nextLine();
                    } else {
                    	System.out.printf("\n\nMonkey's body length must be positive and numeric.\tPlease try again.");
                    	break;
                    }

            		// Add new monkey instance to the "monkeyList" list
            		monkeyList.add(monkey);
                    
                    System.out.println("\n" + monkey.getName() + " has been added to Grazioso Salvare!");
                	
                	// Break the loop
                    break;
            	}
            	// Catch exception of no user input.
            	catch (StringIndexOutOfBoundsException noInput) {
            		System.out.print("\nYou must provide valid input!\tPlease try again.");
            		break;
            	}
            	// Catch exception of wrong input type.
            	catch (InputMismatchException inputType) {
            		System.out.printf("\n\nYou must provide numeric input!\tPlease try again.");
            		break;
            	}
            	// Catch exception of wrong input type.
            	catch (NumberFormatException inputType) {
            		System.out.printf("\n\nYou must provide numeric input!\tPlease try again.");
            		break;
            	}
            }
        }

        // Reserve animals method.
        public static void reserveAnimal(Scanner scanner) throws IOException {
        	
        	// Declare variables.
        	String readInput;
        	String animal = "";
        	String country = "";
        	
            // User input prompt.
            System.out.println("\n\nTo reserve an animal, input animal type, and service country inline. Example: Dog/Monkey Canada");
            
            // Catch input errors.
            try {
            	// Read user's in line input and split it into array.
            	scanner.nextLine();
            	readInput = scanner.nextLine();
        		String[] splitArray = readInput.split(" ", 2);
        		
        		// User's input pattern is correct.
        		if (splitArray.length == 2) {
                	animal = splitArray[0];
                	country = splitArray[1];
                	
                	// Case for user's input animal is "dog". Search for instances in the "dogList" array.
                	if (animal.equalsIgnoreCase("dog")) {
                		for (Dog dog : dogList) {
                			
                			// As first instance of dog found, validate further.
                			if (dog != null) {
                				// Check each dog instance for being "not reserved", "fully trained/In-service", and from requested country.
                				if (!dog.getReserved() && (dog.getInServiceLocation().equalsIgnoreCase(country)) && (dog.getTrainingStatus().equals("In-service"))) {
                					
                					// If a dog instance found, reserve it (Set reserve status as true), and update user.
                					dog.setReserved(true);
                					System.out.printf("\n\nCongratulations, %s is now reserved for you!" ,dog.getName());
                					return;
                				}
                			}
                		}
                		// Prompt if no dog from country is available and fully trained(In-service).
                		System.out.printf("\n\nWe are sorry! All the %ss from %s are reserved or not fully trained.", animal, country);
                	}
                	
                	// Case for user input animal is "monkey"
                	else if (animal.equalsIgnoreCase("monkey")) {
                		for (Monkey monkey : monkeyList) {
                			
                			// As first instance of monkey found, validate further.
                			if (monkey != null) {
                				// Check each monkey instance for being "not reserved", "fully trained/In-service", and from requested country.
                				if (!monkey.getReserved() && (monkey.getInServiceLocation().equalsIgnoreCase(country)) && (monkey.getTrainingStatus().equals("In-service"))) {
                					
                					// If a monkey instance found, reserve it (Set reserve status as true), and update user.
                					monkey.setReserved(true);
                					System.out.printf("\n\nCongratulations, %s is now reserved for you!" ,monkey.getName());
                					return;
                				}
                			}
                		}
                		// Prompt if no dog from country is available and fully trained(In-service).
                		System.out.printf("\n\nWe are sorry! All the %ss from %s are reserved or not fully trained.", animal, country);
                	}
                	// Return to menu if requested animal from desired country wasn't found in the ArrayLists.
                	else {
                		System.out.printf("\n\nWe are sorry! %s from %s is not available.", animal, country);
                		return;
                	}
                	
                // Prompt if user input mismatch expected input. return to menu.
        		} else {
        			System.out.printf("\n\nExpected input Example: Cat Canada\t Please try again!");
        			return;
        			}
            }
            // Catch methods to prevent input errors.
            catch (InputMismatchException inputError) {
            	System.out.printf("inputError EXC");
            }
            catch (ArrayIndexOutOfBoundsException E) {
            	System.out.printf("\n\nYou must provide valid input!\tPlease try again.");
            }
        }      

        public static void printAnimals(String animal) {
        	if (animal == "dog") {
        		System.out.println("\n\t\t\t\t\t\t  LIST OF DOGS:"
        				+ "\n========================================================"
        				+ "==========================================================");
        		
        		// Iterate through the dogList array.
        		for (Dog dog : dogList) {
        			// Print formated dog's name, status, acquisition country and if the Dog is reserved.
        			System.out.printf("| "
        					+ "Dog's name: %-11.10s| "
        					+ "Dog's Status: %-11.10s| "
        					+ "Acquisition country: %-13.12s| "
        					+ "Is dog reserved: %-6s|",
        					dog.getName(), dog.getTrainingStatus(), dog.getAcquisitionLocation(), dog.getReserved());
        			System.out.println();
        		}
        		System.out.println("===================================================="
        				+ "==============================================================");
        		
        	// Print a list of all the monkeys
        	} else if (animal == "monkey") {
        		System.out.println("\n\t\t\t\t\t\t  LIST OF MONKEYS:"
        				+ "\n============================================================="
        				+ "==============================================================");
        		
        		// Iterate through the monkeyList array.
        		for (Monkey monkey : monkeyList) {
        			// Print formated monkey name, status, acquisition country and if the monkey is reserved.
        			System.out.printf("| "
        					+ "Monkey's name: %-11.10s| "
        					+ "Monkey's Status: %-11.10s| "
        					+ "Acquisition country: %-13.12s| "
        					+ "Is monkey reserved: %-6s|", 
        					monkey.getName(), monkey.getTrainingStatus(), monkey.getAcquisitionLocation(), monkey.getReserved());
        			System.out.println();
        		}
        		System.out.println("========================================================="
        				+ "==================================================================");
        		
        	// Prints a list of all available and fully trained animals
        	} else {
        		
        		System.out.println("\n\t\tLIST OF ALL AVAILABLE AND FULLY TRAINED (in-service) ANIMLAS:");
        		System.out.println("==========================================="
        				+ "====================================================");
        		// Print dog name and acquisition country if the dog is NOT reserved and ready for service.
        		for (Dog dog : dogList) {
        			if (!dog.getReserved() && dog.getTrainingStatus().equals("In-service")) {
        				System.out.printf("| "
        						+ "Dog's name:    %-11.10s| "
        						+ "Dog's breed:    %-16.15s| "
        						+ "Service country: %-13.12s"
        						+ "|", 
        						dog.getName(), dog.getBreed(), dog.getInServiceLocation());
        				System.out.println();
        			}
        		}
        		
        		// Print monkey name and acquisition country and if the monkey is NOT reserved and ready for service.
        		for (Monkey monkey : monkeyList) {
        			if (!monkey.getReserved() && monkey.getTrainingStatus().equals("In-service")) {
        				System.out.printf("| "
        						+ "Monkey's name: %-11.10s| "
        						+ "Monkey species: %-16.15s| "
        						+ "Service country: %-13.12s"
        						+ "|", 
        						monkey.getName(), monkey.getSpecies(), monkey.getInServiceLocation());
        				System.out.println();
        			}
        		}
        		System.out.println("==========================================="
        				+ "====================================================");
        	}
        }
}