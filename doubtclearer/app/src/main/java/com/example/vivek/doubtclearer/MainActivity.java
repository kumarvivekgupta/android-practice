package com.example.vivek.doubtclearer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private EditText editmessage;
    private DatabaseReference mDatabase;
    private RecyclerView mMessagelist;
private FirebaseAuth mAuth;
private FirebaseAuth.AuthStateListener mAuthListener;
private FirebaseUser mCurrentUser;
private DatabaseReference mDatabaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editmessage = (EditText) findViewById(R.id.sentmessage);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Messages");
        mMessagelist = (RecyclerView) findViewById(R.id.messageRec);
        mMessagelist.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        mMessagelist.setLayoutManager(linearLayoutManager);
        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               if(firebaseAuth.getCurrentUser()==null)
               {
                  startActivity(new Intent(MainActivity.this,RegisterActivity.class));
               }
            }
        };
    }

    public void send_clicked(View view) {
        mCurrentUser=mAuth.getCurrentUser();
        mDatabaseUser=FirebaseDatabase.getInstance().getReference().child("users").child(mCurrentUser.getUid());
        final String messageValue = editmessage.getText().toString().trim();

        if (!TextUtils.isEmpty(messageValue)) {
            final DatabaseReference newPost = mDatabase.push();
            mDatabaseUser.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    newPost.child("content").setValue(messageValue);
                    newPost.child("username").setValue(dataSnapshot.child("Name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                        }
                    });
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
mMessagelist.scrollToPosition(mMessagelist.getAdapter().getItemCount());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        FirebaseRecyclerAdapter<Message, MessageViewHolder> FBRA = new FirebaseRecyclerAdapter<Message, MessageViewHolder>(
                Message.class,
                R.layout.singlemessagelayout,
                MessageViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(MessageViewHolder viewHolder, Message model, int position) {
                viewHolder.setContent(model.getContent());
                viewHolder.setUsername(model.getUsername());
            }
        };
        mMessagelist.setAdapter(FBRA);
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setContent(String content) {
            TextView message_content = (TextView) mView.findViewById(R.id.messageText);
            message_content.setText(content);
        }
        public void setUsername(String username){
            TextView username_content = (TextView) mView.findViewById(R.id.username);
            username_content.setText(username);
        }
    }
}
