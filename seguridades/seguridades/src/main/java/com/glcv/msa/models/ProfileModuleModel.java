package com.glcv.msa.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "profile_module")
public class ProfileModuleModel {
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileModel profile;


	@ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleModel module;
	
	
	public ProfileModuleModel(ProfileModel profile, ModuleModel module) {
		super();
		this.profile = profile;
		this.module = module;
	}
	
}


