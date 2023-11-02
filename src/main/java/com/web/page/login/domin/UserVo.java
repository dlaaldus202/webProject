package com.web.page.login.domin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class UserVo {
	@Id
	private String id;
	
	private String pwd;
	
	@Column(name = "frst_reg_dt")
	private String frstRegDt;
	
	@Column(name = "auth_id")
	private String authId;
	
	@Column(name = "lst_chg_dt")
	private String lstChgDt;
	
	private String name;
	
	private String gender;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	private String email;
	
	private String height;
	
	private String weight;
	
	private String brithday;
	
	private String state;
	
}
