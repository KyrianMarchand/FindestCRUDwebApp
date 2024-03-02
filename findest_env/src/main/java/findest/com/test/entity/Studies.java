package findest.com.test.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;

/**
 * The persistent class for the Studies database table.
 * 
 */
@Entity
@Table(name = "Studies")
@NamedQueries({
		@NamedQuery(name = "Studies.findAll", query = "SELECT s FROM Studies s"),
		@NamedQuery(name = "Studies.findById", query = "SELECT s FROM Studies s WHERE s.id = :id")
})
public class Studies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "Studies_ID_GENERATOR", sequenceName = "Studies_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Studies_ID_GENERATOR")
	private Integer id;

	private String name;

	private LocalDate creationDate;

	public Studies() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Studies)) {
			return false;
		}
		Studies other = (Studies) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		if (creationDate == null) {
			return "data.entity.Studies[ id=" + id + " name=" + name + " creationDate=" + "]";
		}
		return "data.entity.Studies[ id=" + id + " name=" + name + " creationDate=" + creationDate + "]";
	}

}
