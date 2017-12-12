package com.dueller.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
    TODO:
        - Add user to database
        - Add name to user in database
        - Add picture to Firestore and add field
*/


public class DuelAdapter extends FirestoreAdapter<DuelAdapter.ViewHolder> {


    public interface OnDuelSelectedListener {

        void onDuelSelected(DocumentSnapshot duel);

    }

    private OnDuelSelectedListener mListener;

    public DuelAdapter(Query query, OnDuelSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_duel, parent, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    // Implementing our ViewHolder.
    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userVs)
        TextView userVs;

        @BindView(R.id.skill)
        TextView skill;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot,
                         final OnDuelSelectedListener listener) {
            Duel duel = snapshot.toObject(Duel.class);
            Resources resources = itemView.getResources();

            String [] users = duel.getParticipants();
            String duel_skill = duel.getSkill();
            String userVsText;

            // hopefully array contains 2 users
            // but if not have a backup.
            if (users != null && users.length == 2) {
                userVsText = users[0] + " VS " + users[1];
            } else {
                userVsText = "Dueller vs Dueller";
            }

            userVs.setText(userVsText);
            skill.setText(duel_skill);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onDuelSelected(snapshot);
                    }
                }
            });
        }

    }



}


