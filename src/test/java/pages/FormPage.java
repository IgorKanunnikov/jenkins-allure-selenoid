package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Calendar;
import pages.components.ResultTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {

    Calendar calendar = new Calendar();
    ResultTable resultTable = new ResultTable();

    SelenideElement firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            email = $("[id=userEmail]"),
            phone = $("#userNumber"),
            dob = $("#dateOfBirthInput"),
            subj = $("#subjectsInput"),
            file = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submit = $("[id=submit]");

    @Step("Open page demoqa.com/automation-practice-form/")
    public FormPage openPage() {
        open("automation-practice-form/");
        return this;
    }

    @Step("Fill first name")
    public FormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Fill last name")
    public FormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Fill email")
    public FormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    @Step("Set gender")
    public FormPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Fill phone")
    public FormPage setPhone(String value) {
        phone.setValue(value);
        return this;
    }

    @Step("Fill date of birth")
    public FormPage setDateOfBirth(String day, String month, String year) {
        dob.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Set subjects")
    public FormPage setSubjects(String symbol, String value) {
        subj.sendKeys(symbol);
        $(byText(value)).click();
        return this;
    }

    @Step("Set hobbies")
    public FormPage setHobbies(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Upload file")
    public FormPage uploadFile(String value) {
        file.uploadFromClasspath(value);
        return this;
    }

    @Step("Fill address")
    public FormPage setAddress(String value) {
        address.setValue(value);
        return this;
    }

    @Step("Set state")
    public FormPage setState(String value) {
        state.setValue(value).pressEnter();
        return this;
    }

    @Step("Set city")
    public FormPage setCity(String value) {
        city.setValue(value).pressEnter();
        return this;
    }

    @Step("Click submit button")
    public FormPage clickSubmit() {
        submit.click();
        return this;
    }

    @Step("Check final table results")
    public FormPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }
}
