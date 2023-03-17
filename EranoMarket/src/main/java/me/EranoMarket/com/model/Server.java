package me.EranoMarket.com.model;

public enum Server {
    NA("North America", "na"),
    EUW("Europe West", "euw"),
    EUNE("Europe Nordic & East", "eune"),
    BR("Brazil", "br"),
    JP("Japan", "jp"),
    KR("Korea", "kr"),
    LAN("Latin America North", "lan"),
    LAS("Latin America South", "las"),
    OCE("Oceania", "oce"),
    TR("Turkey", "tr"),
    RU("Russia", "ru");

    private final String name;
    private final String code;

    Server(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}