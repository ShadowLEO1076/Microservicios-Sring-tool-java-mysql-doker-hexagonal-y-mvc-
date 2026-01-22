package com.glcv.msa.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user1")  // "user" es palabra reservada en SQLServer
public class UserModel {
	public UserModel() {
		super();
	}

    

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, nullable = false, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    private String token;

    @Column(name = "state", nullable = false)
    private int state;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileModel profile;

    public UserModel(String name, String email, String password, String token, int state, ProfileModel profile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.token = token;
		this.state = state;
		this.profile = profile;
	}
}