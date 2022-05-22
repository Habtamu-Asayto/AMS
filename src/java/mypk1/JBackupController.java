package mypk1;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger; 
import javax.faces.bean.ViewScoped; 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List; 
import javax.faces.bean.ManagedBean; 

@ManagedBean
@ViewScoped
public class JBackupController {
    
  //Progress bar
  private AtomicInteger progressInteger = new AtomicInteger();
  private ExecutorService executorService;
  
  //Backup
    static String databaseName = "jimsdb";
    static String databasePassword = "jims";
    
    public JBackupController() {
    
    }
    
    public void executeCommand(String type) {
    
        File backupFilePath = new File(System.getProperty("user.home")
                + File.separator + "backup_" + databaseName);

        if (!backupFilePath.exists()) {
            File dir = backupFilePath;
            dir.mkdirs();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String backupFileName = "backup_" + databaseName + "_" + sdf.format(new Date()) + ".sql";

        List<String> commands = getPgComands(databaseName, backupFilePath, backupFileName, type);
        if (!commands.isEmpty()) {
            try {
                ProcessBuilder pb = new ProcessBuilder(commands);
                pb.environment().put("PGPASSWORD", databasePassword);

                Process process = pb.start();

                try (BufferedReader buf = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()))) {
                    String line = buf.readLine();
                    while (line != null) {
                        System.err.println(line);
                        line = buf.readLine();
                    }
                }

                process.waitFor();
                process.destroy();

                System.out.println("===> Success on " + type + " process.");
            } catch (IOException | InterruptedException ex) {
                System.out.println("Exception: " + ex);
            }
        } else {
            System.out.println("Error: Invalid params.");
        }
    }

    private List<String> getPgComands(String databaseName, File backupFilePath, String backupFileName, String type) {

        ArrayList<String> commands = new ArrayList<>();
        switch (type) {
            case "backup":
                commands.add("pg_dump");
                commands.add("-h"); //database server host
                commands.add("localhost");
                commands.add("-p"); //database server port number
                commands.add("5432");
                commands.add("-U"); //connect as specified database user
                commands.add("jims");
                commands.add("-F"); //output file format (custom, directory, tar, plain text (default))
                commands.add("c");
                commands.add("-b"); //include large objects in dump
                commands.add("-v"); //verbose mode
                commands.add("-f"); //output file or directory name
                commands.add(backupFilePath.getAbsolutePath() + File.separator + backupFileName);
                commands.add("-d"); //database name
                commands.add(databaseName);
                break;
            case "restore":
                commands.add("pg_restore");
                commands.add("-h");
                commands.add("localhost");
                commands.add("-p");
                commands.add("5432");
                commands.add("-U");
                commands.add("jims");
                commands.add("-d");
                commands.add(databaseName);
                commands.add("-v");
                commands.add(backupFilePath.getAbsolutePath() + File.separator + backupFileName);
                break;
            default:
                return Collections.EMPTY_LIST;
        }
        return commands;
    }
    
    //Progess Bar
  public void startTaskBackup() {
      executorService = Executors.newSingleThreadExecutor();
      executorService.execute(this::startLongTaskBackup);
  }

  private void startLongTaskBackup() {
      progressInteger.set(0);
      for (int i = 0; i < 100; i++) {
          progressInteger.getAndIncrement();
          //simulating long running task
          try {
              Thread.sleep(ThreadLocalRandom.current().nextInt(1, 100));
              executeCommand("backup");
              
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      executorService.shutdownNow();
      executorService = null;
  }
  
   public void startTaskRestore() {
      executorService = Executors.newSingleThreadExecutor();
      executorService.execute(this::startLongTaskRestore);
  }

  private void startLongTaskRestore() {
      progressInteger.set(0);
      for (int i = 0; i < 100; i++) {
          progressInteger.getAndIncrement();
          //simulating long running task
          try {
              Thread.sleep(ThreadLocalRandom.current().nextInt(1, 100));
              executeCommand("restore");
              
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      executorService.shutdownNow();
      executorService = null;
  }

  public int getProgress() {
      return progressInteger.get();
  }

  public String getResult() {
      return progressInteger.get() == 100 ? "task done" : "";
  }
}