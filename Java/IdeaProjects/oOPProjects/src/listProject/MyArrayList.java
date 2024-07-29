package listProject;

import java.util.Objects;

public class MyArrayList {

    private int size = 0;
    private String[] container = new String[4];

    public boolean isEmpty() {
        return true;
    }

    public void add(String element) {
        this.container[size++] = element;
    }
    public int size(){
        return this.size;
    }
    public String[] getContainer(){
        return this.container;
    }
    public String getIndexAt(int index) {
        return this.container[index];
    }

    public void remove(int index) {
        for(int i = 0;; i++){
            try{
                if(container[i].equalsIgnoreCase(container[index])){
                    size--;
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException errorValue) {throw new ArrayIndexOutOfBoundsException("out of bounds");}
        }
    }
    public void remove(String element){
        for(int i=0; true; i++){
            try{
                if(element.equalsIgnoreCase(container[i])){
                    container[i] = container[i + 1];
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException error){throw new ArrayIndexOutOfBoundsException("element not found.");}
        }
    }
}
