package koval.web.myfitnesspal.pages;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public interface IMyInterface extends IAbstractTest {

  Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


  default void startDriver()
  {
      getDriver().get(R.CONFIG.get("url"));
  }


}
