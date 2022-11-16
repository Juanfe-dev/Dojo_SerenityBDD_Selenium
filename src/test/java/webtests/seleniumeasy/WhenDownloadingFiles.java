package webtests.seleniumeasy;

import net.thucydides.core.configuration.SessionLocalTempDirectory;
import org.junit.jupiter.api.Test;
import webtests.seleniumeasy.pageobjects.DownloadPage;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

//@RunWith(SerenityRunner.class)
    class WhenDownloadingFiles {

    //@Managed
    //WebDriver driver;

    DownloadPage downloadPage;
    @Test
    public void weCanDownloadAFileToOurHardDrive() throws InterruptedException {
        downloadPage.open();
        downloadPage.downloadSampleFile();
        //We need a wait to download the file
        /*
        * This is not the best way to do this
        * because downloading the same file does not overwrite it
        * and creates a new version, and the assertion will be
        * made on the first file,
        * so, we have to create a temporary directory
        */
        //File downloadedFile = Paths.get("/Users/jgomez/Downloads/sample.png").toFile();
        File downloadedFile = SessionLocalTempDirectory
                .forTheCurrentSession()
                .resolve("sample.png")
                .toFile();

        //This is not a good practice
        //Thread.sleep(2000);
        await().atMost(15, SECONDS).until(downloadedFile::exists);
        assertThat(downloadedFile).exists();

        assertThat(downloadedFile.getName()).isEqualTo("sample.png");
    }
}
