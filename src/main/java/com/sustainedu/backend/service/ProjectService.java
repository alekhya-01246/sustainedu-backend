package com.sustainedu.backend.service;

import com.sustainedu.backend.entity.Project;
import com.sustainedu.backend.repository.ProjectRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(@NonNull Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(@NonNull Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setLevel(projectDetails.getLevel());
        return projectRepository.save(project);
    }

    public void deleteProject(@NonNull Long id) {
        projectRepository.deleteById(id);
    }
}
