package bbstorespringmvc.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name="userBB")
public class User extends BaseEntity{
	
	public enum Role
	{
		USER("user"),MANAGER("manager"),ADMIN("admin");	
		
		private String name;
		Role(String name) {
			this.setName(name);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	@Enumerated(EnumType.STRING)
	private String userName;
	private Role role;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	} 
}
