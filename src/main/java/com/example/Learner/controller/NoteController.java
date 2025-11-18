package com.example.Learner.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Learner.model.Notes;
import com.example.Learner.model.User;
import com.example.Learner.repository.NoteRepository;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

	private final NoteRepository noteRepository;

	public NoteController(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@PostMapping
	public Notes createNotes(@RequestBody Notes notes) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		notes.setUserId(user.getId());
		return noteRepository.save(notes);
	}

	@GetMapping
	public List<Notes> getMyNotes() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return noteRepository.findByUserId(user.getId());
	}

	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable String id) {
		noteRepository.deleteById(id);
	}
}
