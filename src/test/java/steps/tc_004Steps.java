package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.tc_004Page;

public class tc_004Steps {

    WebDriver driver;
    tc_004Page reportPage = new tc_004Page(driver);

    @Given("^el usuario está en la página de reportes$")
    public void userOnReportPage() {
        reportPage.navigateToReportPage();
    }

    @When("^el usuario ejecuta la exportación del reporte$")
    public void userExportsReport() {
        reportPage.clickExportButton();
    }

    @Then("^se añade una columna 'Monto acumulado Folio Reserva 5401' a la derecha de 'Monto \\(reserva\\)'$")
    public void columnIsAdded() {
        Assert.assertTrue(reportPage.isAccumulatedAmountColumnPresent());
    }

    @And("^la columna muestra la suma correcta de los montos acumulados$")
    public void columnShowsCorrectSum() {
        Assert.assertTrue(reportPage.isAccumulatedAmountSumCorrect());
    }
}