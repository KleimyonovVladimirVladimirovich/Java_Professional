package kleimyonov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {
    //ОРИГ ОБЪЕКТ
    DataService dataService = new DataService();
    @Mock
    DataService MockDataService; //  <--- аналогичная запись с аннотацией (2)

    @Test
    void some() {
        //МОК ОБЪЕКТ
        //СОЗДАЕТ АБСОЛЮТНУЮ ВИРТУАЛЬНУЮ!! КОПИЮ КЛАССА ЧЕРЕЗ РЕФЛЕКСИЮ
        //ВСЕ КОНТРАКТЫ И МЕТОДЫ СОХРАНЯЮТСЯ
        DataService mock = Mockito.mock(DataService.class); //  <--- аналогичная запись (1)
        mock.getAllData();
        MockingDetails mockingDetails = Mockito.mockingDetails(mock);
        //Обертка над объектом mock
    }
    @Test
    public void testSnipped() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("SomeExampleData");
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.when(dsm.getAllData()).thenReturn(strings);

        Assertions.assertEquals(1, dsm.getAllData().size());
    }

    @Test
    void getSquare() {
        DataService mockito = Mockito.mock(DataService.class);
        Mockito.doReturn(10).when(mockito).getSquare(2);
        assertEquals(10, mockito.getSquare(2));

    }

    @Test
    void getSomeInnerClass() {
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.when(dsm.getSomeInnerClass()).thenReturn(new DataService.getInner());
    }

    @Test
    public void testEncode() {
        PasswordEncoder mock = Mockito.mock(PasswordEncoder.class);
        Mockito.when(mock.encode("a")).thenReturn("1");

        assertEquals(mock.encode("a"), "1");

    }
    @Test
    public void testIterator() {
        Iterator iter = Mockito.mock(Iterator.class);

        Mockito.when(iter.next()).thenReturn("Hellow").thenReturn("World");
        String result = iter.next() + " " + iter.next();
        System.out.println(result);
        assertEquals("Hellow World", result);
    }

}