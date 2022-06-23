package com.example.demo.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
//Използваме този потребител само докато е отворена сесията на
// логнат потребител и тук пазим потребителя който се е логнал
// Пазим логнатия потребител за сега така после ще го променим
    private String name;
    private boolean loggedIn;

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isAnonymous(){
        return !isLoggedIn();
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public void clear(){
        loggedIn = false;
        name = null;
    }
}
