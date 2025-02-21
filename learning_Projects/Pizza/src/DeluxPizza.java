public class DeluxPizza extends Pizza3 {
    public DeluxPizza(boolean veg) {
        super(veg);
        super.extraCheese();
        super.extraToppings();
        //super.getBills();   //Need to call from main.
    }
    // We OverRiding this method because Add on option we need to remove in Delux Pizza.
    // calling extraCheese and extraToppings from main method won't work.
    @Override
    public void extraCheese() {

    }

    @Override
    public void extraToppings() {

    }
}
