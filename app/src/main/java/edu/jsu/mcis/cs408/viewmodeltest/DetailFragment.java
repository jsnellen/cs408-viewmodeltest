package edu.jsu.mcis.cs408.viewmodeltest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment implements TabFragment {

    private final String TAB_TITLE = "Details";
    private TestViewModel model;
    private TextView output;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(TestViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        output = (TextView) view.findViewById(R.id.detail_output);
        updateView();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
    }

    private void updateView() {

        model.getCustomers().observe(getViewLifecycleOwner(), customers -> {
            StringBuilder s = new StringBuilder();
            for (Customer c : customers) {
                s.append(c);
            }
            output.setText(s.toString());
        });

    }

    public String getTabTitle() { return TAB_TITLE; }

}