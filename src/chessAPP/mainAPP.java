package chessAPP;
import java.util.*;

public class mainAPP {


    static boolean isArrayEmpty(String arr[][],int posX,int posY){
        boolean res=true;

        for (int x=0;x<arr.length;x++){  //for accessing the rows
            for(int y=0;y<arr[x].length;y++){  //for accessing the columns
                if(arr[x][y]!=""){
                    res=false;
                    break;
                }
            }
        }
        return res;
    }

    static boolean isPositionEmpty(String arr[][],int posX,int posY){
        if(arr[posX][posY]!=""){
            return false;
        }
        return true;
    }

    static ArrayList<String>getEmptyPositions(String arr[][]){
        ArrayList<String> emptyPositions=new ArrayList<>();

        for(int x=0;x< arr.length;x++){
            for(int y=0;y<arr[x].length;y++){
                if(arr[x][y]=="" || arr[x][y]==null){
                    emptyPositions.add("("+x+"x,"+y+"y),");
                }
            }
        }

        return emptyPositions;
    }

    static boolean isDuplicated(ArrayList<chessPieceDataModel>pieces){
        for (int h=0;h<pieces.size()-1;h++) {
            int x=pieces.get(h).getPositionX();
            int y=pieces.get(h).getPositionY();
            for (int i=1;i<pieces.size();i++) {
                if(x==pieces.get(i).getPositionX() && y==pieces.get(i).getPositionY()){
                    return true;
                }
            }
        }
        return false;
    }

    static String[][] getPiecesInPosition(ArrayList<chessPieceDataModel>pieces){
        String arr[][]=new String[8][8];
        for(int x=0;x<pieces.size();x++){
            arr[pieces.get(x).getPositionX()][pieces.get(x).getPositionY()]=pieces.get(x).getType();
        }
        for(int i=0;i< arr.length;i++){
            for(int h=0;h<arr[i].length;h++){
                if(arr[i][h]==null){
                    arr[i][h]="     ";
                }
            }
        }
        return arr;
    }

