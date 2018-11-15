package com.example.charles.bookalobia.mybooks;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.charles.bookalobia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyBooksFragment extends Fragment implements View.OnClickListener {

    private Button btnViewBook;

    private Button btnFavBooks;

    private Activity activity;

    public MyBooksFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity)
            activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_books, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnViewBook = view.findViewById(R.id.btnViewBook);
        btnFavBooks = view.findViewById(R.id.btnFavBooks);
        btnViewBook.setOnClickListener(this);
        btnFavBooks.setOnClickListener(this);

        Navigation.createNavigateOnClickListener(R.id.btnViewBook, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnViewBook:
                Navigation.findNavController(v).navigate(R.id.action_myBooksFragment_to_viewBookFragment);
                break;
            case R.id.btnFavBooks:
                Navigation.findNavController(v).navigate( R.id.action_myBooksFragment_to_favoriteBooksFragment);
                break;
        }
    }
}
