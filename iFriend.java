import java.util.*;
import java.time.LocalDate;
class ContactList{
    private Node start;
    
//----------Check null or not-----------//
    public boolean isEmpty(){
		return start==null;
	}

//----------Get Data size-----------//
	public int size(){
		int count=0;
		Node temp=start;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}

//----------Get Object-----------//
	public Contact get(int index){
		if(index>=0 && index<size()){
			Node temp=start;
			int count=0;
			while(count<index){
				count++;
				temp=temp.next;
			}
			return temp.contact; 
		}
		return null;
	}
	
//----------Create Array-----------//
	public Contact[] toArray(){
		Contact[] tempArray=new Contact[size()];
		Node temp=start;
		for (int i = 0; i < tempArray.length; i++){
			tempArray[i]=temp.contact;
			temp=temp.next;
		}
		return tempArray;
	}
	
//----------Remove methode-----------//
	public void remove(int index){
		if(index>=0 && index<size()){
			if(index==0){
				start=start.next;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					count++;
					temp=temp.next;
				}
				temp.next=temp.next.next;
			}
		}
		
	}
	
//----------Search methode-----------//
	public int search(String data) {
        int index = 0;
        Node temp = start;
        while (temp != null) {
            if (temp.contact.getName().equals(data) || temp.contact.getPhoneNumber().equals(data)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }
    
//----------Add methode-----------//	
	public void add(Contact contact){
		Node n1 = new Node(contact);
		Node lastContact = start;
		if (start == null) {
			start = n1;
			} else {
			while (lastContact.next != null) {
				lastContact = lastContact.next;
			}
			lastContact.next = n1;
		}
	}

//----------Inner class-----------//	
	class Node{
		private Contact contact;
		private Node next;
			
		public Node(Contact contact){
			this.contact=contact;
		}
	}
}

class Contact{
	
//----------Private instance variables to store the contact details-----------//

    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

//----------Constructor-----------//
    Contact(String id, String name, String phoneNumber, String companyName, double salary, String birthday){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salary = salary;
        this.birthday = birthday;
    }

//----------Setter id----------//

    public void setId(String id){
        this.id = id;
    }

//----------Setter name----------//

    public void setName(String name){
        this.name = name;
    }

//----------Setter phone number----------//

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

//----------Setter company name----------//

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

//----------Setter salary----------//

    public void setSalary(double salary){
        this.salary = salary;
    }

//----------Setter birthday----------//

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

//----------Getter id----------//

    public String getId(){
        return id;
    }

//----------Getter name----------//

    public String getName(){
        return name;
    }

//----------Getter phone number----------//

    public String getPhoneNumber(){
        return phoneNumber;
    }

//----------Getter company name----------//

    public String getCompanyName(){
        return companyName;
    }

//----------Getter salary----------//

    public double getSalary(){
        return salary;
    }

//----------Getter birthday----------//

    public String getBirthday(){
        return birthday;
    }
}

class iFriend{
//------------------------------MAIN METHOD------------------------------//

	public static void main(String args[]){
		HomePage();
	}
	
//------------------------------STATIC VARIABLES------------------------------//

	public static int IDNum=1;
	public static ContactList contactlist = new ContactList();
	
//------------------------------SUB METHODS------------------------------//	 

	//++++++++++ METHOD-HomePage ++++++++++//
	
		public static void HomePage(){
		Scanner input=new Scanner(System.in);
		clearConsole();
		System.out.println("\n");
		System.out.println("              /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$     ");
		System.out.println("              |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$   ");
		System.out.println("               /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$   ");
		System.out.println("              | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$   ");
		System.out.println("              | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$   ");
		System.out.println("              | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$   ");
		System.out.println("              | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/   ");
		System.out.println("              |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/    ");
		System.out.println();
		System.out.println();
		System.out.println("     _____            _             _           ____                       _          ");
		System.out.println("    / ____|          | |           | |         / __ \\                     (_)               ");
		System.out.println("   | |     ___  _ __ | |_ __ _  ___| |_ ___   | |  | |_ __ __ _  __ _ _ __  _ _______ _ __              ");
		System.out.println("   | |    / _ \\| '_ \\| __/ _` |/ __| __/ __|  | |  | | '__/ _` |/ _` | '_ \\| |_  / _ \\ '__|               ");
		System.out.println("   | |___| (_) | | | | || |_| | |__| |_\\__ \\  | |__| | | | |_| | |_| | | | | |/ /  __/ |               ");
		System.out.println("    \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/   \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|                  ");
		System.out.println("                                                           __/ |                               ");
		System.out.println("                                                          |___/                                ");	
		System.out.println("=================================================================================================");
		System.out.println();
		System.out.println("\n\n\t[01] ADD Contacts");		
		System.out.println("\n\t[02] UPDATE Contacts");	
		System.out.println("\n\t[03] DELETE Contacts");	
		System.out.println("\n\t[04] SEARCH Contacts");	
		System.out.println("\n\t[05] LIST Contacts");	
		System.out.println("\n\t[06] EXIT");	
		System.out.print("\n\nEnter an Option to Continue... -> ");	
		int option=input.nextInt();
		switch(option){
			case 1:
				ContactADDER();
				break;
			case 2:
				ContactUPDATER();
				break;
			case 3:
				ContactDELETER();
				break;
			case 4:
				ContactSEARCHER();
				break;
			case 5:
				ContactLISTER();
				break;
			case 6:
				clearConsole();
				System.out.println("\n\n\t\t****  Bye-Bye  ****");
				System.exit(0);
			default:
				clearConsole();
				return;
		}																							
	}
	
	//++++++++++ METHOD-ContactADDER ++++++++++//
	
	public static void ContactADDER(){
		Scanner input=new Scanner(System.in);
		
		double salary=0;
		String id="";
		String phoneNumber="";
		String birthday="";
		
	do{
		clearConsole();
		System.out.println("\n+------------------------------------------------------------+");
		System.out.println("|                ADD CONTACT TO THE LIST                     |");
		System.out.println("+------------------------------------------------------------+\n");
		
		id=IDGenerator(IDNum++); //------ calling IDGenerator --------
		System.out.println("\n "+id);
		System.out.println("=======");
		System.out.print("\nName\t\t: ");
		String name=input.nextLine();
		
	do{
		System.out.print("Phone Number\t: ");
		phoneNumber=input.nextLine();
	}while(!PhoneNoValidator(phoneNumber));
		
		System.out.print("Company Name\t: ");
		String companyName=input.nextLine();
		
	do{
		System.out.print("Salary\t\t: ");
		salary=input.nextDouble();
		input.nextLine();
	}while(!SalaryValidator(salary));
	
	do{
		System.out.print("B'Day(YYYY-MM-DD): ");
		birthday=input.next();
		if(!BirthdayValidator(birthday)){
			System.out.println("\n\tInvalid BirthDay...");
			System.out.print("\nDo You Want to Input BirthDay Again ? [Y/N] : ");
			String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
					continue;
				}else{
					HomePage();
					break;
				}
		}
	break;
	}while(true);
		
		Contact contact = new Contact(id, name, phoneNumber, companyName, salary, birthday);
		contactlist.add(contact);
		
			System.out.println("\n\tCustomer Added Successfully..!");
			System.out.print("\n\nDo You Want To Add Another Customer ? [Y/N] ->  ");
			String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					input.nextLine();
					continue;
				}else{
                HomePage();
                break;
				}

	}while(true);
	}

	//++++++++++ METHOD-ContactUPDATER ++++++++++//
		
	public static void ContactUPDATER(){
		Scanner input=new Scanner(System.in);
		
	L:do{
		clearConsole();
		System.out.println();
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|                        UPDATE CONTACT                      |");
		System.out.println("+------------------------------------------------------------+");
		System.out.print("\n\nSearch Contact by Name or Phone Number - ");
		String search=input.nextLine();
		
		int index = contactlist.search(search);

        if (index != -1) {
            Contact contact = contactlist.get(index);
            System.out.println("\n\tContact ID\t\t: " + contact.getId());
            System.out.println("\tName\t\t\t: " + contact.getName());
            System.out.println("\tPhone Number\t\t: " + contact.getPhoneNumber());
            System.out.println("\tCompany Name\t\t: " + contact.getCompanyName());
            System.out.println("\tSalary\t\t\t: " + contact.getSalary());
            System.out.println("\tB'Day(YYYY-MM-DD)\t: " + contact.getBirthday());
			System.out.println("\n\nWhat Do You Want To Update ? ");
			System.out.println("\n\t[01] Name ");
			System.out.println("\t[02] Phone Number ");
			System.out.println("\t[03] Company Name ");
			System.out.println("\t[04] Salary ");
			System.out.print("\n\nEnter An Option To Continue -> ");
			int option=input.nextInt();
			input.nextLine();
			System.out.print("\033[10A");
			System.out.print("\033[0J");
			
			switch(option){
				
				case 1:
				
				do{
					System.out.println("  UPDATE NAME  ");
					System.out.println("**===========**");
					System.out.print("\nInput New Name - ");
					String newName=input.nextLine();
					System.out.print("\nConfirm New Name - ");
					String conformNewName=input.nextLine();
					
				if(newName.equalsIgnoreCase(conformNewName)){
					contact.setName(newName);
					System.out.println("\n\t Contact Have Been Updated Successfully..!");
					System.out.print("\nDo You Want To Update Another Contact ? [Y/N] -> ");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						input.nextLine();
						continue L;
					}else{
						HomePage();
					}
				}else{
					System.out.print("\033[6A");
					System.out.print("\033[0J");
				}
			}while(true);
					
				case 2:
				
				String newPhoneNo="";
				
			L1:do{
					System.out.println("  UPDATE PHONE NUMBER  ");
					System.out.println("**===================**");
					System.out.print("\nInput New Phone Number - ");
					newPhoneNo=input.nextLine();
					System.out.print("\nConfirm New Phone Number - ");
					String conformNewPhoneNo=input.nextLine();
					if(newPhoneNo.equals(conformNewPhoneNo)){
						if(PhoneNoValidator(newPhoneNo)){
							contact.setPhoneNumber(newPhoneNo);
							System.out.println("\n\t Contact Have Been Updated Successfully..!");
							System.out.print("\nDo You Want To Update Another Contact ? [Y/N] -> ");
							String yn=input.next();
								if(yn.equalsIgnoreCase("Y")){
									input.nextLine();
									continue L;
								}else{
									HomePage();
								}
						}else{
							System.out.print("\033[5A");
							System.out.print("\033[0J");
							continue L1;
						}
					}else{
						System.out.print("\033[6A");
						System.out.print("\033[0J");
						continue L1;
					}
			}while(true);
	
				case 3:
			do{
					System.out.println("  UPDATE COMPANY NAME  ");
					System.out.println("**===================**");
					System.out.print("\nInput New Company Name - ");
					String newCoName=input.nextLine();
					System.out.print("\nConfirm New Company Name - ");
					String conformNewCoName=input.nextLine();
					
					if(newCoName.equalsIgnoreCase(conformNewCoName)){
						contact.setCompanyName(newCoName);
						System.out.println("\n\t Contact Have Been Updated Successfully..!");
						System.out.print("\nDo You Want To Update Another Contact ? [Y/N] -> ");
						String yn=input.next();
						if(yn.equalsIgnoreCase("Y")){
							input.nextLine();
							continue L;
						}else{
							HomePage();
						}
					}else{
						System.out.print("\033[6A");
						System.out.print("\033[0J");
					}
			}while(true);
			
				case 4:
				
			L1:do{
					System.out.println("  UPDATE SALARY  ");
					System.out.println("**=============**");
					System.out.print("\nInput New Salary - ");
					double newSalary=input.nextDouble();
					System.out.print("\nConfirm New Salary - ");
					double conformNewSalary=input.nextDouble();
					if(newSalary==conformNewSalary){
						if(SalaryValidator(newSalary)){
							contact.setSalary(newSalary);
							System.out.println("\n\t Contact Has Been Updated Successfully..!");
							System.out.print("\nDo You Want To Update Another Contact ?  [Y/N] -> ");
							String yn=input.next();
								if(yn.equalsIgnoreCase("Y")){
									input.nextLine();
									continue L;
								}else{
									HomePage();
								}
						}else{
							System.out.print("\033[5A");
							System.out.print("\033[0J");
							continue L1;
						}
					}else{
						System.out.print("\033[6A");
						System.out.print("\033[0J");
						continue L1;
					}
			}while(true);
			
				default:
				return;
			}
		}else{
			System.out.println("\n\t\tCONTACT CANNOT BE FOUND !!!");
			System.out.print("\n\nDo You Want To Redirect To Homepage ? [Y/N] ->");
			String yn=input.next();
			if(yn.equalsIgnoreCase("Y")){
				HomePage();
				break;
			}else{
				clearConsole();
				System.out.println("\n\n\t\tGOODBYE !!!");
				System.exit(0);
			}
		}
		break;
	}while(true);
	}
	
	//++++++++++ METHOD-ContactDELETER ++++++++++//	
	
	public static void ContactDELETER(){
		
		Scanner input=new Scanner(System.in);
	do{	
		clearConsole();
		System.out.println();
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|                        DELETE CONTACT                      |");
		System.out.println("+------------------------------------------------------------+");		

		System.out.print("\n\nSearch Contact by Name or Phone Number - ");
		String search=input.nextLine();
			
		int index = contactlist.search(search);

        if (index != -1) {
            Contact contact = contactlist.get(index);
            System.out.println("\n\tContact ID\t\t: " + contact.getId());
            System.out.println("\tName\t\t\t: " + contact.getName());
            System.out.println("\tPhone Number\t\t: " + contact.getPhoneNumber());
            System.out.println("\tCompany Name\t\t: " + contact.getCompanyName());
            System.out.println("\tSalary\t\t\t: " + contact.getSalary());
            System.out.println("\tB'Day(YYYY-MM-DD)\t: " + contact.getBirthday());
			System.out.print("\n\nWhat Do You Want To Delete This Contact ? [Y/N] -> ");
			String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						contactlist.remove(index);
						System.out.println("\n\t Contact Has Been Deleted Successfully..!");
						System.out.print("\nDo You Want To Delete Another Contact ?  [Y/N] -> ");
						String YN=input.next();
								if(YN.equalsIgnoreCase("Y")){
									System.out.print("\033[5A");
									System.out.print("\033[0J");
									input.nextLine();
									continue ;
								}else{
									HomePage();
									break;
								}
					}else{
						input.nextLine();
						continue ;
					}
		}else{
			System.out.println("\n\t\tCONTACT CANNOT BE FOUND !!!");
			System.out.print("\n\nDo You Want To Redirect To Homepage ? [Y/N] ->");
			String yn=input.next();
			if(yn.equalsIgnoreCase("Y")){
				HomePage();
				break;
			}else{
				clearConsole();
				System.out.println("\n\n\t\tGOODBYE !!!");
				System.exit(0);
			}
		}
		break;
	}while(true);
	}
	
	//++++++++++ METHOD-ContactSEARCHER ++++++++++//		
	
	public static void ContactSEARCHER(){
		
		Scanner input=new Scanner(System.in);
		L2:do{	
			clearConsole();
			System.out.println();
			System.out.println("+------------------------------------------------------------+");
			System.out.println("|                        SEARCH CONTACT                      |");
			System.out.println("+------------------------------------------------------------+");		

			System.out.print("\n\nSearch Contact by Name or Phone Number - ");
			String search=input.nextLine();
				
			int index = contactlist.search(search);

			if (index != -1) {
				Contact contact = contactlist.get(index);
				System.out.println("\n\tContact ID\t\t: " + contact.getId());
				System.out.println("\tName\t\t\t: " + contact.getName());
				System.out.println("\tPhone Number\t\t: " + contact.getPhoneNumber());
				System.out.println("\tCompany Name\t\t: " + contact.getCompanyName());
				System.out.println("\tSalary\t\t\t: " + contact.getSalary());
				System.out.println("\tB'Day(YYYY-MM-DD)\t: " + contact.getBirthday());
				System.out.print("\n\nDo You Want To Search This Contact ? [Y/N] -> ");
				String YN=input.next();
					if(YN.equalsIgnoreCase("Y")){
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						input.nextLine();
						continue;
					}else{
						HomePage();
						break;
					}
			}else{
				System.out.println("\n\t\tNo contact found for "+search+"...");
				System.out.print("\n\nDo You Want To Try a New Search [Y/N] : ");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					input.nextLine();
					continue L2;
				}else{
					clearConsole();
					System.out.println("\n\n\t\tGOODBYE !!!");
					System.exit(0);
				}
			}
			break;
		}while(true);
	}
	
	//++++++++++ METHOD-ContactLISTER ++++++++++//	
		
	public static void ContactLISTER(){
		Scanner input=new Scanner(System.in);
		
	L:do{
		clearConsole();
		System.out.println();
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|                         SORT CONTACT                       |");
		System.out.println("+------------------------------------------------------------+");
		
			System.out.println("\n\t[01] Sorting by Name ");
			System.out.println("\t[02] Sorting by Salary");
			System.out.println("\t[03] Sorting by Birthday");

			System.out.print("\n\nEnter An Option To Continue -> ");
			int option=input.nextInt();
			input.nextLine();
			System.out.print("\033[6A");
			System.out.print("\033[0J");
			
			switch(option){
				
				case 1:
				
					clearConsole();
					System.out.println();
					System.out.println("\t\t+------------------------------------------------------------+");
					System.out.println("\t\t|                 List Contact by Name                       |");
					System.out.println("\t\t+------------------------------------------------------------+");
					System.out.println();
					System.out.println("+---------------------------------------------------------------------------------------+");
					System.out.println("| Contact ID   |   Name    |   Phone Number   |   Company   |   Salary   |   Birthday   |");
					System.out.println("+---------------------------------------------------------------------------------------+");
                    
                    Contact[] sortedByNameArray = sortByName(contactlist.toArray());
                    
                    for (int i = 0; i < sortedByNameArray.length; i++) {
						System.out.printf("| %-12s | %-9s | %-16s | %-11s | %-10s | %-12s |\n",sortedByNameArray[i].getId(), sortedByNameArray[i].getName(), sortedByNameArray[i].getPhoneNumber(), sortedByNameArray[i].getCompanyName(), sortedByNameArray[i].getSalary(), sortedByNameArray[i].getBirthday());
					}

					System.out.println("+---------------------------------------------------------------------------------------+");
					
					System.out.print("\n\nDo You Want To Go To Homepage [Y/N] : ");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						HomePage();
						break;
					}else{
						clearConsole();
						System.out.println("\n\n\t\tGOODBYE !!!");
						System.exit(0);
					}
					
					break;
                 	
				case 2:
				
					clearConsole();
					System.out.println();
					System.out.println("\t\t+------------------------------------------------------------+");
					System.out.println("\t\t|                List Contact by Salary                      |");
					System.out.println("\t\t+------------------------------------------------------------+");
					System.out.println();
					System.out.println("+---------------------------------------------------------------------------------------+");
					System.out.println("| Contact ID   |   Name    |   Phone Number   |   Company   |   Salary   |   Birthday   |");
					System.out.println("+---------------------------------------------------------------------------------------+");
                    
                    Contact[] sortedBySalaryArray = sortBySalary(contactlist.toArray());
                    
                    for (int i = 0; i < sortedBySalaryArray.length; i++) {
						System.out.printf("| %-12s | %-9s | %-16s | %-11s | %-10s | %-12s |\n",sortedBySalaryArray[i].getId(), sortedBySalaryArray[i].getName(), sortedBySalaryArray[i].getPhoneNumber(), sortedBySalaryArray[i].getCompanyName(), sortedBySalaryArray[i].getSalary(), sortedBySalaryArray[i].getBirthday());
					}

					System.out.println("+---------------------------------------------------------------------------------------+");
					
					System.out.print("\n\nDo You Want To Go To Homepage [Y/N] : ");
					String ya=input.next();
					if(ya.equalsIgnoreCase("Y")){
						HomePage();
						break;
					}else{
						clearConsole();
						System.out.println("\n\n\t\tGOODBYE !!!");
						System.exit(0);
					}
					
					break;
				
				case 3:
				
					clearConsole();
					System.out.println();
					System.out.println("\t\t+------------------------------------------------------------+");
					System.out.println("\t\t|                List Contact by Birthday                    |");
					System.out.println("\t\t+------------------------------------------------------------+");
					System.out.println();
					System.out.println("+---------------------------------------------------------------------------------------+");
					System.out.println("| Contact ID   |   Name    |   Phone Number   |   Company   |   Salary   |   Birthday   |");
					System.out.println("+---------------------------------------------------------------------------------------+");
                    
                    Contact[] sortedByBirthdayArray = sortByBirthday(contactlist.toArray());
                    
                    for (int i = 0; i < sortedByBirthdayArray.length; i++) {
						System.out.printf("| %-12s | %-9s | %-16s | %-11s | %-10s | %-12s |\n",sortedByBirthdayArray[i].getId(), sortedByBirthdayArray[i].getName(), sortedByBirthdayArray[i].getPhoneNumber(), sortedByBirthdayArray[i].getCompanyName(), sortedByBirthdayArray[i].getSalary(), sortedByBirthdayArray[i].getBirthday());
					}

					System.out.println("+---------------------------------------------------------------------------------------+");
					
					System.out.print("\n\nDo You Want To Go To Homepage [Y/N] : ");
					String yb=input.next();
					if(yb.equalsIgnoreCase("Y")){
						HomePage();
						break;
					}else{
						clearConsole();
						System.out.println("\n\n\t\tGOODBYE !!!");
						System.exit(0);
					}
					
					break;		
		}
		break;
	}while(true);
}	
	
	//++++++++++ METHOD-IDGenerator ++++++++++//	
		
	public static String IDGenerator(int IDNum){
		
		if(IDNum<10){
			return "C000"+IDNum;
		}else if(IDNum<100 && IDNum>10){
			return "C00"+IDNum;
		}else if(IDNum<1000 && IDNum>100){
			return "C0"+IDNum;
		}else{
			return "C"+IDNum;
		}
	}
	
	//++++++++++ METHOD-PhoneNoValidator ++++++++++//	
		
	public static boolean PhoneNoValidator(String phoneNumber){
		Scanner input=new Scanner(System.in);	
		
		//ASCii Value of '0' = 48//
		if(phoneNumber.charAt(0)!=48 || phoneNumber.length()!=10){
			System.out.println("\n\tInvalid Phone Number...");
			System.out.print("\nDo You Want to ADD Phoe Number Again ? [Y/N] : ");
			String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
					return false;
				}else{
					HomePage();
				}
		}
			return true;
	}
	
	//++++++++++ METHOD-SalaryValidator ++++++++++//	
		
 	public static boolean SalaryValidator(double salary){
		Scanner input=new Scanner(System.in);
		
		if(salary<0){
			System.out.println("\n\tInvalid Salary Value...");
			System.out.print("\nDo You Want to Input Salary Again ? [Y/N] : ");
			String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					System.out.print("\033[5A");
					System.out.print("\033[0J");
					return false;
				}else{
					HomePage();
				}
		}
			return true;
	}
	
	//++++++++++ METHOD-BirthdayValidator ++++++++++//	
		
	public static boolean BirthdayValidator(String birthday){
		
		if((birthday.substring(4,5)).equals("-") && (birthday.substring(7,8)).equals("-")){
			int sub1=Integer.valueOf(birthday.substring(0,4));
			int sub2=Integer.valueOf(birthday.substring(5,7));
			int sub3=Integer.valueOf(birthday.substring(8,10));
			if(sub1==LocalDate.now().getYear() && sub2==LocalDate.now().getMonthValue() && sub3==LocalDate.now().getDayOfMonth()){
				return false;
			}else if(sub1 > (LocalDate.now().getYear()) || ((sub2 > 12) || (sub2 <= 0)) || ((sub3 > 31) || (sub3 <= 0))){
				return false;
			}else{
				switch(sub2){
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						return true;
					case 4:
					case 6:
					case 9:
					case 11:
						if(sub3>30){
							return false;
						}else{
							return true;
						}
					case 2:
						if((!(sub1%4==0 && sub1%100!=0 || sub1%400==0)) && sub3>28){
							return false;
						}else if(sub3>29){
							return false;
						}
						return true;
				}
			}
		}
		return false;
	}
	
	//++++++++++ METHOD-SortByName ++++++++++// 
	
	private static Contact[] sortByName(Contact[] contactArray) {
		Contact[] tempContactArray = new Contact[contactlist.size()];

        for(int i=0; i<contactlist.size(); i++){
			tempContactArray[i]=contactArray[i];
        }

        for (int i = 0; i < contactlist.size() - 1; i++) {
            for (int j = i + 1; j < contactlist.size(); j++) {
                if (contactArray[i].getName().compareTo(contactArray[j].getName()) > 0) {
					
					Contact tempContact = tempContactArray[i];
					tempContactArray[i]=tempContactArray[j];
					tempContactArray[j]=tempContact;
                }
            }
        }
        return tempContactArray;
    }
    
    //++++++++++ METHOD-SortBySalary ++++++++++// 
	
	private static Contact[] sortBySalary(Contact[] contactArray) {
		Contact[] tempContactArray = new Contact[contactlist.size()];

        for(int i=0; i<contactlist.size(); i++){
			tempContactArray[i]=contactArray[i];
        }
        
        for (int i = 0; i < contactlist.size() - 1; i++) {
            for (int j = i + 1; j < contactlist.size(); j++) {
				if (Double.compare(contactArray[i].getSalary(), contactArray[j].getSalary()) > 0) {
					
					Contact tempContact = tempContactArray[i];
					tempContactArray[i]=tempContactArray[j];
					tempContactArray[j]=tempContact;
				}
            }
        }
        return tempContactArray;
    }
    
    //++++++++++ METHOD-SortByBirthday ++++++++++// 
	
	private static Contact[] sortByBirthday(Contact[] contactArray) {
		Contact[] tempContactArray = new Contact[contactlist.size()];

        for(int i=0; i<contactlist.size(); i++){
			tempContactArray[i]=contactArray[i];
        }
        
        for (int i = 0; i < contactlist.size() - 1; i++) {
            for (int j = i + 1; j < contactlist.size(); j++) {
                if (contactArray[i].getBirthday().compareTo(contactArray[j].getBirthday()) > 0) {
					
					Contact tempContact = tempContactArray[i];
					tempContactArray[i]=tempContactArray[j];
					tempContactArray[j]=tempContact;
                }
            }
        }
        return tempContactArray;
    }

	//++++++++++ METHOD-clearConsole ++++++++++//		
	
	public final static void clearConsole() { 
		
		try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}


