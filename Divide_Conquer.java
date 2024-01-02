public class Divide_Conquer{
    public static void main(String args[]){
        // int arr[] = {5,4,3,-4,2,1};
        // int startIndex = 0;
        // int endIndex = arr.length-1;
        // mergRecursive(arr, startIndex, endIndex);
        // printArry(arr);

        // int arr[] = {3,1,2,0,4,5,6,7,8,9};
        // int startIndex = 0;
        // int endIndex = arr.length-1;
        // sorted_roted_array(arr, startIndex, endIndex, 0, 0);

        String str[] = {"sun", "earth", "mars", "mercury"};
        int startIndex = 0;
        int endIndex = str.length-1;
        String y[] = sortString(str, startIndex, endIndex);
        for( int i=0; i<y.length; i++){
            System.out.print(y[i] + " ");
        }

        int arr[] = {1,22, 333, 4, 1, 2};
        System.out.print(majority_Element(arr, 0, arr.length-1));

        
    }



    static int majority_Element(int arr[], int si, int ei){  // pending 
        if( si == ei){
            int x = arr[si];
            return x;
        }

        int mid = (si+ei)/2;
        int left = majority_Element(arr, si, mid);
        int right = majority_Element(arr, mid+1, ei);

        int leftCount = count(arr, left, si, ei);
        int rightCounr = count(arr, right, si, ei);

         return leftCount > rightCounr ? left : right;
    }

    static int count(int arr[], int left, int si, int ei){
        
        int c=0;
        for(int i=si; i<=ei; i++){
            if(arr[i] == left){
                c++;
            }
        }
        return c;
    }


    static String[] sortString(String str[], int startIndex, int endIndex){
        if( startIndex == endIndex){
            String temparr[] = {str[startIndex]};
            return temparr;
        }

        int midIndex = (startIndex+endIndex)/2;
        String str1[] = sortString(str, startIndex, midIndex);
        String str2[] = sortString(str, midIndex+1, endIndex);

        return mergString(str1, str2);
    }

    static String[] mergString(String str1[], String str2[]){
        String temp[] = new String[str1.length + str2.length];
        int k = 0; // for temp array
        int i = 0;  // for str1 array
        int j = 0; // for str2 array

        while (i< str1.length && j < str2.length) {
            if(isAplhabeticalOrder(str1[i], str2[j])){
                temp[k++] = str1[i++];
            }
            else{
                temp[k++] = str2[j++];
            }
        }

        while(i<str1.length){
            temp[k++] = str1[i++];
        }
        while(j<str2.length){
            temp[k++] = str2[j++];
        }


        return temp;
    
    }

    static boolean isAplhabeticalOrder(String a, String b){
        if(a.compareTo(b) < 0){
            return true;
        }
        return false;
    }


    // int arr[] = {4,5,6,7,0,1,2};
    static void sorted_roted_array(int arr[], int startIndex, int endIndex, int tar, int idx){
        if(startIndex > endIndex){
            return;
        }

        int mid = (startIndex+endIndex)/2;
        if(arr[mid] == tar){
            System.out.print(mid);
        }
        sorted_roted_array(arr, startIndex, mid-1, tar, idx);
        sorted_roted_array(arr, mid+1, endIndex, tar, idx);
        // if( arr[startIndex] <= arr[mid]){
        //     if( arr[startIndex] <= tar && tar <= arr[mid]){
        //         return sorted_roted_array(arr, startIndex, mid-1, tar, idx);
        //     }
        //     else{
        //         return sorted_roted_array(arr, mid+1, endIndex, tar, idx);
        //     }
        // }
        // else{
        //     if( arr[mid] <= tar && tar <= arr[endIndex]){
        //         return sorted_roted_array(arr, mid+1, endIndex, tar, idx);
        //     }
        //     else{
        //         return sorted_roted_array(arr, startIndex, mid-1, tar, idx);
        //     }
        // }
    }

    static void mergRecursive(int arr[], int startIndex, int endIndex){ // code for how recursion will divide and find the ans for array
        if( startIndex == endIndex ){
            return;
        }
        int midIndex = (startIndex + endIndex)/2;
        mergRecursive(arr, startIndex, midIndex);
        mergRecursive(arr, midIndex+1, endIndex);
        mergSort(arr, startIndex, midIndex, endIndex);
    }

    static void mergSort(int arr[], int startIndex, int midIndex, int endIndex){
        int temp[] = new int[endIndex-startIndex+1];
        int k = 0;
        int leftPart = startIndex;
        int rightPart = midIndex+1;

        while( leftPart <= midIndex && rightPart <= endIndex ){
            if( arr[leftPart] < arr[rightPart] ){
                temp[k] = arr[leftPart];
                leftPart++;
            }
            else{
                temp[k] = arr[rightPart];
                rightPart++;
            }
            k++;
        }

        while( leftPart <= midIndex ){
            temp[k++] = arr[leftPart++];
        }

        while (rightPart <= endIndex) {
            temp[k++] = arr[rightPart++];
        }

        for( k=0, leftPart=startIndex; k<temp.length; k++, leftPart++){
            arr[leftPart] = temp[k];
        }
    }

    static void printArry(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}