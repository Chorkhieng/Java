public class ArrayUtilsExtra{


    public static boolean anyOf(int a[], int value){
        for(int i = 0; i < a.length; i++){
            if(a[i] == value){
                return true;
            }
        }
        return false;
    }

    public static boolean anyOf(int a[], int lo, int hi, int value){
        for(int j=lo; j<hi; j++){
            if(a[j] == value){
                return true;
            }
        }
        return false;
    }

    public static boolean allOf(int a[], int value){
        for(int i=0; i<a.length; i++){
            if(a[i]!=value){
                return false;
            };

        }
        return true;
    }

    public static boolean allOf(int a[], int lo, int hi, int value){
        for(int j=lo; j<hi; j++){
            if(a[j]!=value){
                return false;
            }
        }
        return true;
    }

    public static boolean noneOf(int a[], int value){
        for(int i=0; i<a.length; i++){
            if(a[i]==value){
                return false;
            }
        }
        return true;
    }

    public static boolean noneOf(int a[], int lo, int hi, int value){
        for(int j=lo; j<hi; j++){
            if(a[j]==value){
                return false;
            }
        }
        return true;
    }

}