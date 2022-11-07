import java.util.Scanner;

/**
 * @author Breanna Price-Heuckendorf
 * CSC 422 Week 1 Assignment 1 Part 2
 */

class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }//constructor

    public String getName() {
        return name;
    }//getName

    public int getAge() {
        return age;
    }//getAge

    public void setName(String name) {
        this.name = name;
    }//setName

    public void setAge(int age) {
        this.age = age;
    }//setAge

}//Pet class
public class petDatabase {
	static Pet[] pets = new Pet[100];
    static int petCount = 0;
    static Scanner s = new Scanner(System.in);
    
    
	public static void main(String[] args) {
		while (true) {
            int choice = getUserChoice();
            switch (choice) {
            case 1: showAllPets();
                break;
            case 2: addPets();
                break;
            case 3: //updatePet();
                break;
            case 4: //removePet();
                break;
            case 5: //searchPetsByName();
                break;
            case 6: //searchPetsByAge();
                break;
            case 7: System.out.println("Goodbye!");
                return;   
            }// switch end
        }// while loop end

	}// main end
	
	private static int getUserChoice() {
        System.out.print("\n"+"What would you like to do?\n" +
        "1) View all pets\n" +
        "2) Add more pets\n" +
        "3) Update an existing pet\n" +
        "4) Remove an existing pet\n" +
        "5) Search pets by name\n" +
        "6) Search pets by age\n" +
        "7) Exit program"+"\n\n");
        System.out.print("Your choice: ");
        int choice = s.nextInt();
        return choice;
    }//getUserChoice end
	
	private static void addPets() {
        int counter = 0;
        s.nextLine();
        System.out.print("Enter 'done' to go back to menu\n");
        while (true) {
            System.out.print("add pet (name, age): ");
            String input = s.nextLine();
            if (input.equals("done"))
                break;
            String[] petNameAndAge = input.split(" ");
            
            String name = petNameAndAge[0];
            int age = Integer.parseInt(petNameAndAge[1]);
            System.out.println(name +" " + age);
            Pet p = new Pet(name, age);
            pets[petCount] = p;
            petCount++;
            counter++;
        }
        System.out.println(counter + " pets added.");
    }//addPets end
	
	private static void showAllPets() {
        printTableHeader();
        printTableRow();
        printTableFooter();
    }//showAllPets end

    private static void printTableHeader() {
        System.out.println("+----------------------+");
        System.out.printf("|%3s |%10s |%4s", "ID", "NAME", "AGE\n");
        System.out.println("+----------------------+");
    }//printTableHeader end

    private static void printTableFooter() {
        System.out.println("+----------------------+");
        System.out.println(petCount + " rows in set.");
    }//printTableFooter end
    
    private static void printTableRow() {
        for (int i = 0; i < petCount; i++) {
            System.out.printf("|%3d |%10s |%4d |\n", i, pets[i].getName(), pets[i].getAge());
        }
    }//printTableRow end

}// petDatabase end
