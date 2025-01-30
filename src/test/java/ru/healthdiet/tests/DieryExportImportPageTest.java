package ru.healthdiet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.healthdiet.pages.DieryExportImportPage;
import ru.healthdiet.pages.FoodDiaryPage;

import java.io.File;

import static ru.healthdiet.utils.RandomUtils.getRandomNumber;


public class DieryExportImportPageTest {
    Authorization authorization=new Authorization();
    DieryExportImportPage diaryExportImport=new DieryExportImportPage();

    @BeforeEach
    public void beforeEach(){
        authorization.authorization();
        diaryExportImport.openPage();
    }

    @ValueSource(strings = {"txt", "json"})
    @ParameterizedTest(name="Успешно скачен {0} файл дневника питания с указаной датой")
    public void downloadFoodDiaryByDate(String fileType) throws Exception {
       String year="2025";
       diaryExportImport.setDate(14)
                .setMonth(0)
                .setYear(year)
                .selectFileType(fileType)
                .clickGenerate()
                .clickDownload();

        //diaryExportImport.verifysuccessDownload();
    }




}
