class ContactList{
	private Contact[] contactArray;      // Array to store contact objects
    private int nextIndex;               // The index where the next contact will be added
    private int size;                    // Initial size of the contact array
    private int loadFactor;              // Number of additional elements to be added when extending the array
	
//-------------Constructor-----------------//
	
	ContactList(int size, int loadFactor){
		contactArray = new Contact[size];
		nextIndex=0;
		this.size=size;
		this.loadFactor=loadFactor;
	}
	
//-----------Check the Array is full Methode-----------------//
	
	private boolean isFull(){
		return nextIndex>=size;
	}
	
//-----------Array size increase-----------//
	
	private void extendArrays(){
		Contact[] tempContactArray = new Contact[loadFactor+size];
		for(int i=0; i<nextIndex; i++){
			tempContactArray[i]=contactArray[i];
		}
		contactArray=tempContactArray;
	}
	
//-----------Add a contact to the list-----------//
	
	public void add(Contact contact){
		if(isFull()){
			extendArrays();
		}
		contactArray[nextIndex++]=contact;
	}
	
//----------Get contact Array value-----------//
	
	public Contact[] getContactArray(){
		return this.contactArray;
	}
	
//----------Get nextIndex value----------//
	
	public int getNextIndex(){
		return this.nextIndex;
	}
	
//-----------Delete contact----------//
	
	public void deleteContact(int index){
		if(isValidIndex(index)){
			for (int i = index; i < nextIndex-1; i++){
				contactArray[i]=contactArray[i+1];
			}
			nextIndex--;
		}
	}
	
//-----------Check the index is valid-----------------//
	
	private boolean isValidIndex(int index){
		return index>=0 && index<nextIndex;
	}

}


