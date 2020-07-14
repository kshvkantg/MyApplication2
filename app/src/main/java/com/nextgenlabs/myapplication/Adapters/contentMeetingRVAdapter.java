package com.nextgenlabs.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nextgenlabs.myapplication.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class contentMeetingRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    public contentMeetingRVAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2 == 0){
            return 0;
        }
        else return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_meeting_deadline_recycler_view_meeting, parent, false);
            viewHolder = new MeetingHolder(view);
        }
        if (viewType == 1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_meeting_deadline_recycler_view_deadline, parent, false);
            viewHolder = new DeadlineHolder(view);
        }
        assert viewHolder != null;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MeetingHolder){
            ((MeetingHolder) holder).mAgenda.setText("Meeting Agenda");
            ((MeetingHolder) holder).mDate.setText("14 jul 20");
            ((MeetingHolder) holder).mTime.setText("00:21");
            ((MeetingHolder) holder).mPeople.setText("Keshav Kant");
            ((MeetingHolder) holder).constraintLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
                }
            });

        }
        if (holder instanceof DeadlineHolder){
            ((DeadlineHolder) holder).dAgenda.setText("Deadline Agenda");
            ((DeadlineHolder) holder).dDate.setText("14 jul 20");
            ((DeadlineHolder) holder).dTime.setText("00:21");
            ((DeadlineHolder) holder).constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    private static class MeetingHolder extends RecyclerView.ViewHolder {
        TextView mAgenda,mTime,mDate,mPeople;
        ConstraintLayout constraintLayout2;
        public MeetingHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout2 = itemView.findViewById(R.id.content_meeting_deadline_recycler_view_meeting);
            mAgenda = itemView.findViewById(R.id.content_meeting_deadline_rv_meetingAgenda);
            mTime = itemView.findViewById(R.id.content_meeting_deadline_meetingTime);
            mDate = itemView.findViewById(R.id.content_meeting_deadline_rv_meetingDate);
            mPeople = itemView.findViewById(R.id.content_meeting_deadline_meetingIntrest);
        }
    }

    private static class DeadlineHolder extends RecyclerView.ViewHolder {
        TextView dAgenda,dTime,dDate;
        ConstraintLayout constraintLayout;
        public DeadlineHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.content_meeting_deadline_recycler_view_deadline);
            dAgenda = itemView.findViewById(R.id.content_meeting_deadline_rv_deadlineAgenda);
            dTime = itemView.findViewById(R.id.content_meeting_deadline_deadLineTime);
            dDate = itemView.findViewById(R.id.content_meeting_deadline_rv_deadlineDate);
        }
    }
}
