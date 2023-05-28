package org.simplilearn.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoleId;
	private String Rolename;
	@ManyToMany //JoinTable is used for mentioning owning side of the relationship
	@JoinTable(name = "role_user",joinColumns = @JoinColumn(name="rid"),inverseJoinColumns = @JoinColumn(name="uid"))
	 	
	private Set<User> users=new HashSet<>();
	public Role() {
		//TODO Auto-generated constructor stub
	}
	public Role(int roleId, String rolename) {
		super();
		RoleId = roleId;
		Rolename = rolename;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	public String getRolename() {
		return Rolename;
	}
	public void setRolename(String rolename) {
		Rolename = rolename;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void  addUser(User user) { //HELPER METHODS TO ADD OR REMOVE USERS
		users.add(user);
	}
	public void removeUser(User user) {
		users.remove(user);
	}
	
}
