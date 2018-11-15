package com.example.charles.bookalobia.viewbook;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charles.bookalobia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewBookFragment extends Fragment {


    public ViewBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_book, container, false);
    }

}
