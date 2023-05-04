
public class LastN {

    private final int nToKeep;
    ArrayQueue<String> stringQueue;

    // constructor for LastN

    public LastN(int nToKeep) {
        this.nToKeep = nToKeep;
        stringQueue = new ArrayQueue<>(nToKeep);
    }

    // keep() method
    // takes string as argument
    // and adds that string argument to stringQueue

    public void keep(String s) {

        if (stringQueue.size() >= nToKeep) {
            stringQueue.remove();
            stringQueue.add(s);
        } else
            stringQueue.add(s);
    }


    // getLastN() method
    // adds the last added string in stringQueue to array
    // if stringQueue is empty, just return array
    public String[] getLastN() {
        String[] array = new String[stringQueue.size()];
        for (int i = 0; i < nToKeep; i++) {
            if (stringQueue.isEmpty())
                return array;
            array[i] = stringQueue.remove();
        }

        return array;
    }


    // This is main function is not required
    // It's just for the test in this program only
    // For the lab work, this program should not contain main()

    public static void main(String[] args) {

        LastN ln = new LastN(4);
        ln.keep("four");
        ln.keep("five");
        ln.keep("six");
        String[] last = ln.getLastN();

        int index = 0;
        for(String s : last)
            System.out.printf("last[%d] = %s%n", index++, s);
        System.out.println("There is " + last.length + " strings to keep");
    }
}



