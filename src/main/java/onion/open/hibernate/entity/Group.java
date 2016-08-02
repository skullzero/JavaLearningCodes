package onion.open.hibernate.entity;
// Generated 2016-8-2 22:44:34 by Hibernate Tools 4.3.4.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group", catalog = "onion")
public class Group implements java.io.Serializable {

	private Integer id;
	private String groupName;
	//注意所有关于users的自动生成时没有使用泛型，会下面这个报错
	//org.hibernate.AnnotationException: Collection has neither generic type or OneToMany.targetEntity()
	private Set<User> users = new HashSet(0);

	public Group() {
	}

	public Group(String groupName, Set<User> users) {
		this.groupName = groupName;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "group_name", length = 45)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}