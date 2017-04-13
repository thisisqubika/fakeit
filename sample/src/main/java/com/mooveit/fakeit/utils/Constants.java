package com.mooveit.fakeit.utils;

import java.util.Locale;

public class Constants {

    public enum FakeitLocale {
        CA("ca"),
        DE("de"),
        EN("en"),
        ES("es"),
        FA("fa"),
        FI("fi-FI"),
        FR("fr"),
        HE("he"),
        ID("id"),
        IT("it"),
        JA("ja"),
        KO("ko"),
        NB("nb-NO"),
        NL("nl"),
        PL("pl"),
        PT("pt"),
        RU("ru"),
        SK("sk"),
        SV("sv"),
        TR("tr"),
        UK("uk"),
        VI("vi"),
        ZH("zh-CN");

        private Locale locale;

        FakeitLocale(String locale) {
            switch (locale) {
                case ("fi-FI"):
                    this.locale = new Locale("fi", "FI");
                    break;
                case ("zh-CN"):
                    this.locale = new Locale("zh", "CN");
                    break;
                case ("nb-NO"):
                    this.locale = new Locale("nb", "NO");
                    break;
                default:
                    this.locale = new Locale(locale);
                    break;
            }
        }

        public Locale locale() {
            return locale;
        }

    }
}
