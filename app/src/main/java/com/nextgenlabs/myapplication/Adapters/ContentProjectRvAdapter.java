package com.nextgenlabs.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nextgenlabs.myapplication.R;
import com.nextgenlabs.myapplication.ui.Activity.ProjectActivity;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class ContentProjectRvAdapter extends RecyclerView.Adapter<ContentProjectRvAdapter.ProjectViewHolder> {
    Context context;

    public ContentProjectRvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_project_rv, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProjectViewHolder holder, int position) {
        holder.contentProjectConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProjectActivity.class);
                context.startActivity(intent);
            }
        });
        holder.projectHeading.setText("Project Heading");
        holder.projectIntro.setText("Using the attribute android:onClick we declare the method name that has to be present on the parent activity. So I have to create this method inside our activity like that:");
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout contentProjectConstraintLayout;
        TextView projectHeading,projectIntro;
        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            contentProjectConstraintLayout = itemView.findViewById(R.id.content_project_rv_layout);
            projectHeading = itemView.findViewById(R.id.content_project_rv_ProjectHeading);
            projectIntro = itemView.findViewById(R.id.content_project_rv_ProjectIntro);
        }
    }
}
