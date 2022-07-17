package br.com.compass.avaliacao.entities.enuntypes;

public enum SexTypeEnun {
    FEMININO("feminino"),
    MASCULINO("masculino");

    private String sexType;
    SexTypeEnun(String polliticalOfficeType){
        this.sexType = polliticalOfficeType;
    }
    public String getSexType(){
        return sexType;
    }
}
