package com.atinagnihotri.uisandbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Contact> contacts = new ArrayList<>(); // Need to initialise it, otherwise will get a NullPointerException

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged(); // Notify adapter that dataset has changed, so it can refresh
    }


    public ContactsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // The purpose of this method is to create an instance of our viewholder class for every item in our recycler view
        // ViewGroup parent of all the Layout types
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.contacts_list_item,
                parent, // Tells where do you want to attach your View obj
                false // False, since we are already passing the parent. Can set to true if we passed Null in prev arg
        ); // Wil inflate a layout

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
        Glide
                .with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .into(holder.contactImage);
        holder.recyclerParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Calling " + contacts.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private CardView recyclerParent;
        private TextView txtEmail;
        private ImageView contactImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            contactImage = itemView.findViewById(R.id.contactImage);
            recyclerParent = itemView.findViewById(R.id.recyclerParent);
        }
    }
}
