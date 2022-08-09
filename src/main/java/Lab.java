import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
@Getter
@Setter

public class Lab {


    public static void main(String[] args) {


        List<Integer> randomized = new ArrayList<Integer>();
        randomized.addAll(List.of(1,2,3,4,5,6));


        Collections.shuffle(randomized);

        System.out.println(randomized);

    }

}