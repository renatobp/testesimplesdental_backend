package br.com.testesimplesdental.testesimplesdental.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Cargo {

    @JsonProperty("Desenvolvedor")
    DESENVOLVEDOR("Desenvolvedor"), @JsonProperty("Designer")
    DESIGNER("Designer"), @JsonProperty("Suporte")
    SUPORTE("Suporte"), @JsonProperty("Tester")
    TESTER("Tester");

    private String cargo;

    private Cargo(String cargo) {
	this.setCargo(cargo);
    }

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	this.cargo = cargo;
    }
}
