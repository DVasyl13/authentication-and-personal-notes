package com.project.service;

import com.project.entity.Note;
import com.project.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserService userService;

    public void save(String text) {
        var note = new Note(text, userService.getCurrentUser());
        userService.getCurrentUser().addNote(note);
        noteRepository.save(note);
    }
}
