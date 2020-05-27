package be.ucll.IPminorPE.dto;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class TaskDTO {
	@NotEmpty
	private String title;
	@NotEmpty
	private LocalDateTime dueDate;
	private int id;
	@NotEmpty
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
}
