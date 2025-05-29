package com.example.taskmanager.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private LocalDateTime dateCreated;
  private LocalDateTime dueDate;
  private LocalDateTime dateCompleted;
  private Boolean isCompleted = false;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  // getters and setters
  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public LocalDateTime getDateCompleted() {
    return dateCompleted;
  }

  public Boolean getIsCompleted() {
    return isCompleted;
  }

  public User getOwner() {
    return owner;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public void setDateCompleted(LocalDateTime dateCompleted) {
    this.dateCompleted = dateCompleted;
  }

  public void setIsCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public Task() {}

  public Task(
    String title,
    String description,
    LocalDateTime dueDate
  ) {
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.dateCreated = LocalDateTime.now();
  }
}
