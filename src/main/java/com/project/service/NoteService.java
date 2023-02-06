package com.project.service;

import com.project.entity.Note;
import com.project.entity.User;
import com.project.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public void save(User currentUser, String text) {
        var note = new Note(text, currentUser);
        currentUser.addNote(note);
        noteRepository.save(note);
    }
}
