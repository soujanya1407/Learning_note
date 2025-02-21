public class Pizza3 {
    private int price;
    private boolean veg;

    private  int extraCheese= 100;
    private  int extraToppings=150;
    private int parcelCharge = 20;
    private int basePrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isParcelChargeAdded = false;



    public Pizza3(boolean veg) {
        // this.veg = veg;
        if(veg) {
            this.price = 300;
        }
        else{
            this.price=400;
        }
        basePrice=this.price;
    }

    public void extraCheese()
    {
        this.price+=extraCheese;
         isExtraCheeseAdded = true;

    }
    public void extraToppings(){
        this.price+=extraToppings;
        isExtraToppingsAdded = true;

    }

    public void Parcel(){
        this.price+=parcelCharge;

    }

    public void getBills(){
        System.out.println("base price: "+basePrice);

        String bill = "";
        if(isExtraCheeseAdded){
            bill+= "ExtraCheeseAdded: "+extraCheese+'\n';
        }
        if(isExtraToppingsAdded){
            bill+= "ExtraToppingsAdded: "+extraToppings+'\n';
        }
        if(isParcelChargeAdded){
            bill+= "ParcelCharge: "+parcelCharge+'\n';
        }
        bill+="Bill: "+this.price+"\n";
        System.out.println(bill);
    }

}

