package phoneBookProject;

import java.util.Scanner;

public class Menu {

	int option;
	Directory newContact = new Directory();
	Person tempPerson = new Person();

	public int getOption() {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter your choice: ");
		int choice = scan1.nextInt();
		option = choice;
		return option;
	}

	public Menu() {

	}

//	public void contactsMenu() {
//		
//		boolean ok = this.showMenu();	
//			do {
//			ok = this.showMenu();
//			} while(ok == true);
//	
//	}

	public boolean showMenu() {
		System.out.println(
				" ************************* \n" + " *   PHONEBOOK ~~ MENU   * \n" + " *************************");
		System.out.println("1: Add a new contact");
		System.out.println("2: Search contact by first name");
		System.out.println("3: Search contact by last name");
		System.out.println("4: Search contact by full name");
		System.out.println("5: Search contact by phone number");
		System.out.println("6: Search contact by city or state");
		System.out.println("7: Delete an existing contact");
		System.out.println("8: Show all contacts in alphatical order");
		System.out.println("0: Exit the phonebook\n");

		getOption();
		int choice = this.option;
		boolean isExist = true;

		while (choice != 0) {
			if (choice == 1) {
				String info = "";
				newContact.createContact();
				showMenu();
				isExist = true;
				break;
			} else if (choice == 2) {
				String firstKeyword = "";
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Please enter the first name of the contact to be search for: ");
				firstKeyword = scan1.next();
				newContact.printDirectoryArray(newContact.searchByFirstName(firstKeyword));
				showMenu();
				isExist = true;
				break;
			} else if (choice == 3) {
				String lastKeyword = "";
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Please enter the last name of the contact to be search for: ");
				lastKeyword = scan2.next();
				newContact.printDirectoryArray(newContact.searchByLastName(lastKeyword));
				showMenu();
				isExist = true;
				break;
			} else if (choice == 4) {
				String firstnKeyword = "", lastnKeyword;
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Please enter the full name of the contact to be search for: ");
				System.out.print("First name: ");
				firstnKeyword = scan3.next();
				System.out.print("\nLast name: ");
				lastnKeyword = scan3.next();
				newContact.printDirectoryArray(newContact.searchByFullName(firstnKeyword, lastnKeyword));
				showMenu();
				isExist = true;
				break;

			} else if (choice == 5) {
				String phoneNum = "";
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Please enter the phone number of the contact to be search for: ");
				phoneNum = scan1.next();
				newContact.printDirectoryArray(newContact.searchByPhoneNumber(phoneNum));
				showMenu();
				isExist = true;
				break;

			} else if (choice == 6) {

				String cityOrState = "";
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Please enter the city or state of the contact to be search for: ");
				cityOrState = scan1.next();
				newContact.printDirectoryArray(newContact.searchByCityOrState(cityOrState));
				showMenu();
				isExist = true;
				break;

			} else if (choice == 7) {
				Scanner scan1 = new Scanner(System.in);
				System.out.print("Please enter the number of the contact you want to delete: ");
				String phoneNum = scan1.next();
				newContact.deletePerson(phoneNum);
				showMenu();
				isExist = true;
				break;

			} else if (choice == 8) {
				newContact.printSortedDirectory(newContact.sortingContactsAlph());
				isExist = true;
				showMenu();
				break;

			} else if (choice == 0) {
				isExist = false;
				break;
			} else {
				isExist = false;
				System.out.println("Error, please select from the choices below and enter a valid option! \n");
				this.showMenu();
				break;
			}

		}

		return isExist;
	}

}
