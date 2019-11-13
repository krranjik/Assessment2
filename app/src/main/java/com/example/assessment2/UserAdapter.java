package com.example.assessment2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assessment2.Module.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyHolder> {

    List<User> userList = new ArrayList<>();
    Context contxt;

    public UserAdapter(Context contxt, List<User> userList) {
        this.userList = userList;
        this.contxt = contxt;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_profile_design, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        User user = userList.get(position);
        holder.profileImage.setImageResource(user.getImgg());
        holder.profileName.setText(user.getName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contxt, UserProfile.class);
                User user = userList.get(position);
                intent.putExtra("name", user.getName());
                intent.putExtra("dob", user.getDob());
                intent.putExtra("gender", user.getGender());
                intent.putExtra("country", user.getCountry());
                intent.putExtra("phone", user.getPhone());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("image", user.getImgg());
                contxt.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView profileName;
        RelativeLayout relativeLayout;

        public MyHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profileimg);
            profileName = itemView.findViewById(R.id.profilename);
            relativeLayout = itemView.findViewById(R.id.rlprodesign);

        }
    }
}
