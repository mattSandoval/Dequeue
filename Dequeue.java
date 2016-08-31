import java.util.*;
class Dequeue {
    public Scanner input = new Scanner(System.in);
    private int maxSize;
    private int[] array;
    private int front,rear;
    private int nItems;
    
    public Dequeue(int x) {
        maxSize = x;
        array = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public boolean isEmpty() {
        return (nItems == 0);
    }

    public void EnqueueFront(int x) {
        
        if(front == 0 ) {
            front = maxSize-1;            
        }

        int temp = array[front];
        array[front] = x;
        array[front-1] = temp;
        
        nItems++;
    }
    
    public void EnqueueBack(int x) {
        if(rear < 0 ) {
            rear = 0;
        }
        int temp = array[rear]; // temp = arr[0] = 15
        array[rear+1] = temp; // 
        array[rear] = x; // 
        
        nItems++;
    }

    public void DequeueFront() {
        int temp = array[front];
        array[front] = 0;
        array[front-1] = temp;
        nItems--;
    }
    public void DequeueBack() {
        int temp = array[rear];
        array[rear] = array[rear+1];
        array[rear+1] = 0;
        nItems--;
    }
    public void getLast()
    {
        if(isEmpty() || rear == -1){
            System.out.print("no data");
        }else{int x = array[rear];}
    }
    public void show()
    {
        for (int i = 0; i < maxSize ; i++) {
            System.out.print("\n array [" + i + "] = " + array[i] );
        }
    }
    public void options(){
        System.out.print("+--------------------------+ \n");
        System.out.print("| 2-ENDED QUEUE OPTIONS :  | \n");
        System.out.print("+--------------------------+ \n");
        System.out.print("| Option 1 | Enqueue front |\n");
        System.out.print("| Option 2 | Enqueue Back  |\n");
        System.out.print("| Option 3 | Dequeue front |\n");
        System.out.print("| Option 4 | Dequeue Back  |\n");
        System.out.print("| Option 5 | Show Set      |\n");
        System.out.print("+--------------------------+ \n");
        System.out.print("Enter choice : ");
        int x = input.nextInt();
        check(x);
    }
    public void alreadyFull(){
        System.out.print("+--------------------------+ \n");
        System.out.print("|  Error : Already Full !! | \n");
        System.out.print("+--------------------------+ \n");
    }
    public void check(int xS){
        try {
            if(xS == 1) {
                for(int i = 0; i < 3; i++) {System.out.print(" \n");}
                if(nItems == maxSize){
                    alreadyFull();
                    options();
                }else {
                    System.out.print("Enter value (int) : ");
                    int x = input.nextInt();
                    EnqueueFront(x);
                    System.out.print("+--------------------------+ \n");
                    System.out.print("|    EnqueueFront : Ok !!  | \n");
                    System.out.print("+--------------------------+ \n");
                    options();
                }

            }else if(xS == 2){
                for(int i = 0; i < 3; i++) {System.out.print(" \n");}
                if(nItems == maxSize) {
                    alreadyFull();
                    options();
                }else {
                    System.out.print("Enter value (int) : ");
                    int x = input.nextInt();
                    EnqueueBack(x);
                    System.out.print("+--------------------------+ \n");
                    System.out.print("|     EnqueueBack : Ok !   | \n");
                    System.out.print("+--------------------------+ \n");
                    options();
                }
                options();
            }else if(xS == 3){
                for(int i = 0; i < 3; i++) {System.out.print(" \n");}
                if (array[2] == 0) {
                    System.out.print("\n Empty head 0.00 , Insert data first.\n ");
                    options();
                }else {
                    DequeueFront();
                    System.out.print("+--------------------------+ \n");
                    System.out.print("|    DequeueFront : Ok !   | \n");
                    System.out.print("+--------------------------+ \n");
                    options();
                }
            }else if(xS == 4){
                for(int i = 0; i < 3; i++) {System.out.print(" \n");}
                if (array[0] == 0) {
                    System.out.print("\n Empty back 0.00 , Insert data first.\n ");
                    options();
                }else {
                    DequeueBack();
                    System.out.print("+--------------------------+ \n");
                    System.out.print("|    DequeueBack : Ok !    | \n");
                    System.out.print("+--------------------------+ \n");
                    options();
                }
            }else if(xS == 5){
                for(int i = 0; i < 3; i++) {System.out.print(" \n");}
                System.out.print("+--------------------------+ \n");
                System.out.print("|     Showing Array Set    | \n");
                System.out.print("+--------------------------+ \n");
                    if (isEmpty()) {
                        System.out.print("\n Empty Set 0.00 \n \n");
                    }else{
                        for (int i = maxSize-1; i > -1 ; i-- ) {
                            System.out.print("Array [" + i + "] => " + array[i] + "\n");
                        }
                    }
                options();
            }else{
                for(int i = 0; i < 3; i++) {System.out.print(" \n");}
                System.out.print("+--------------------------+ \n");
                System.out.print("|    Choose 1 - 5 only     | \n");
                System.out.print("+--------------------------+ \n");
                options();
            }

        }catch(InputMismatchException e){
            System.out.println("Input Mismatched !!!" + e.getMessage());
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Dequeue theQue = new Dequeue(3);
        theQue.options();
    }
}
