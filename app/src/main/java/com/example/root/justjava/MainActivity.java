package com.example.root.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity);
        String summary = createOrderSummary(quantity, price);
        display(quantity);
//        displayPrice(summary);
//        String priceMessage = "Free";
        displayMessage(summary   );
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view){

        quantity = quantity + 1;
//        quantity = 1 + quantity;
        display(quantity);
    }

    public void decrement(View view){

        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(message);
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(int quantity, int price){
        return "Name : Kaptain Kunal\nQuantity : " + quantity +"\nTotal : $" + price + "\nThank You!";
    }
}
