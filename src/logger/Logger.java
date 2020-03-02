package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Geek8080
 */
public class Logger {

    /**
     * @param args the command line arguments
     */
    public static int ERROR;
    public static int WARNING;
    public static int INFO;
    public int status = 3;

    private String fileName;
    private File file;

    static {
        ERROR = 1;
        WARNING = 2;
        INFO = 3;
    }

    Logger logger = null;

    private Logger(int status) throws IOException {
        if (logger == null || this.status != status) {
            switch (status) {
                case 1:
                    fileName = "error.log";
                    break;
                case 2:
                    fileName = "warning.log";
                    break;
                case 3:
                    fileName = "info.log";
                    break;
            }
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            this.status = status;
        }
    }

    public static Logger getInstance(int status) {
        try {
            return new Logger(status);
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Couldn't Initialize logger " + ex.getMessage());
            return null;
        }
    }

    public boolean writeLog(String message) {
        try {
            FileWriter writer = new FileWriter(file, true);
            String str = getPreText() + message + "\n";
            writer.append(str);
            writer.close();
            System.out.println(str + "\n" + "Written Log(" + status + ").");
            return true;
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Couldn't write logs(" + status + ") " + ex.getMessage());
            System.out.println("Written Log(" + status + ").");
            return false;
        }
    }

    private static String getPreText() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | hh:mm:ss a");
        String dt = "[" + date.format(formatter) + "]";
        //LocalDate parsedDate = LocalDate.parse(text, formatter);
        return dt;
    }

}
