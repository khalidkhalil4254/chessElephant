package chessAPP;

public class chessPieceDataModel {
    private String type;
    private int priority;
    private int positionX;
    private int positionY;
    int isLocated;

    public chessPieceDataModel(String type, int positionX, int positionY, int isLocated,int priority) {
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        this.isLocated = isLocated;
        this.priority=priority;
    }
    public chessPieceDataModel(){}

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int isLocated() {
        return isLocated;
    }

    public void setLocated(int located) {
        isLocated = located;
    }

}
