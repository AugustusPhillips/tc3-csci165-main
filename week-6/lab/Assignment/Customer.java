import java.util.regex.Matcher; 
import java.util.regex.Pattern; 



public class Customer{
    private String firstName;
    private String lastName;
    private String email;
    private Address Address;

    public Customer() {} //End of Customer() constructor

    public Customer(String firstName, String lastName, String email, Address Address){
        super();
        this.firstName = firstName;
        this.lastName  = lastName;
        this.setEmail(email);
        this.Address   = Address;
    }   //End of Customer(S,S,S,A) constructor

    public Customer(String firstName, String lastName){
        super();
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email = getEmail();
    }   //End of Customer(S,S) constructor

    public void setName(String first, String last){
        this.firstName = first;
        this.lastName  = last;
    }   //End of setName method

    public boolean validEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }   //End of email validation method

    public void setEmail(String email){
        if(validEmail(email) == true){
            this.email = email;
        }else{
            this.email = "none on file";
        }
    }   //End of setEmail method

    public String getName(){
        String nameCopy = this.firstName + this.lastName;
        return nameCopy;
    }   //End of getName method

    public String getEmail(){
        String emailCopy = this.email;
        if(validEmail(emailCopy) == true){
            return emailCopy;
        }else{
            return "none on file";
        }
    }   //End of getEmail method

    public Customer(Customer toClone){
        this.firstName = toClone.firstName;
        this.lastName = toClone.lastName;
        this.email = toClone.email;
        this.Address = toClone.Address;
    }   //End of toCLone

    public boolean equals(Customer otherCustomer){
        return this.firstName.equals(otherCustomer.firstName) &&
               this.lastName.equals(otherCustomer.lastName)	  &&
               this.email.equals(otherCustomer.email)		  &&
               this.Address.equals(otherCustomer.Address); 			
    }   //End of equals method
    public String toString(){
        String string = "Name: ";
        return string +firstName+" "+lastName+
               "\nEmail: "+email+
               "\nAddress: "+Address;
    }   //End of toString method
}   //End of Class