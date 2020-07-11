import java.io.ByteArrayOutputStream;

public class PrintOutputStreamRunnable implements Runnable {

    private final ByteArrayOutputStream outputStream;
    private boolean isRunning;

    public PrintOutputStreamRunnable(ByteArrayOutputStream outputStream) {
        this.outputStream = outputStream;
        this.isRunning = true;
    }

    @Override
    public void run() {

        try {
            String result = "";
            while (isRunning) {
                if (!result.equals(outputStream.toString())) {
                    result = outputStream.toString();
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
