package com.sustainedu.backend.repository;

import com.sustainedu.backend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByTitleContainingIgnoreCaseOrTopicContainingIgnoreCase(String title, String topic);

}
