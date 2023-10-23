package sample.entity;

public enum Role {
	ROLE_ADMIN("ADMIN"), 
	ROLE_USER("USER");
	
	String role;
	
	private Role(String role) {
		this.role = role;
	}
}
