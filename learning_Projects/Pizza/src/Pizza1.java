public class Pizza1
{
    private int price;
    private boolean veg;

    public Pizza1(boolean veg) {
       // this.veg = veg;
        if(veg) {
            this.price = 300;
        }
        else{
            this.price=400;
        }

    }

    public void extraCheese()
    {
        this.price+=100;
        System.out.println("Extra cheese Added: 100");
    }
    public void extraToppings(){
        this.price+=150;
        System.out.println("Extra Toppings Added: 150");
    }

    public void Parcel(){
        this.price+=20;
        System.out.println("Parcel charge added");
    }

    public void getBills(){
        System.out.println("Pizza price: "+this.price);
    }

}
