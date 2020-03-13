import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Address{

	private        String 	   street;
	private        String 	   city;
	private        String 	   state;
	private        String 	   zip;
	private static String[][]  zip_list;

	static{

		fillZipList();
	}	//End of static block

	public Address() {}

	public Address(String s, String z){
		super();
		this.street = s;
		this.zip 	= z;
		this.city 	= getCity();
		this.state 	= getState();

	}

	private static void fillZipList(){
		zip_list                  = new String[99951][3];
        String[]       lineList   = new String[15];
        String         csvFile    = "zip_code_database.csv";
        BufferedReader br         = null;
        String         line       = "";
        String         cvsSplitBy = ",";
        int            zipListColumn;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            for(int i = 0;i < 42632; i++){
                zipListColumn = 0;
                line          = br.readLine();
                lineList      = line.split(cvsSplitBy);
                int zipcode   = Integer.parseInt(lineList[0]);

                for(int lineListIndex = 0; lineListIndex < 4; lineListIndex +=3){
                    zip_list[zipcode][zipListColumn] = lineList[lineListIndex];
                    zipListColumn++;
				}	//End of zipCode and County reading loop
				int j = 0;
				while((zip_list[zipcode][2]) == null){
					if(lineList[j].length() == 2){
						zip_list[zipcode][2] = lineList[j];	
					}
					j++;
				}	//End of State reading loop
				
			}	//End of file reading loop
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
        
	}	//End of fillZipList method
	
	public void setStreet(String street){
		this.street = street;

	}	//End of SetStreet method

	public String getStreet(){
		String streetCopy = this.street;
		return streetCopy;
	}	//End of getStreet method

	public String getCity(){
		setZip(zip);
		String cityCopy = this.city;
		return cityCopy;

	}	//End of getCity method

	public String getState(){
		setZip(zip);
		String stateCopy = this.state;
		return stateCopy;
	
	}	//End of getState method

	public void setZip(String zip){
		int zipcode = Integer.parseInt(zip);
		if(zip_list[zipcode][0] != null){
			this.zip   = zip;
			this.city  = zip_list[zipcode][1];
			this.state = zip_list[zipcode][2];
		}else{
			int countHigher = 0;
			int countLower = 0;
			while(zip_list[zipcode+countHigher][0] == null && 
				  zipcode + countHigher <= 99950){
				countHigher++;
			}
			while(zip_list[zipcode-countLower][0] == null && 
				  zipcode - countLower >= 1){
				countLower++;
			}
			if(zip_list[zipcode+countHigher][0] != null && 
			   zip_list[zipcode-countLower][0]  != null){
				if(countLower >= countHigher && 
			   	   zip_list[zipcode+countHigher][0] != null) {
					zipcode += countHigher;	
				}
				if(countHigher > countLower && 
				   zip_list[zipcode-countLower][0] != null){
					zipcode -= countLower;
				}
			}
			else{
				if(zip_list[zipcode+countHigher][0] == null) zipcode -= countLower;
				if(zip_list[zipcode-countLower][0] == null) zipcode += countHigher;
			}
			
			this.zip   = Integer.toString(zipcode);
			this.city  = zip_list[zipcode][1];
			this.state = zip_list[zipcode][2];
		}

	}	//End of setZip method
	public String getZip(){
		String zipCopy = this.zip;
		return zipCopy;
	}	//End of getZip method
	public Address(Address toClone){
        this.street	= toClone.street;
        this.city   = toClone.city;
		this.state  = toClone.state;
		this.zip    = toClone.zip;
    }

	public boolean equals(Address a){
		return 	this.street.equals(a.street) 	&&
				this.city.equals(a.city) 		&&
				this.state.equals(a.state) 		&&
				this.zip.equals(a.zip);

	}
	public String toString(){
		return street + ", " + city + ", " + state + ", " + zip;
	}
}
