package br.com.compass.avaliacao.entities.enuntypes;

public enum PoliticalOfficeTypeEnun {
    VEREADOROR("vereador"),
    PREFEITO("prefeito"),
    DEPUTADO_ESTADUAL("deputado estadual"),
    DEPUTADO_FEDERAL("deputado estadual"),
    SENADOR("senador"),
    GOVERNADOR("governador"),
    PRESIDENTE("president"),
    NENHUM("nenhum");

    private String polliticalOfficeType;
    PoliticalOfficeTypeEnun(String polliticalOfficeType){
        this.polliticalOfficeType = polliticalOfficeType;
    }
    public String getPolliticalOfficeType (){
        return polliticalOfficeType;
    }

    @Override
    public String toString(){
        return polliticalOfficeType;
    }
}
