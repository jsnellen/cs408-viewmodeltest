package edu.jsu.mcis.cs408.viewmodeltest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InputFragment extends Fragment implements TabFragment {

    private final String TAB_TITLE = "Input";
    private TestViewModel model;
    private TextView output;

    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get shared model instance

        model = new ViewModelProvider(requireActivity()).get(TestViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        output = (TextView) view.findViewById(R.id.list_output);
        view.findViewById(R.id.list_input).setOnClickListener(this::onClick);

    }

    public void onClick(View v) {

        // Add new record when input button is tapped

        String[] fields = { "John", "Q", "Smith", "123 Main Street", "Anywhere", "US", "12345" };

        Customer c = new Customer(fields);
        model.addCustomer(c);

        output.setText("New Customer Added!");

    }

    public String getTabTitle() { return TAB_TITLE; }

}