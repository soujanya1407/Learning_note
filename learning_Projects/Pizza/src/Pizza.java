public class Pizza {
    private int price;
    private boolean veg;

    public Pizza(boolean veg) {
      //  this.veg = veg;     // datamember and constructor parameter are same then "this" keyword not required.
        if(veg) {
            this.price = 300;  //this keyword is optional for price
        }
        else{
            this.price=400;  //this keyword is optional for price
        }

        }
// Use of "this" key word.
    /*public Pizza(boolean veg1) {
        this.veg = veg1;   //assigning "veg" variable to boolean value. this key always calling class datamember.
        if(veg1=true) {
             price = 300;
        }
        else{
            price=400;
        }

    }*/

        public void getBills(){
            System.out.println("Pizza price: "+this.price);
        }
}

