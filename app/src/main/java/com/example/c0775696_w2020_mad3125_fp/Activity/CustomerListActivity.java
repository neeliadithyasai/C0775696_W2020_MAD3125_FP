package com.example.c0775696_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0775696_w2020_mad3125_fp.Adapter.CustomerAdapter;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.R;
import com.example.c0775696_w2020_mad3125_fp.Util.DataSingelton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomers;
    private ArrayList customers;
    private ArrayList customerArrayList;
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        rvCustomers =findViewById(R.id.rv_customer_list);

        rvCustomers = findViewById(R.id.rv_customer_list);
        populateCustomers();

        customerAdapter = new CustomerAdapter(customers);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCustomers.setLayoutManager(mLinearLayoutManager);
        rvCustomers.setAdapter(customerAdapter);

    }

    private void populateCustomers() {
        DataSingelton.getInstance().populateData();
        customers = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataSingelton.getInstance().getCustomerMap();
        Collection<Customer> demoValues = customerHashMap.values();
        customerArrayList = new ArrayList<>(demoValues);
        customers.addAll(customerArrayList);

    }

}
