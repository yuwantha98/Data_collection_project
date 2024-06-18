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
