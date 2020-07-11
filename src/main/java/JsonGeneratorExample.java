import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.ByteArrayOutputStream;

public class JsonGeneratorExample {
    public static void main(String[] args) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintOutputStreamRunnable runnable = new PrintOutputStreamRunnable(outputStream);

        Thread thread = new Thread(runnable);
        thread.start();

        JsonFactory factory = new JsonFactory();

        JsonGenerator generator = factory.createGenerator(outputStream, JsonEncoding.UTF8);

        generator.writeStartObject();

        generator.writeArrayFieldStart("cars");

        generator.writeStartObject();
        generator.writeStringField("make", "Mercedes");
        generator.writeStringField("model", "C300");
        generator.writeNumberField("doors", 4);
        generator.writeEndObject();
        generator.flush();  // Flush buffered content to the output stream
        Thread.sleep(1000);

        generator.writeStartObject();
        generator.writeStringField("make", "Ford");
        generator.writeStringField("model", "Focus");
        generator.writeNumberField("doors", 2);
        generator.writeEndObject();
        generator.flush();
        Thread.sleep(1000);

        generator.writeStartObject();
        generator.writeStringField("make", "Infiniti");
        generator.writeStringField("model", "G35");
        generator.writeNumberField("doors", 4);
        generator.writeEndObject();
        generator.flush();
        Thread.sleep(1000);

        generator.writeEndArray();

        generator.writeEndObject();

        generator.close();

        outputStream.close();

        runnable.stop();

    }

}
