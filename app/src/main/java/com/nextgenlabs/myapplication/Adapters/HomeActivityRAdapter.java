package com.nextgenlabs.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nextgenlabs.myapplication.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivityRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    public HomeActivityRAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return R.layout.content_home_activity_achieve_section;
        }
        if (position == 1){
            return R.layout.content_home_activity_meetings_deadline_section;
        }
        else return R.layout.content_home_activity_project_section;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;

        if(viewType == R.layout.content_home_activity_achieve_section){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_activity_achieve_section, parent, false);
            holder = new AchieveSecHolder(view);
        }
        if(viewType == R.layout.content_home_activity_meetings_deadline_section){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_activity_meetings_deadline_section, parent, false);
            holder = new MeetingSecHolder(view);
        }
        if(viewType == R.layout.content_home_activity_project_section){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home_activity_project_section, parent, false);
            holder = new ProjectSecHolder(view);
        }
        assert holder != null;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof AchieveSecHolder){
            ((AchieveSecHolder) holder).achieveText.setHint("What you want \n to achieve today");
            ((AchieveSecHolder) holder).resetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((AchieveSecHolder) holder).achieveText.setText(null);
                    ((AchieveSecHolder) holder).achieveText.setHint("What you want \n to achieve today");
                }
            });
        }

        if(holder instanceof MeetingSecHolder){
            ((MeetingSecHolder) holder).meetingRecyclerView.setAdapter(new contentMeetingRVAdapter(context));
            ((MeetingSecHolder) holder).meetingRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        }

        if(holder instanceof ProjectSecHolder){
            ((ProjectSecHolder) holder).projectRecyclerView.setAdapter(new ContentProjectRvAdapter(context));
            ((ProjectSecHolder) holder).projectRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class AchieveSecHolder extends RecyclerView.ViewHolder {
        EditText achieveText;
        Button resetBtn;
        public AchieveSecHolder(@NonNull View itemView) {
            super(itemView);
            achieveText = itemView.findViewById(R.id.content_home_activity_achieve_textView);
            resetBtn = itemView.findViewById(R.id.content_home_activity_achieve_resetButton);
        }
    }

    public static class MeetingSecHolder extends RecyclerView.ViewHolder {
        RecyclerView meetingRecyclerView;
        public MeetingSecHolder(@NonNull View itemView) {
            super(itemView);
            meetingRecyclerView = itemView.findViewById(R.id.content_home_activity_meeting_section_recyclerView);
        }
    }

    public static class ProjectSecHolder extends RecyclerView.ViewHolder {
        RecyclerView projectRecyclerView;
        public ProjectSecHolder(@NonNull View itemView) {
            super(itemView);
            projectRecyclerView = itemView.findViewById(R.id.content_home_activity_project_section_recyclerView);
        }
    }
}
