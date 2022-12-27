package com.qaprosoft.carina.demo.db;

public enum DB {
    MYSQL("mysql"), PSQL("psql");

    private final String alias;

    DB(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }
}
