package com.example.tablayoutviewpager.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tablayoutviewpager.AdaptadorGallery;
import com.example.tablayoutviewpager.ItemGallery;
import com.example.tablayoutviewpager.R;

import java.util.ArrayList;
import java.util.List;


public class nav_gallery extends Fragment {

    private RecyclerView gRecyclerView;
    private AdaptadorGallery gAdapter;
    private ImageView imageView;
    private List<ItemGallery> datosGallery = new ArrayList<ItemGallery>(){
        {
            add(new ItemGallery(R.drawable.image1, "Card 1", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image2, "Card 2", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image3, "Card 3", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image4, "Card 4", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image5, "Card 5", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image6, "Card 6", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image7, "Card 7", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image8, "Card 8", "Accept", "Cancel"));
            add(new ItemGallery(R.drawable.image9, "Card 9", "Accept", "Cancel"));
        }
    };

    public nav_gallery() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nav_gallery, container, false);

        gRecyclerView = view.findViewById(R.id.recyclerViewGallery);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        gRecyclerView.setLayoutManager(layoutManager);

        // Itera sobre los elementos de la galería y registra cada imagen para el menú contextual
        for (ItemGallery item : datosGallery) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(item.getImg()); // metodo de ItemGallery

            // Registro la vista para el menú contextual
            registerForContextMenu(imageView);
        }

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gRecyclerView =  requireView().findViewById(R.id.recyclerViewGallery);
        gRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        gAdapter = new AdaptadorGallery(datosGallery);

        gRecyclerView.setAdapter(gAdapter);
    }
}