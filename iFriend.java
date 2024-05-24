import java.util.*;
import java.time.LocalDate; 
class iFriend{
//------------------------------MAIN METHOD------------------------------//

	public static void main(String args[]){
		HomePage();
	}
	
//------------------------------STATIC VARIABLES------------------------------//

	public static int IDNum=1;
	public static String[] ContactIDArray = new String[0];
	public static String[] NameArray = new String[0];
	public static String[] PhoneNoArray = new String[0];
	public static String[] CompanyArray = new String[0];
	public static double[] SalaryArray = new double[0];
	public static String[] BirthdayArray = new String[0];
	
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
		String ID="";
		String tele="";
		String Bday="";
		
	do{
		clearConsole();
		System.out.println("\n+------------------------------------------------------------+");
		System.out.println("|                ADD CONTACT TO THE LIST                     |");
		System.out.println("+------------------------------------------------------------+\n");
		
		ID=IDGenerator(IDNum++); //------ calling IDGenerator --------
		System.out.println("\n "+ID);
		System.out.println("=======");
		System.out.print("\nName\t\t: ");
		String name=input.nextLine();
		
	do{
		System.out.print("Phone Number\t: ");
		tele=input.nextLine();
	}while(!PhoneNoValidator(tele));
		
		System.out.print("Company Name\t: ");
		String company=input.nextLine();
		
	do{
		System.out.print("Salary\t\t: ");
		salary=input.nextDouble();
		input.nextLine();
	}while(!SalaryValidator(salary));
	
	do{
		System.out.print("B'Day(YYYY-MM-DD): ");
		Bday=input.next();
		if(!BirthdayValidator(Bday)){
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
		
		ArrayExtender();
		
		ContactIDArray[ContactIDArray.length-1]=ID;
		NameArray[NameArray.length-1]=name;
		PhoneNoArray[PhoneNoArray.length-1]=tele;
		CompanyArray[CompanyArray.length-1]=company;
		SalaryArray[SalaryArray.length-1]=salary;
		BirthdayArray[BirthdayArray.length-1]=Bday;
		
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
		
		int i = SEARCHER(search);
		
		if(i != -1){
			System.out.println("\n\tContact ID\t\t: "+ContactIDArray[i]);
			System.out.println("\tName\t\t\t: "+NameArray[i]);
			System.out.println("\tPhone Number\t\t: "+PhoneNoArray[i]);
			System.out.println("\tCompany Name\t\t: "+CompanyArray[i]);
			System.out.println("\tSalary\t\t\t: "+SalaryArray[i]);
			System.out.println("\tB'Day(YYYY-MM-DD)\t: "+BirthdayArray[i]);
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
					String confirmNewName=input.nextLine();
					
				if(newName.equalsIgnoreCase(confirmNewName)){
					NameArray[i]=newName;
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
					String confirmNewPhoneNo=input.nextLine();
					if(newPhoneNo.equals(confirmNewPhoneNo)){
						if(PhoneNoValidator(newPhoneNo)){
							PhoneNoArray[i]=newPhoneNo;
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
							continue L1;
						}
					}else{
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
					String confirmNewCoName=input.nextLine();
					
					if(newCoName.equalsIgnoreCase(confirmNewCoName)){
						CompanyArray[i]=newCoName;
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
					double confirmNewSalary=input.nextDouble();
					if(newSalary==confirmNewSalary){
						if(SalaryValidator(newSalary)){
							SalaryArray[i]=newSalary;
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
							continue L1;
						}
					}else{
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
			
		int i = SEARCHER(search);
		
		if(i != -1){
			System.out.println("\n\tContact ID\t\t: "+ContactIDArray[i]);
			System.out.println("\n\tName\t\t\t: "+NameArray[i]);
			System.out.println("\tPhone Number\t\t: "+PhoneNoArray[i]);
			System.out.println("\tCompany Name\t\t: "+CompanyArray[i]);
			System.out.println("\tSalary\t\t\t: "+SalaryArray[i]);
			System.out.println("\tB'Day(YYYY-MM-DD)\t: "+BirthdayArray[i]);
			System.out.print("\n\nWhat Do You Want To Delete This Contact ? [Y/N] -> ");
			String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						ArrayNarrower(i);
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
				
			int i = SEARCHER(search);
			
			if(i != -1){
				System.out.println("\n\tContact ID\t\t: "+ContactIDArray[i]);
				System.out.println("\n\tName\t\t\t: "+NameArray[i]);
				System.out.println("\tPhone Number\t\t: "+PhoneNoArray[i]);
				System.out.println("\tCompany Name\t\t: "+CompanyArray[i]);
				System.out.println("\tSalary\t\t\t: "+SalaryArray[i]);
				System.out.println("\tB'Day(YYYY-MM-DD)\t: "+BirthdayArray[i]);
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
                    
                    sortByName(NameArray, ContactIDArray, PhoneNoArray, CompanyArray, SalaryArray,  BirthdayArray);
                    
                    for (int i = 0; i < NameArray.length; i++) {
						System.out.printf("| %-12s | %-9s | %-16s | %-11s | %-10s | %-12s |\n",ContactIDArray[i], NameArray[i], PhoneNoArray[i], CompanyArray[i], SalaryArray[i], BirthdayArray[i]);
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
                    
                    sortBySalary(NameArray, ContactIDArray, PhoneNoArray, CompanyArray, SalaryArray,  BirthdayArray);
                    
                    for (int i = 0; i < SalaryArray.length; i++) {
						System.out.printf("| %-12s | %-9s | %-16s | %-11s | %-10s | %-12s |\n",ContactIDArray[i], NameArray[i], PhoneNoArray[i], CompanyArray[i], SalaryArray[i], BirthdayArray[i]);
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
                    
                    sortByBirthday(NameArray, ContactIDArray, PhoneNoArray, CompanyArray, SalaryArray,  BirthdayArray);
                    
                    for (int i = 0; i < BirthdayArray.length; i++) {
						System.out.printf("| %-12s | %-9s | %-16s | %-11s | %-10s | %-12s |\n",ContactIDArray[i], NameArray[i], PhoneNoArray[i], CompanyArray[i], SalaryArray[i], BirthdayArray[i]);
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
		
	public static boolean PhoneNoValidator(String tele){
		Scanner input=new Scanner(System.in);	
		
		//ASCii Value of '0' = 48//
		if(tele.charAt(0)!=48 || tele.length()!=10){
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
		
	public static boolean BirthdayValidator(String Bday){
		
		if((Bday.substring(4,5)).equals("-") && (Bday.substring(7,8)).equals("-")){
			int sub1=Integer.valueOf(Bday.substring(0,4));
			int sub2=Integer.valueOf(Bday.substring(5,7));
			int sub3=Integer.valueOf(Bday.substring(8,10));
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
	//++++++++++ METHOD-ArrayNarrower ++++++++++//	
	
	public static void ArrayNarrower(int n){
		
		String[] tempContactIDArray = new String[ContactIDArray.length-1];
		String[] tempNameArray = new String[NameArray.length-1];
		String[] tempPhoneNoArray = new String[PhoneNoArray.length-1];
		String[] tempCompanyArray = new String[CompanyArray.length-1];
		double[] tempSalaryArray = new double[SalaryArray.length-1];
		String[] tempBirthdayArray = new String[BirthdayArray.length-1];
		
		for(int i=0,a=0;i<NameArray.length;i++){
            if(i!=n){
				tempContactIDArray[a]=ContactIDArray[i];
                tempNameArray[a]=NameArray[i];
				tempPhoneNoArray[a]=PhoneNoArray[i];
				tempCompanyArray[a]=CompanyArray[i];
				tempSalaryArray[a]=SalaryArray[i];
				tempBirthdayArray[a]=BirthdayArray[i];
				a++;
            }
        }
				ContactIDArray=tempContactIDArray;
				NameArray=tempNameArray;
				PhoneNoArray=tempPhoneNoArray;
				CompanyArray=tempCompanyArray;
				SalaryArray=tempSalaryArray;
				BirthdayArray=tempBirthdayArray;
		}
		
	//++++++++++ METHOD-ArrayExtender ++++++++++//		
	
	public static void ArrayExtender(){
		
		String[] tempContactIDArray = new String[ContactIDArray.length+1];
		String[] tempNameArray = new String[NameArray.length+1];
		String[] tempPhoneNoArray = new String[PhoneNoArray.length+1];
		String[] tempCompanyArray = new String[CompanyArray.length+1];
		double[] tempSalaryArray = new double[SalaryArray.length+1];
		String[] tempBirthdayArray = new String[BirthdayArray.length+1];
		
		for (int i = 0; i < NameArray.length; i++){
			
			tempContactIDArray[i]=ContactIDArray[i];
			tempNameArray[i]=NameArray[i];
			tempPhoneNoArray[i]=PhoneNoArray[i];
			tempCompanyArray[i]=CompanyArray[i];
			tempSalaryArray[i]=SalaryArray[i];
			tempBirthdayArray[i]=BirthdayArray[i];
		}
			ContactIDArray=tempContactIDArray;
			NameArray=tempNameArray;
			PhoneNoArray=tempPhoneNoArray;
			CompanyArray=tempCompanyArray;
			SalaryArray=tempSalaryArray;
			BirthdayArray=tempBirthdayArray;
	}
	
	//++++++++++ METHOD-SEARCHER ++++++++++//	
	
	public static int SEARCHER(String search){
		
		for (int i = 0; i < NameArray.length ; i++){
			if(NameArray[i].equalsIgnoreCase(search) || PhoneNoArray[i].equals(search)){
				return i;
			}
		}
		return -1;
	}
	
	//++++++++++ METHOD-SortByName ++++++++++// 
	
	private static void sortByName(String[] NameArray, String[] ContactIDArray, String[] PhoneNoArray, String[] CompanyArray, double[] SalaryArray, String[] BirthdayArray) {
        for (int i = 0; i < NameArray.length - 1; i++) {
            for (int j = i + 1; j < NameArray.length; j++) {
                if (NameArray[i].compareTo(NameArray[j]) > 0) {
                    
                    String tempName = NameArray[i];
                    NameArray[i] = NameArray[j];
                    NameArray[j] = tempName;

                    String tempId = ContactIDArray[i];
                    ContactIDArray[i] = ContactIDArray[j];
                    ContactIDArray[j] = tempId;
                    
                    String tempnum = PhoneNoArray[i];
                    PhoneNoArray[i] = PhoneNoArray[j];
                    PhoneNoArray[j] = tempnum;
                    
                    String tempcompany = CompanyArray[i];
                    CompanyArray[i] = CompanyArray[j];
                    CompanyArray[j] = tempcompany;
                    
                    double tempsalary = SalaryArray[i];
                    SalaryArray[i] = SalaryArray[j];
                    SalaryArray[j] = tempsalary;
                    
                    String tempbirth = BirthdayArray[i];
                    BirthdayArray[i] = BirthdayArray[j];
                    BirthdayArray[j] = tempbirth;
                }
            }
        }
    }
    
    //++++++++++ METHOD-SortBySalary ++++++++++// 
	
	private static void sortBySalary(String[] NameArray, String[] ContactIDArray, String[] PhoneNoArray, String[] CompanyArray, double[] SalaryArray, String[] BirthdayArray) {
        for (int i = 0; i < SalaryArray.length - 1; i++) {
            for (int j = i + 1; j < SalaryArray.length; j++) {
                if (SalaryArray[i] > SalaryArray[j]) {
                    
                    String tempName = NameArray[i];
                    NameArray[i] = NameArray[j];
                    NameArray[j] = tempName;

                    String tempId = ContactIDArray[i];
                    ContactIDArray[i] = ContactIDArray[j];
                    ContactIDArray[j] = tempId;
                    
                    String tempnum = PhoneNoArray[i];
                    PhoneNoArray[i] = PhoneNoArray[j];
                    PhoneNoArray[j] = tempnum;
                    
                    String tempcompany = CompanyArray[i];
                    CompanyArray[i] = CompanyArray[j];
                    CompanyArray[j] = tempcompany;
                    
                    double tempsalary = SalaryArray[i];
                    SalaryArray[i] = SalaryArray[j];
                    SalaryArray[j] = tempsalary;
                    
                    String tempbirth = BirthdayArray[i];
                    BirthdayArray[i] = BirthdayArray[j];
                    BirthdayArray[j] = tempbirth;
                }
            }
        }
    }
    
    //++++++++++ METHOD-SortByBirthday ++++++++++// 
	
	private static void sortByBirthday(String[] NameArray, String[] ContactIDArray, String[] PhoneNoArray, String[] CompanyArray, double[] SalaryArray, String[] BirthdayArray) {
        for (int i = 0; i < BirthdayArray.length - 1; i++) {
            for (int j = i + 1; j < BirthdayArray.length; j++) {
                if (BirthdayArray[i].compareTo(BirthdayArray[j]) > 0) {
                    
                    String tempName = NameArray[i];
                    NameArray[i] = NameArray[j];
                    NameArray[j] = tempName;

                    String tempId = ContactIDArray[i];
                    ContactIDArray[i] = ContactIDArray[j];
                    ContactIDArray[j] = tempId;
                    
                    String tempnum = PhoneNoArray[i];
                    PhoneNoArray[i] = PhoneNoArray[j];
                    PhoneNoArray[j] = tempnum;
                    
                    String tempcompany = CompanyArray[i];
                    CompanyArray[i] = CompanyArray[j];
                    CompanyArray[j] = tempcompany;
                    
                    double tempsalary = SalaryArray[i];
                    SalaryArray[i] = SalaryArray[j];
                    SalaryArray[j] = tempsalary;
                    
                    String tempbirth = BirthdayArray[i];
                    BirthdayArray[i] = BirthdayArray[j];
                    BirthdayArray[j] = tempbirth;
                }
            }
        }
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


