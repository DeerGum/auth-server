package sample.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fs_user")
public class FsUser {
	@Id
	@Column(name = "user_id", length = 30)
	private String userId;
	
	@Setter
	@JsonIgnore
	@Column(name = "password", length = 120)
	private String password;
		
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20)
	private Role role;
	
	@CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
	
	@Builder
	public FsUser(String userId, String password, Role role) {
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
}
