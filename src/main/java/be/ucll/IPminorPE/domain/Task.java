package be.ucll.IPminorPE.domain;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Task {
	@NotNull
	@NotEmpty
	private String title;
	@NotNull
	@NotEmpty
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dueDate;
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	//private static int index;

	public Task(String title, LocalDateTime dueDate, String description) {
		//setId();
		this.title = title;
		this.dueDate = dueDate;
		this.description = description;
	}

	protected Task(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
				//++index;

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

	@Override
	public String toString() {
		return String.format(
				"Task[id=%d, title='%s', description='%s']",
				id, title, description);
	}
}
