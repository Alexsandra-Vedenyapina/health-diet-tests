package ru.healthdiet.pages;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DieryExportImportPage {

    public DieryExportImportPage openPage() {
        open("https://health-diet.ru/diary/foodDiaryExport");
        return this;
    }

    public DieryExportImportPage selectMenuItem(String nameMenu) {
        $(".mzr-subNuvTopMenu .mzr-pointer").$(byText(nameMenu)).click();
        return this;
    }

    public DieryExportImportPage setDate(int indexDay) {
        ElementsCollection optionDay = $$(".t-inputdate-day option");
        optionDay.get(indexDay).click();
        return this;
    }

    public Integer getCountDays() {
        return $$(".t-inputdate-day option").size();
    }

    public DieryExportImportPage setMonth(int indexMonth) {
        ElementsCollection optionDay = $$(".t-inputdate-month option");
        optionDay.get(indexMonth).click();
        return this;
    }

    public DieryExportImportPage setYear(String year) {
        $(".t-inputdate-year [value='" + year + "']").click();
        return this;
    }

    public DieryExportImportPage selectFileType(String fileType) {
        $("input[type='radio'][value='" + fileType + "']").click();
        return this;
    }

    public DieryExportImportPage clickGenerate() {
        $(".uk-margin-top button").click();
        $("button.uk-button-success").shouldBe(visible);
        return this;
    }

//    public DieryExportImportPage clickDownload(String fileType) {
//        $(".uk-margin-top button").click();
//        com.codeborne.selenide.Configuration.timeout = 20000;
//        SelenideElement downloadLink = $("a[download*='"+fileType+"']");
//
//        if (!downloadLink.isDisplayed()) {
//            downloadLink.executeJavaScript("arguments[0].click();");
//        }
//        else {
//            downloadLink.shouldBe(visible).click();
//        }
//
//        File download= $("a[download*='"+fileType+"']")
//                .shouldBe(Condition.visible).download();
//        return this;
//    }

    public DieryExportImportPage clickDownload() throws Exception {

        $("button.uk-button-success").click();
        return this;
    }


    public DieryExportImportPage verifysuccessDownload(File downloadFile) throws Exception {
        try (InputStream is = new FileInputStream(downloadFile)) {
            byte[] bytes = is.readAllBytes();
            String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(fileAsString.contains("Дневник питания за 15.01.2025"));
            return this;
        }


    }
}
