package com.example.myapplication.todolist.ui;

import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.myapplication.todolist.NoteOperator;
import com.example.myapplication.R;
import com.example.myapplication.todolist.beans.Note;
import com.example.myapplication.todolist.beans.State;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH);

    private final NoteOperator operator;

    private CheckBox checkBox;
    private TextView titleText;
    private TextView contentText;
    private TextView dateText;
    private View deleteBtn;

    public NoteViewHolder(@NonNull View itemView, NoteOperator operator) {
        super(itemView);
        this.operator = operator;

        checkBox = itemView.findViewById(R.id.checkbox);
        titleText = itemView.findViewById(R.id.text_todo_title);
        contentText = itemView.findViewById(R.id.text_content);
        dateText = itemView.findViewById(R.id.text_date);
        deleteBtn = itemView.findViewById(R.id.btn_delete);
    }

    public void bind(final Note note) {
        contentText.setText(note.getContent());
        dateText.setText(SIMPLE_DATE_FORMAT.format(note.getDate()));
        titleText.setText("Todo" + Long.toString(note.id));
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(note.getState() == State.DONE);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                note.setState(isChecked ? State.DONE : State.TODO);
                operator.updateNote(note);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.deleteNote(note);
            }
        });

        if (note.getState() == State.DONE) {
            contentText.setTextColor(Color.GRAY);
            contentText.setPaintFlags(contentText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            contentText.setTextColor(Color.BLACK);
            contentText.setPaintFlags(contentText.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }

        itemView.setBackgroundColor(note.getPriority().color);
    }

}
