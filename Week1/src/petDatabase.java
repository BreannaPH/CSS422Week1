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
            case 3: updatePet();
                break;
            case 4: removePet();
                break;
            case 5: searchPetsByName();
                break;
            case 6: searchPetsByAge();
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
    
    private static void searchPetsByName() {
        s.nextLine();
        System.out.print("Enter name to search: ");
        String name = s.nextLine();
        for (int i = 0; i < petCount; i++) {
            if (pets[i].getName().equals(name)) {
                printTableHeader();
                System.out.printf("|%3d |%10s |%4d |\n", i, pets[i].getName(), pets[i].getAge());
                printTableFooter();
            }
        }
    }//searchPetsByName end

    private static void searchPetsByAge() {
        System.out.print("Enter age to search: ");
        int age = s.nextInt();
        for (int i = 0; i < petCount; i++) {
            if (pets[i].getAge() == age) {
                printTableHeader();
                System.out.printf("|%3d |%10s |%4d |\n", i, pets[i].getName(), pets[i].getAge());
                printTableFooter();
                }
            }
    }//searchPetsByAge end
    
    private static void updatePet() {
        showAllPets();
        s.nextLine();
        System.out.print("Enter the ID you want to change: ");
        int ID = s.nextInt();
        s.nextLine();
        System.out.print("New details: ");
        String input = s.nextLine();
        String[] petNameAndAge = input.split(" ");
        String name = petNameAndAge[0];
        int age = Integer.parseInt(petNameAndAge[1]);
        pets[ID].setName(name);
        pets[ID].setAge(age);
    }//updatePet end
    
    private static void removePet() {
        showAllPets();
        System.out.print("Pet ID to remove: ");
        int ID = s.nextInt();
        Pet p = pets[ID];
        for (int i = ID; i < petCount; i++) {
            pets[i] = pets[i + 1];
        }
        System.out.print(p.getName() + " has been removed.");
        pets[petCount] = null;
        petCount--;
    }//removePet end

}// petDatabase end
