package JavaStandard.ch14;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName() {
        return name;
    }

    boolean isMale() {
        return isMale;
    }

    int getHak() {
        return hak;
    }

    int getBan() {
        return ban;
    }

    int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d %d, %3d]",
                name, isMale, hak, ban, score);
    }

    enum Level {HIGH, MID, LOW}
}

public class Ex14_10 {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("a", true, 1, 1, 300),
                new Student2("b", false, 1, 1, 250),
                new Student2("c", true, 1, 1, 200),
                new Student2("d", false, 1, 2, 150),
                new Student2("e", true, 1, 2, 100),
                new Student2("f", false, 1, 2, 50),
                new Student2("g", false, 1, 3, 100),
                new Student2("h", false, 1, 3, 150),
                new Student2("i", true, 1, 3, 200),
                new Student2("j", true, 2, 1, 300),
                new Student2("k", false, 2, 1, 250),
                new Student2("l", true, 2, 1, 200),
                new Student2("m", false, 2, 2, 150),
                new Student2("n", true, 2, 2, 100),
                new Student2("o", false, 2, 2, 50),
                new Student2("p", false, 2, 3, 100),
                new Student2("q", false, 2, 3, 150),
                new Student2("r", true, 2, 3, 200)
        };

        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for (Student2 s : maleStudent) {
            System.out.println(s);
        }
        for (Student2 s : femaleStudent) {
            System.out.println(s);
        }

        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, counting()));

        System.out.println(stuNumBySex.get(true));
        System.out.println(stuNumBySex.get(false));

        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        maxBy(comparingInt(Student2::getScore))
                ));
        System.out.println(topScoreBySex.get(true));
        System.out.println(topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student2::getScore)), Optional::get
                        )
                ));

        System.out.println(topScoreBySex2.get(true));
        System.out.println(topScoreBySex2.get(false));

        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(Student2::isMale,
                        partitioningBy(s -> s.getScore() <= 100))
                );
        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        for (Student2 s : failedMaleStu) {
            System.out.println(s);
        }
        for (Student2 s : failedFemaleStu) {
            System.out.println(s);
        }
    }
}
