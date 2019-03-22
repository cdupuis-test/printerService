package je.dvs.echo.printerservice.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Component
public class PdfGeneratorUtil {

    @Autowired
    ThymeleafEngine thymeleafEngine;

    String PDF_NAME = "test.pdf";
    private static final String UTF_8 = "UTF-8";


    public String createPdf(String json,  String templatename) throws Exception {

        PDF_NAME = UUID.randomUUID().toString();

        String processedHtml = thymeleafEngine.process(json,templatename);

        FileOutputStream os = null;
        String xHtml = convertToXhtml(processedHtml);

        final File outputFile = File.createTempFile(PDF_NAME, ".pdf");
        os = new FileOutputStream(outputFile);

        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "main", "resources", "templates")
                .toUri()
                .toURL()
                .toString();

            ITextRenderer  renderer = new ITextRenderer();
            renderer.setDocumentFromString(xHtml,baseUrl);
            renderer.layout();
            renderer.createPDF(os,true);
            JSONObject filepath = new JSONObject(json);
            filepath.put("FilePath", outputFile.getPath());

            System.out.println(outputFile.getPath());
            filepath.put("FileName", PDF_NAME);
            os.close();
            byte[] input_file = Files.readAllBytes(Paths.get(outputFile.getPath()));


            byte[] encodedBytes = Base64.getEncoder().encode(input_file);

            filepath.remove("email_template");

            System.out.println(filepath);

            return new String(encodedBytes);
        }


    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }
}