    static ArrayList<positionDataModel> searchUpRight(String arr[][],ArrayList<chessPieceDataModel>pieces){
        ArrayList<positionDataModel> position=new ArrayList<>();

        int index=(pieces.size()-1);  //position of the elephant.

        //initializing coordinates of the starting point of elephant for searching:-
        int x=pieces.get(index).getPositionX();
        int y=pieces.get(index).getPositionY();

        //get the maximum priority and capture the element:-
        int maximum=getMaximumPriority(pieces);
        chessPieceDataModel pie=new chessPieceDataModel();
        for (chessPieceDataModel p:pieces) {
            if(p.getPriority()==maximum){
                pie=p;//object is captured and ready to be used.
            }
        }
        //compare the captured element within the arr

        //move the elephant to search the upRight field:-
        while(x!=-1 && y!=8){
            if(pie.getType().equals(arr[x][y])){
                position.add(new positionDataModel(x,y));
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            else if(!arr[x][y].equals(pie.getType()) && !arr[x][y].equals("     ")){
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            x-=1;
            y+=1;
        }

        return position;
    }


    static ArrayList<positionDataModel> searchDownLeft(String arr[][],ArrayList<chessPieceDataModel>pieces){
        ArrayList<positionDataModel> position=new ArrayList<>();

        int index=(pieces.size())-1;  //position of the elephant.

        //initializing coordinates of the starting point of elephant for searching:-
        int x=pieces.get(index).getPositionX();
        int y=pieces.get(index).getPositionY();


        //get the maximum priority and capture the element:-
        int maximum=getMaximumPriority(pieces);
        chessPieceDataModel pie=new chessPieceDataModel();
        for (chessPieceDataModel p:pieces) {
            if(p.getPriority()==maximum){
                pie=p;//object is captured and ready to be used.
            }
        }
        //compare the captured element within the arr

        //move the elephant to search the upRight field:-
        while(x!=8 && y!=-1){
            if(pie.getType().equals(arr[x][y])){
                position.add(new positionDataModel(x,y));
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            else if(!arr[x][y].equals(pie.getType()) && !arr[x][y].equals("     ")){
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            x+=1;
            y-=1;
        }

        return position;
    }


    static ArrayList<positionDataModel> searchUpLeft(String arr[][],ArrayList<chessPieceDataModel>pieces){
        ArrayList<positionDataModel> position=new ArrayList<>();

        int index=(pieces.size())-1;  //position of the elephant.

        //initializing coordinates of the starting point of elephant for searching:-
        int x=pieces.get(index).getPositionX();
        int y=pieces.get(index).getPositionY();


        //get the maximum priority and capture the element:-
        int maximum=getMaximumPriority(pieces);
        chessPieceDataModel pie=new chessPieceDataModel();
        for (chessPieceDataModel p:pieces) {
            if(p.getPriority()==maximum){
                pie=p;//object is captured and ready to be used.
            }
        }
        //compare the captured element within the arr

        //move the elephant to search the upRight field:-
        while(x!=-1 && y!=-1){
            if(pie.getType().equals(arr[x][y])){
                position.add(new positionDataModel(x,y));
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            else if(!arr[x][y].equals(pie.getType()) && !arr[x][y].equals("     ")){
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            x-=1;
            y-=1;
        }

        return position;
    }


    static ArrayList<positionDataModel> searchDownRight(String arr[][],ArrayList<chessPieceDataModel>pieces){
        ArrayList<positionDataModel> position=new ArrayList<>();

        int index=(pieces.size())-1;  //position of the elephant.

        //initializing coordinates of the starting point of elephant for searching:-
        int x=pieces.get(index).getPositionX();
        int y=pieces.get(index).getPositionY();


        //get the maximum priority and capture the element:-
        int maximum=getMaximumPriority(pieces);
        chessPieceDataModel pie=new chessPieceDataModel();
        for (chessPieceDataModel p:pieces) {
            if(p.getPriority()==maximum){
                pie=p;//object is captured and ready to be used.
            }
        }
        //compare the captured element within the arr


        //move the elephant to search the upRight field:-
        while(x!=8 && y!=8){
            if(pie.getType().equals(arr[x][y])){
                position.add(new positionDataModel(x,y));
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            else if(!arr[x][y].equals(pie.getType()) && !arr[x][y].equals("     ")){
                arr[x][y]="elephant";
                arr[pieces.get(pieces.size()-1).getPositionX()][pieces.get(pieces.size()-1).getPositionY()]="\t";
            }
            x+=1;
            y+=1;
        }

        return position;
    }


    static ArrayList<positionDataModel> getAllEatablePositions(ArrayList<positionDataModel> upRight,ArrayList<positionDataModel> upLeft,ArrayList<positionDataModel> downRight,ArrayList<positionDataModel> downLeft){
        ArrayList<positionDataModel> arr=new ArrayList<>();
        for(positionDataModel p:upRight){
            arr.add(p);
        }
        for(positionDataModel q:upLeft){
            arr.add(q);
        }
        for(positionDataModel w:downRight){
            arr.add(w);
        }
        for(positionDataModel e:downLeft){
            arr.add(e);
        }
        return arr;
    }

    static void displayChessBoard(String arr[][]){
        for(int x=0;x<arr.length;x++){
            for(int y=0;y<arr[x].length;y++){
                System.out.print(arr[x][y]+",\t");
            }
            System.out.println("\n");
        }
    }

    static int getMaximumPriority(ArrayList<chessPieceDataModel> Pieces){
        int maximum=Pieces.get(0).getPriority();//assuming the maximum is the first one:-

        for(chessPieceDataModel p:Pieces){
            if(p.getPriority()>maximum){
                maximum=p.getPriority();
            }
        }

        return maximum;
    }

    static void displayArrayList(ArrayList<positionDataModel>arr){
        int x=0;
        for (positionDataModel p:arr){
            System.out.println("("+p.getX()+","+p.getY()+"),");
        }
    }

//
//    static void eatBestPiece(ArrayList<positionDataModel> allCombinedPositions,ArrayList<chessPieceDataModel> Pieces,String arr[][]){
//        int maximumPriority=getMaximumPriority(Pieces);
//        for(int x=0;x<Pieces.size();x++){
//            if(Pieces.get(x).getPositionX()==allCombinedPositions.get(x).getX() && Pieces.get(x).getPositionY()==allCombinedPositions.get(x).getY() && Pieces.get(x).getPriority()==maximumPriority){
//                arr[Pieces.get(x).getPositionX()][Pieces.get(x).getPositionY()]="elephant";
//            }
//        }
//    }


    public static void main(String[] args) {

        //declaring and initializing main variables ofr the app:-
        Scanner scan=new Scanner(System.in);
        ArrayList<chessPieceDataModel>pieces=new ArrayList<>();


        //reading how many pieces and position of each from the user with the name and of each one:-
        System.out.println("Enter number of pieces you want:");
        int numOfPieces=scan.nextInt();
        if(numOfPieces<=3){
            for(int x=0;x<numOfPieces;x++){
                System.out.println("is Located on the board or not?");
                int isLocated=scan.nextInt();
                if(isLocated==1){
                    System.out.println("Enter piece positionX (0-7):");
                    int positionX=scan.nextInt();
                    System.out.println("Enter piece positionY (0-7):");
                    int positionY=scan.nextInt();
                    if(positionX<=7 && positionY<=7){
                        System.out.println("Choose Piece Type From k->(king),q->(queen),e->(elephant),h->(horse),f->(fort):");
                        char name=scan.next().charAt(0);
                        switch (name){
                            case'k':
                                pieces.add(new chessPieceDataModel("king",positionX,positionY,isLocated,100));
                                break;
                            case'q':
                                pieces.add(new chessPieceDataModel("queen",positionX,positionY,isLocated,90));
                                break;
                            case'e':
                                pieces.add(new chessPieceDataModel("elephant",positionX,positionY,isLocated,50));
                                break;
                            case'f':
                                pieces.add(new chessPieceDataModel("fort",positionX,positionY,isLocated,80));
                                break;
                            case'h':
                                pieces.add(new chessPieceDataModel("horse",positionX,positionY,isLocated,60));
                                break;
                            case'i':
                                pieces.add(new chessPieceDataModel("infantry",positionX,positionY,isLocated,40));
                                break;
                            default:
                                System.out.println("Please choose a valid piece name!!");
                        }
                    }
                    else {
                        System.out.println("please enter a valid position in range (0-7) !!");
                        break;
                    }
                }
            }
        }


        boolean isDuplicated=isDuplicated(pieces);

        //if there is no duplication in positions in user inputs continue the app:-
        if(!isDuplicated){
            System.out.println("The maximum priority is:"+getMaximumPriority(pieces));
            //now we have the pieces we need to store their names within an array of strings to begin:
            //putting pieces in their positions specified by user on board:-
            String board[][]=getPiecesInPosition(pieces);
            //storing the values of allowed moved and displaying it to the user then take the best choice:-
            System.out.println("The following empty positions to place the elephant:-\n\n");
            System.out.println(Arrays.toString(getEmptyPositions(board).toArray())+"\n\n");
            displayChessBoard(board);
            System.out.println("Enter one position(x,y) from above:");
            int x=scan.nextInt();
            int y=scan.nextInt();

            if(board[x][y]==null || board[x][y]=="     "){
                pieces.add(new chessPieceDataModel("elephant",x,y,1,50));
                board[x][y]="elephant";
                System.out.println("\nBefore eating:-\n");
                displayChessBoard(board);
            }else {
                System.out.println("Please enter a valid position!!");
                System.exit(5);
            }


            ArrayList<positionDataModel> upRight=searchUpRight(board,pieces);
            displayArrayList(upRight);
            ArrayList<positionDataModel> upLeft=searchUpLeft(board,pieces);
            displayArrayList(upLeft);
            ArrayList<positionDataModel> downRight=searchDownRight(board,pieces);
            displayArrayList(downRight);
            ArrayList<positionDataModel> downLeft=searchDownLeft(board,pieces);
            displayArrayList(downLeft);
            ArrayList<positionDataModel> All=getAllEatablePositions(upRight,upLeft,downRight,downLeft);
            displayArrayList(All);


//            eatBestPiece(All,pieces,board);

            System.out.println("\nAfter eating:-\n\n");

            displayChessBoard(board);

        }
        else{
            System.out.println("Duplication in Positions of Pieces Occurred!");
        }

    }
}
