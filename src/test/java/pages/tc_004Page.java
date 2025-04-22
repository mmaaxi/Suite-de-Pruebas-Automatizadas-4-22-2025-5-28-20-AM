package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_004Page {

    WebDriver driver;
    By exportButton = By.id("exportButton");
    By accumulatedAmountColumn = By.xpath("//th[contains(text(), 'Monto acumulado Folio Reserva 5401')]");
    By amountCells = By.xpath("//td[@class='amountCell']");
    By accumulatedAmountCells = By.xpath("//td[@class='accumulatedAmountCell']");

    public tc_004Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToReportPage() {
        driver.get("http://example.com/reportpage"); // Adjust the URL as necessary
    }

    public void clickExportButton() {
        driver.findElement(exportButton).click();
    }

    public boolean isAccumulatedAmountColumnPresent() {
        return driver.findElements(accumulatedAmountColumn).size() > 0;
    }

    public boolean isAccumulatedAmountSumCorrect() {
        // Add logic to compute actual sums and verify against the expected results
        // This is a placeholder for computation
        for (int i = 1; i < driver.findElements(amountCells).size(); i++) {
            double previousAmount = Double.parseDouble(driver.findElements(amountCells).get(i - 1).getText());
            double currentAmount = Double.parseDouble(driver.findElements(amountCells).get(i).getText());
            double accumulatedAmount = Double.parseDouble(driver.findElements(accumulatedAmountCells).get(i).getText());

            if (accumulatedAmount != previousAmount + currentAmount) {
                return false;
            }
        }
        return true;
    }
}