package com.qaprosoft.carina.core.demo.gui.gsmarena.pages;

import com.qaprosoft.carina.core.demo.gui.gsmarena.components.compare.CondidateBlock;
import com.qaprosoft.carina.core.demo.gui.gsmarena.components.compare.ModelSpecs;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class CompareModelsPage extends AbstractPage
{
	@FindBy(xpath = "//div[contains(@class, 'candidate-search')]")
	private List<CondidateBlock> condidateBlocks;

	public CompareModelsPage(WebDriver driver)
	{
		super(driver);
	}

	public List<ModelSpecs> compareModels(String... models)
	{
		CondidateBlock condidateBlock;
		List<ModelSpecs> modelSpecs = new ArrayList<>();
		ModelSpecs modelSpec;
		for (int index = 0; index < models.length; index++)
		{
			modelSpec = new ModelSpecs();
			condidateBlock = condidateBlocks.get(index);
			condidateBlock.sendKeysToInputField(models[index]);
			condidateBlock.getFirstPhone();
			for (ModelSpecs.SpecType type : ModelSpecs.SpecType.values())
			{
				ExtendedWebElement spec = findExtendedWebElement(By.xpath(
						String.format("//tr[.//a[text()='%s']]//td[@class='nfo'][%d]", type.getType(), index + 1)));
				modelSpec.setToModelSpecsMap(type, spec.getText());
			}
			modelSpecs.add(modelSpec);
		}
		return modelSpecs;
	}
}
