package com.betacom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "freni")
@Getter
@Setter
public class Freno {
	
	@Id
	@Column(name = "id_freno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFreno;
	
	@Column(name = "freno", nullable = false, unique = true)
	private String freno;

}
