public class Mountain {

        /** @param array an array of positive integer values

         @param stop the last index to check
         Precondition: 0 <= stop < array.length
         @return true if for each j such that 0 <= j < stop, array[j] < array[j + 1] ;
         false otherwise
         */

        public static boolean isIncreasing(int[] array, int stop) {
            for(int i = 0; i < stop; i++) {
                if (!(array[i] < array[i + 1])) {
                    return false;
                }
            }
            return true;
        }

        /** @param array an array of positive integer values

         @param start the first index to check
         Precondition: 0 <= start < array.length - 1
         @return true if for each j such that start <= j < array.length - 1,
         array[j] > array[j + 1];
         false otherwise
         */

        public static boolean isDecreasing(int[] array, int start) {
            for(int i = start; i < array.length -1; i++) {
                if (!(array[i] > array[i + 1])) {
                    return false;
                }
            }
            return true;
        }

        public static int getPeakIndex(int[] array) {
            if(array[0] < array[1]) {
                for (int i = 0; i < array.length - 1; i++) {
                    if (!(array[i] < array[i + 1])) {
                        if(array[i] > array[i-1])
                        return i;
                    }
                }
            }
            else
                for (int i = 1; i < array.length - 1; i++) {
                    if (!(array[i] < array[i + 1])) {
                        if(array[i] > array[i-1])
                        return i;
                    }
                }
             return -1;
        }

        public static boolean isMountain(int[] array) {
            if(getPeakIndex(array) != -1){
                for(int i = 0; i < getPeakIndex(array); i++){
                    if(isIncreasing(array, getPeakIndex(array))) {
                        for (int j = getPeakIndex(array); j < array.length; j++) {
                            if (isDecreasing(array, getPeakIndex(array))) {
                                return true;
                            }
                        }
                    }

                }
            }
            return false;
        }

}
