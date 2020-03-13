



public class Product{
    private String name;
    private String description;
    private double price;
    private String sku;

    public Product() {}   //End of Product() constructor

    public Product(String name, String description, double price, String sku){
        super();
        this.name = name;
        this.description = description;
        setPrice(price);
        setSku(sku);
    }   //End of Product(S,S,d,S) constructor

    public Product(String sku){
        super();
        setSku(sku);
    }   //End of Product(S) constructor 

    public void setName(String name){
        this.name = name;
    }   //End of setName method

    public String getName(){
        String nameCopy = this.name;
        return nameCopy;
    }   //End of getName method

    public boolean validSku(String sku){
        String[] skuStart = {"001","002","003","004","110"};
        int count = 0;
        for(int i = 0; i<5; i++){
            if(sku.length() == 10 && sku.startsWith(skuStart[i])) count = 1;
        }
        if(count == 1) return true;
        else return false;
    }

    public void setSku(String sku){
        if(validSku(sku) == true) this.sku = sku;
        else this.sku = "Invalid sku";
    }   //End of setSKu method

    public void setPrice(double price){
        if(price < 0) this.price = 0;
        else this.price = price;
    }   //End of setPrice method

    public double getPrice(){
        return price;
    }   //End of getPrice method

    public Product(Product toClone){
        this.description = toClone.description;
        this.name        = toClone.name;
        this.price       = toClone.price;
        this.sku         = toClone.sku;
    }

    public boolean equals(Product otherProduct){
        return this.name.equals(otherProduct.name)               &&
               this.description.equals(otherProduct.description) &&
               this.price == otherProduct.price                  &&
               this.sku.equals(otherProduct.sku);
    }   //End of equals method

    public String toString(){

        return name +", "+ description +", "+ price +", "+ sku;
    }   //ENd of toString method
}   //End of Product class