public class Pizza2
{
    private int price;
    private boolean veg;

    private  int extraCheese= 100;
    private  int extraToppings=150;
    private int parcelCharge = 20;
    private int basePrice;

    public Pizza2(boolean veg) {
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
        System.out.println("Extra cheese Added: 100");
    }
    public void extraToppings(){
        this.price+=extraToppings;
        System.out.println("Extra Toppings Added: 150");
    }

    public void Parcel(){
        this.price+=parcelCharge;
        System.out.println("Parcel charge added");
    }

    public void getBills(){
        System.out.println("Pizza price: "+this.price);
    }

}
