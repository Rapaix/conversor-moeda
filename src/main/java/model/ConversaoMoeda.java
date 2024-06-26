package model;

public enum ConversaoMoeda {
    ARS("Peso argentino", "ARS"),

    BOB("Boliviano", "BOB"),

    BRL("Real Brasileiro", "BRL"),

    CLP("Peso chileno", "CLP"),

    COP("Peso colombiano", "COP"),

    USD("Dólar americano", "USD");

    private String descricao;
    private String sigla;

    public String getSigla() {
        return sigla;
    }

    ConversaoMoeda(String descricao, String sigla) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}

