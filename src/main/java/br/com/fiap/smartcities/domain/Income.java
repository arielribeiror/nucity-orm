package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "income")
public class Income {

	@Id
	@SequenceGenerator(name = "income", sequenceName = "income_sq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "income")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 48)
	private String name;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	@JoinColumn(name = "category_id")
	@ManyToOne
	private Category category;

	@JoinColumn(name = "type_id")
	@ManyToOne
	private Type type;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_at")
	private Calendar startAt;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_at")
	private Calendar endAt;

	@Column(name = "value", length = 16)
	private Float value;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Calendar getStartAt() {
		return startAt;
	}

	public void setStartAt(Calendar startAt) {
		this.startAt = startAt;
	}

	public Calendar getEndAt() {
		return endAt;
	}

	public void setEndAt(Calendar endAt) {
		this.endAt = endAt;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

}
