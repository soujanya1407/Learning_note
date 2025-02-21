//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    /*Pizza pizza = new Pizza(true);
    pizza.getBills();*/

    /*Pizza1 pizza1 = new Pizza1(false);
    pizza1.getBills();*/

    /*Pizaa3 pizaa3 = new Pizaa3(true);
    pizaa3.extraCheese();
    pizaa3.getBills();*/

    DeluxPizza dp = new DeluxPizza(false);
    dp.extraCheese(); // It won't work in Delux Pizza
    dp.extraToppings(); // It won't work in  Delix Pizza
    dp.Parcel();  // this one work
    dp.getBills();

    }

}