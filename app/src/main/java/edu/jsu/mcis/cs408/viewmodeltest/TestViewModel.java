package edu.jsu.mcis.cs408.viewmodeltest;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestViewModel extends ViewModel {

    private Context context;

    private final MutableLiveData<ArrayList<Customer>> customers = new MutableLiveData<ArrayList<Customer>>();

    public void init(Context context) {
        this.context = context;
        if (customers.getValue() == null) {
            customers.setValue(new ArrayList<Customer>());
            loadCustomers();
        }
    }

    public LiveData<ArrayList<Customer>> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer c) {
        if (customers.getValue() != null) {
            customers.getValue().add(c);
        }
    }

    private void loadCustomers() {

        // Open "input.csv" input file (from "raw" resources folder)

        String line;
        String[] fields;
        final int FIELD_LENGTH = 7;

        int id = R.raw.input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(id)));

        // Process records

        try {

            line = reader.readLine(); // skip header row

            while ((line = reader.readLine()) != null) {
                fields = line.trim().split(",");
                if (fields.length == FIELD_LENGTH) {
                    Customer c = new Customer(fields); // create new "Customer" object
                    customers.getValue().add(c);       // add to model
                }
            }

        } catch (Exception e) {
            Log.e("TestViewModel", e.toString());
        }

    }

}