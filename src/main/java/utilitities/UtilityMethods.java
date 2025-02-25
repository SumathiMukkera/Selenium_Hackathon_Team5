package utilitities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class UtilityMethods {

	public void drpDwn(List<WebElement> options, String text) {
		for (WebElement optn : options) {
			if (optn.getText().equals(text)) {
				optn.click();
				break;
			}
		}
	}

	public void datePicker(String monthYear, String month, String year, String date, WebElement arrow,
			List<WebElement> allDates) {
		boolean flag = false;
		while (!flag) {
			int yearStartIndx = monthYear.length() - 4;
			String mon = monthYear.substring(0, yearStartIndx);
			String yr = monthYear.substring(yearStartIndx);
			if (mon.equals(month) && yr.equals(year)) {
				// Date Selection
				for (WebElement dat : allDates) {
					String dt = dat.getText();
					if (dt.equals(date)) {
						dat.click();
						flag = true;
						break;
					}
				}
			} else
				try {
					arrow.click();
				} catch (Exception e) {
					arrow.click();
				}

		}
	}

}
