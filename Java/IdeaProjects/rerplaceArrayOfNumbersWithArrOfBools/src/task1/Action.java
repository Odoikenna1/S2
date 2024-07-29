package task1;

public class Action {

    public boolean[] conversion(int[] arr) {
        boolean[] values = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                values[i] = false;
            } else if(arr[i] % 2 != 0){
                values[i] = true;
            }
        }
        return values;
    }
}
