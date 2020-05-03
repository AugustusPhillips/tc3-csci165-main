
public class Map <Direction, Occupant>  {
    public Object[][] map_array;
    
    public Map(int x, int y){
        map_array = new Object[x][y];
    }
    public void add(int x, int y, Object a){
        map_array[x][y]= a;
    }
}