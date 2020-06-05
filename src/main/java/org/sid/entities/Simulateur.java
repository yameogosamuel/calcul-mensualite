package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Simulateur {
	private double montant;
	private int duree;
	private double taux;
	private double mensualite;

}
