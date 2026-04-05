package com.sustainedu.backend.service;

import com.sustainedu.backend.entity.Lesson;
import com.sustainedu.backend.repository.LessonRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson createLesson(@NonNull Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(@NonNull Long id, Lesson lessonDetails) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found"));
        lesson.setTitle(lessonDetails.getTitle());
        lesson.setDescription(lessonDetails.getDescription());
        lesson.setDuration(lessonDetails.getDuration());
        lesson.setTopic(lessonDetails.getTopic());
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(@NonNull Long id) {
        lessonRepository.deleteById(id);
    }
}
