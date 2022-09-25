package com.demoqa.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
public class ModalTableComponent {
    private static final String TABLE_TITLE = "Thanks for submitting the form";

    public ModalTableComponent tableIsVisible() {
        $("#example-modal-sizes-title-lg").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text(TABLE_TITLE));
        return this;
    }
    public ModalTableComponent checkTableContent(String key, String value) {
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(Condition.text(value));
        return this;
    }
}
