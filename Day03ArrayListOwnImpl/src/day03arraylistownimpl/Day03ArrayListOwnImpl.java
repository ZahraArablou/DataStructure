package day03arraylistownimpl;

public class Day03ArrayListOwnImpl {

    static public class CustomerArrayOfInts {

        private int[] data = new int[1];//only growa by doubling size, never shrinks
        private int size = 0; //how many items do you really have

        public int size() {
            return size;
        }
        void growStorage(){
            int[] newData=new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                newData[i]=data[i];
            }
            data=newData;
            
        }
        
        public void add(int value) {
            if(data.length==size){
                growStorage();
            }
            data[size]=value;
            size++;
            //my approach
//            if (size < data.length) {
//                data[data.length - 1] = value;
//                size++;
//            } else {
//                int[] data1 = new int[data.length * 2];
//                for (int i = 0; i < size; i++) {
//                    data1[i] = data[i];
//                }
//                data1[size] = value;
//                size++;
//                int len = data1.length;
//                data = new int[data1.length];
//                for (int i = 0; i < data.length; i++) {
//                    data[i] = data1[i];
//                }
//            }
        }

        public void deleteByIndex(int index) {
            if (index > size || index < 0) {
                throw new ArrayIndexOutOfBoundsException("index is larger than array size");
            }
            if (index == size - 1) {
                size--;
            } else {
                for (int i = index; i < size; i++) {
                    data[i] = data[i + 1];
                }
                size--;
            }
        }

        public boolean deleteByValue(int value) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (data[i] == value) {
                    index = i;
                }
            }
            if (index >= 0) {
                if (index == size - 1) {
                    size--;
                } else {
                    for (int i = index; i < size; i++) {
                        data[i] = data[i + 1];
                    }
                    size--;
                }
                return true;
            }
            return false;
        } // delete first value matching, true if value found, false otherwise

        public void insertValueAtIndex(int value, int index) {

            if (index > size || index < 0) {
                throw new ArrayIndexOutOfBoundsException("index is larger than array size");
            }
            if (size < data.length) {
                for (int i = size - 1; i >= index; i--) {
                    data[i + 1] = data[i];
                }

                data[index] = value;
                size++;

            } else {
                int[] data1 = new int[data.length * 2];
                for (int i = 0; i < size; i++) {
                    data1[i] = data[i];
                }
                data = new int[data1.length];
                for (int i = 0; i < data.length; i++) {
                    data[i] = data1[i];
                }
                for (int i = size - 1; i >= index; i--) {
                    data[i + 1] = data[i];
                }

                data[index] = value;
                size++;
            }

        }

        public void clear() {
            size = 0;
        }

        public int get(int index) {
            if (index > size || index < 0) {
                throw new ArrayIndexOutOfBoundsException("index is larger than array size");
            }

            return data[index];
        } // may throw IndexOutOfBoundsException
//	public int[] getSlice(int startIdx, int length) {
//            int[] f=new int[2];
//            return f; } // may throw IndexOutOfBoundsException

        public int[] getSlice(int startIdx, int length) {

            if (startIdx + length > size || startIdx < 0 || length < 0) {
                throw new ArrayIndexOutOfBoundsException("index is larger than array size");
            }
            int[] slice = new int[length];
            int n = 0;
            for (int i = startIdx; i < length + startIdx; i++) {
                slice[n] = data[i];
                n++;
            }
            return slice;
        } // may throw IndexOutOfBoundsException

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append("[");
            for (int i = 0; i < size; i++) {
                str.append(i == 0 ? "" : ",");
                str.append(data[i]);
            }
            str.append("]");
            return str.toString();
        } // returns String similar to: [3, 5, 6, -23]
    }

    public static void main(String[] args) {
        CustomerArrayOfInts caoi = new CustomerArrayOfInts();
        try {
            caoi.add(3);
            caoi.add(4);
            caoi.add(7);
            caoi.add(10);
            caoi.add(6);
            System.out.println(caoi.toString());
//            //  caoi.deleteByIndex(1);
//            //System.out.println(caoi.toString());
//            //caoi.deleteByIndex(0);
// if(caoi.deleteByValue(10))
            System.out.println(caoi.toString());
//            caoi.insertValueAtIndex(8, 1);
//            System.out.println(caoi.toString());
//            //caoi.insertValueAtIndex(6,12);
//            //System.out.println(caoi.toString());
//            System.out.println(caoi.get(2));
            int[] slice = new int[caoi.getSlice(1, 2).length];
            for (int i = 0; i < slice.length; i++) {
                slice[i] = caoi.getSlice(1, 2)[i];
            }
            for (int i = 0; i < slice.length; i++) {
                System.out.println(slice[i]);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }

}
