package com.example.myapplication.todolist;


import com.example.myapplication.todolist.beans.Note;

public interface NoteOperator {

    void deleteNote(Note note);

    void updateNote(Note note);
}
