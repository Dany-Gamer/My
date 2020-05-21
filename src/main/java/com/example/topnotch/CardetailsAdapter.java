package com.example.topnotch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class CardetailsAdapter extends FirebaseRecyclerAdapter<Cardetails, CardetailsAdapter.CarViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    Context context;
    public CardetailsAdapter(@NonNull FirebaseRecyclerOptions<Cardetails> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final CarViewHolder holder, int position, @NonNull final Cardetails cardet) {
        holder.name.setText(cardet.getName());
        holder.price.setText(String.valueOf(cardet.getPrice()));
        holder.ratings.setText(String.valueOf(cardet.getRatings()));
        Picasso.get().load(cardet.getImg()).into(holder.img);
        holder.btnforBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentPass = new Intent(context,booking.class);
                intentPass.putExtra("img",cardet.getImg());
                intentPass.putExtra("name",cardet.getName());
                intentPass.putExtra("price",cardet.getPrice());
                context.startActivity(intentPass);
            }
        });


    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardetails, parent, false);

        return new CarViewHolder(view);

    }

    class CarViewHolder extends RecyclerView.ViewHolder {
        TextView name, ratings, price;
        ImageView img;
        Button btnforBook;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewName);
            img = itemView.findViewById(R.id.image);
            ratings = itemView.findViewById(R.id.textViewRating);
            price = itemView.findViewById(R.id.textViewPrice);
            btnforBook = itemView.findViewById(R.id.btnforbook);


        }
    }

}


