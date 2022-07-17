package br.com.compass.avaliacao.entities.enuntypes;

public enum IdeologyTypeEnun {
    DIREITA ("direita"),
    CENTRO("centro"),
    ESQUERDA("esauerda");

    private String ideologyType;

    IdeologyTypeEnun(String ideologyType){
        this.ideologyType = ideologyType;
    }
    public String getIdeologyType(){
        return ideologyType;
    }
    @Override
    public String toString(){
        return ideologyType;
    }
}
