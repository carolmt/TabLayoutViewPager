package com.example.tablayoutviewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorGallery extends RecyclerView.Adapter<AdaptadorGallery.ViewHolder> {

    private List<ItemGallery> datosGallery;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView cardTextView;
        private final ImageView img;
        private final TextView accept;
        private final TextView cancel;

        public ViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.galleryImg);
            cardTextView = (TextView) view.findViewById(R.id.cardNumText);
            accept = (TextView) view.findViewById(R.id.acceptText);
            cancel = (TextView) view.findViewById(R.id.cancelText);
        }

        public TextView getCardTextView() {
            return cardTextView;
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getAccept() {
            return accept;
        }
        public TextView getCancel() {
            return cancel;
        }

    }
    public AdaptadorGallery(List<ItemGallery> datosGallery) {
        this.datosGallery = datosGallery;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //Crea una nueva vista, que define la interfaz de usuario del elemento de la lista

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gallery_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.getImg().setImageResource(datosGallery.get(position).getImg());
        viewHolder.getCardTextView().setText(datosGallery.get(position).getCardNum());
        viewHolder.getAccept().setText(datosGallery.get(position).getAccept());
        viewHolder.getCancel().setText(datosGallery.get(position).getCancel());

        ItemGallery item = datosGallery.get(position);
        viewHolder.cardTextView.setText(item.getCardNum());
        viewHolder.accept.setText(item.getAccept());
        viewHolder.cancel.setText(item.getCancel());
        viewHolder.img.setImageResource(item.getImg());
    }

    @Override
    public int getItemCount() {
        return datosGallery.size();
    }
}
