package TestTask;

public class Task2 {
    public static void main(String[] args) {
        Logic logic = new Logic(3);
        //Logic logic2 = new Logic(4);
        //Logic logic3 = new Logic(7);
        //Logic logic4 = new Logic(8);

    }
}

class Logic {
    private int numbOfTrans;
    private int numberOfBloc;
    private Obj[] a;
    private int[] tempLine;

    public Logic(int numberOfBloc) {
        this.numberOfBloc = numberOfBloc;
        tempLine = new int[numberOfBloc];
        for(int i=tempLine.length ; i>0 ; i--){
            tempLine[i-1] = i;
        }
        numbOfTrans = 0 ;
        a = new Obj[numberOfBloc];
        for (int i = numberOfBloc; i>0; i--){
            a[ a.length - i] = new Obj(i, numberOfBloc);
        }
        logic();
    }



    private void logic(){
        int tempNumOfOp = (int)Math.pow(2, numberOfBloc) - 1 ;

        int[] writeCodHere = new int[tempNumOfOp];
        for (int a = 0 ; a<tempLine.length ; a++) {

            for (int c = 0; c < writeCodHere.length; c++) {
                if (tempLine[a] == 1 && c%2 == 0){
                    writeCodHere[c] = 1 ;
                }
                if (tempLine[a] == 2 && c%2 == 1){
                    writeCodHere[c] = 2 ;
                }
                if (tempLine[a] == 3 && (c+1)%4 == 0){
                    writeCodHere[c] = 3 ;
                }
                if (tempLine[a] == 4 && (c+1)%8 == 0){
                    writeCodHere[c] = 4 ;
                }
                if (tempLine[a] == 5 && (c+1)%16 == 0){
                    writeCodHere[c] = 5 ;
                }
                if (tempLine[a] == 6 && (c+1)%32 == 0){
                    writeCodHere[c] = 6 ;
                }
                if (tempLine[a] == 7 && (c+1)%64 == 0){
                    writeCodHere[c] = 7 ;
                }
                if (tempLine[a] == 8 && (c+1)%128 == 0){
                    writeCodHere[c] = 8 ;
                }
            }
        }

        System.out.println();
        for (int c = 0; c < writeCodHere.length; c++){
            int temp = writeCodHere[c];
            for (int c2=0; c2<a.length; c2++){
                Obj tempO= a[c2];
                int tempOInt = tempO.getName();
                if (temp == tempOInt) {
                    tempO.setNew();
                    System.out.println();
                }
            }
        }
    }
}



class Obj{
    private int name;
    private int[] pos = new int[3];
    private int numberOfBloc;

    public Obj(int name, int numberOfBloc) {
        this.name = name;
        pos[0] = name;
        this.numberOfBloc = numberOfBloc;
    }

    public int getName() {
        return name;
    }

    private int getPos() {
        int temp = 0;
        for (int i  = 0 ; i<pos.length ; i++) {
            if (pos[i] == name) {
                temp = i;
            }
        }
        return temp;
    }

    public void setNew() {
        int temp = 0;
        if(numberOfBloc%2 == 1) {
            if (name % 2 == 1) {
                printBeg(getPos());
                temp = getPos() + 1;
                pos[getPos()] = 0;
                if (temp > 2) {
                    temp = 0;
                }
                pos[temp] = name;
                printFin(getPos());
            }
            // (4%2) = 0
            if (name % 2 == 0) {
                printBeg(getPos());
                temp = getPos() + 2;
                pos[getPos()] = 0;
                if (temp == 3) {
                    temp = 0;
                }
                if (temp == 4) {
                    temp = 1;
                }
                pos[temp] = name;
                printFin(getPos());
            }
        }

        if(numberOfBloc%2 == 0) {
            if (name % 2 == 1) {
                printBeg(getPos());
                temp = getPos() + 2;
                pos[getPos()] = 0;
                if (temp == 3) {
                    temp = 0;
                }
                if (temp == 4) {
                    temp = 1;
                }
                pos[temp] = name;
                printFin(getPos());
            }
            if (name % 2 == 0) {
                printBeg(getPos());
                temp = getPos() + 1;
                pos[getPos()] = 0;
                if (temp > 2) {
                    temp = 0;
                }
                pos[temp] = name;
                printFin(getPos());
            }
        }

    }

    private void printBeg(int getPos){
        if (getPos == 0) {
            System.out.print("#"+name+" slot_a ");
        }
        if (getPos == 1) {
            System.out.print("#"+name+" slot_c ");
        }
        if (getPos == 2) {
            System.out.print("#"+name+" slot_b ");
        }
    }

    private void printFin(int getPos2){
        if (getPos2 == 0) {
            System.out.print("-> slot_a");
        }
        if (getPos2 == 1) {
            System.out.print("-> slot_c");
        }
        if (getPos2 == 2) {
            System.out.print("-> slot_b");
        }
    }
}

