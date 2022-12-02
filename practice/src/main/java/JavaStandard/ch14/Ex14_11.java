package JavaStandard.ch14;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

class Student3 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    Student3(String name, boolean isMale, int hak, int ban, int score) {
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
        return String.format("[%s, %s, %d %d, %3d]", name, isMale, hak, ban, score);
    }

    enum Level {
        HIGH, MID, LOW
    }
}

public class Ex14_11 {
    public static void main(String[] args) {
        Student3[] stuArr = {
                new Student3("a", true, 1, 1, 300),
                new Student3("b", false, 1, 1, 250),
                new Student3("c", true, 1, 1, 200),
                new Student3("d", false, 1, 2, 150),
                new Student3("e", true, 1, 2, 100),
                new Student3("f", false, 1, 2, 50),
                new Student3("g", false, 1, 3, 100),
                new Student3("h", false, 1, 3, 150),
                new Student3("i", true, 1, 3, 200),
                new Student3("j", true, 2, 1, 300),
                new Student3("k", false, 2, 1, 250),
                new Student3("l", true, 2, 1, 200),
                new Student3("m", false, 2, 2, 150),
                new Student3("n", true, 2, 2, 100),
                new Student3("o", false, 2, 2, 50),
                new Student3("p", false, 2, 3, 100),
                new Student3("q", false, 2, 3, 150),
                new Student3("r", true, 2, 3, 200)
        };

        Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student3::getBan));

        for (List<Student3> ban : stuByBan.values()) {
            for (Student3 s : ban) {
                System.out.println(s);
            }
        }

        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) {
                        return Student3.Level.HIGH;
                    } else if (s.getScore() >= 100) {
                        return Student3.Level.MID;
                    } else {
                        return Student3.Level.LOW;
                    }
                }));

        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student3.Level key : keySet) {
            System.out.println("[" + key + "]");

            for (Student3 s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) {
                        return Student3.Level.HIGH;
                    } else if (s.getScore() >= 100) {
                        return Student3.Level.MID;
                    } else {
                        return Student3.Level.LOW;
                    }
                }, counting()));
        for (Student3.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d��, ", key, stuCntByLevel.get(key));
        }
        System.out.println();
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan)
                        ));

        for (Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
            for (List<Student3> ban : hak.values()) {
                System.out.println();
                for (Student3 s : ban) {
                    System.out.println(s);
                }
            }
        }

        Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(Student3::getScore))
                                                , Optional::get
                                        )
                                )
                        ));

        for (Map<Integer, Student3> ban : topStuByHakAndBan.values()) {
            for (Student3 s : ban.values()) {
                System.out.println(s);
            }
        }

        Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s -> {
                            if (s.getScore() >= 200) {
                                return Student3.Level.HIGH;
                            } else if (s.getScore() >= 100) {
                                return Student3.Level.MID;
                            } else {
                                return Student3.Level.LOW;
                            }
                        }, toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }
    }
}
