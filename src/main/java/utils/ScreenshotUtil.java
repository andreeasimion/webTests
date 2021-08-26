package utils;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.Serenity;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class ScreenshotUtil {

    public static void takeScreenshotOfThePage() throws IOException {
        File scrFile = ((TakesScreenshot) Serenity.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(String.format("src/test/resources/screenshot/actualImage.png")));
    }

    public static ImageComparisonState compareImages() {
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/test/resources/screenshot/register.png");
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("src/test/resources/screenshot/actualImage.png");
        File resultDestination = new File("src/test/resources/screenshot/result.png");

        ImageComparison imageComparison = new ImageComparison(expectedImage, actualImage, resultDestination);
        ImageComparisonResult imageComparisonResult = imageComparison.compareImages();
        BufferedImage resultImage = imageComparisonResult.getResult();
        ImageComparisonUtil.saveImage(resultDestination, resultImage);

        return imageComparisonResult.getImageComparisonState();
    }
}
