package com.example.sath1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOnline extends Fragment {
    View view;
    Button b1,b2;
    public FragmentOnline() {

    }

    @Nullable
    @Override
    public View onCreateView( @Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.online,container,false);

        b1=(Button) view.findViewById(R.id.loginbutton);
        b2=(Button) view.findViewById(R.id.signbutton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),login.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),signup.class));
            }
        });
        return view;

    }
}
