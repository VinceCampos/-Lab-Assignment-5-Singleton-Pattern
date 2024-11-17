public class HelpDeskStation {
    private static class HelpDeskHolder {
        private static final HelpDeskStation INSTANCE = new HelpDeskStation();
    }

    private int queueNumber = 1;

    private HelpDeskStation() {
    }

    public static HelpDeskStation getInstance() {
        return HelpDeskHolder.INSTANCE;
    }

    public synchronized void currentQueueNumber() {
        System.out.println("Current Queue Number: " + queueNumber);
    }

    public synchronized void handleNextCustomer(String helpDesk) {
        System.out.println(helpDesk + " is handling customer number: " + queueNumber);
        queueNumber++;
    }

    public synchronized void resetQueueNumber(int newQueueNumber) {
        if (newQueueNumber < 1) {
            throw new IllegalArgumentException("Queue number must be greater than 0");
        }
        queueNumber = newQueueNumber;
        System.out.println("Queue number reset to: " + queueNumber);
    }
}