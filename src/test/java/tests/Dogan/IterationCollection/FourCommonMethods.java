package tests.Dogan.IterationCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FourCommonMethods {

    // reusable dynamic methods
    public List<String> DataList() {
        //List --- features
        // order is matter, first one goes first index
        // duplicate are allowed to do that.
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("John");
        names.add("Mike");
        names.add("Spike");
        names.add("Ike");
        names.add("Kemal");
        names.add("Tom");
//        System.out.println(names);
        return names;
    }


    public List<Integer> DataNumbers(){
        //create a empty array then fill out with add() methods
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        return numbers;

    }





    @Test
    public void ClassicForLoop() {

        System.out.println(DataList());
        System.out.println("Size " + DataList().size());
        System.out.println("First index "+ DataList().get(1));

        // create and array from another array.
        List<String> myDataNames = new ArrayList<>(DataList());
        System.out.println("My data set as an array " + myDataNames);


        for (int i =0 ; i<myDataNames.size(); i++){
            System.out.println(myDataNames.get(i));
        }


    }


    @Test
    public void ForEachMEthod(){

        // lambada expression foreach loop
        List<String> data = new ArrayList<>(DataList());
        data.forEach(item -> System.out.println(item));

        List<Integer> data2 = new ArrayList<>(DataNumbers());
        data2.forEach(x -> System.out.println(x));

    }

    @Test
    public void IteratorMethod(){

        // is used in database connection to get the data from tables
        Iterator<String> iterator = DataList().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Iterator<Integer> iterator2 = DataNumbers().iterator();
        while(iterator2.hasNext()){
            System.out.println(" Number : " + iterator2.next());
        }

    }

    @Test
    public void ForEachMethod2(){

        //
        List<String> data = new ArrayList<>(DataList());
        for (String item: data) {
            System.out.println(item);
        }

        for (Integer num : DataNumbers()){
            System.out.println(num);
        }
    }


}