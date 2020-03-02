# Logger
## Generate and Manage Logs

The Logger class contains method to write log files.
There may be 3 types of log:
1. ERROR
2. WARNING
3. INFO

To write log files you need an instance of this class. To get an instance use the static method getInstance(int status). call the writeLog(String message) to write log files.
You may take a look at the LoggerTester class to know how to use this.
