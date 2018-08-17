package com.superfast.messages;

/**
 * Created by waltersanchez on 8/17/18.
 */
public class PrintMessage {
    private String name;
    private String url;
    private String adm;

    public PrintMessage(String name, String url, String adm) {
        this.name = name;
        this.url = url;
        this.adm = adm;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getAdm() {
        return adm;
    }
}
