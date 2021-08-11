public class Piece
{
    private int colour;
    private int[] movement;

    public Piece()
    {
        int[] testString = {0, 1, 5, 6};
    }

    public void setMovement(int[] newMovement)
    {
       this.movement = newMovement;
    }

    public int[] getMovement()
    {
        return this.movement;
    }

    public void setColour(int newColour)
    {
        this.colour = newColour;
    }

    public int getColour()
    {
        return this.colour;
    }


}