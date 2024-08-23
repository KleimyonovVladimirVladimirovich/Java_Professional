package json;


import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Solution {
            //.setPrettyPrinting() переводит каждый раздел на новую строку, не баг а фича
            private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

            public static void main(String[] args) {
                Person person = new Person("Vladimir", 20, List.of("Moscow", "Saint-Petersburg", "Postov-on-Don"));
                String json = gson.toJson(person);
                System.out.println(json);

        Person person1 = new Person("Di", 14, List.of("China"));
        String json1 = gson.toJson(person1);
        System.out.println(json1);
    }
}

class Person {
    private String name;
    private Integer age;
    @SerializedName("History") //Заменяет название geoHistory
    private List<String> geoHistory = new ArrayList<>();

    public Person(String name, Integer age, List<String> geoHistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geoHistory;
    }
}
