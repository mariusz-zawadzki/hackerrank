import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SpockTest extends Specification {
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }

    def "minimum of #a+#d and #b is #c"() {
        expect:
        Math.min(a + d, b) == c

        where:
        a | b | d  | c
        3 | 7 | 1  | 4
        5 | 4 | -2 | 3
        9 | 9 | -1 | 8
    }

    def "#person.name is a #sex.toLowerCase() person"() {
        expect:
        person.getSex() == sex

        where:
        person                    || sex
        new Person(name: "Fred")  || "Male"
        new Person(name: "Wilma") || "Female"
    }

    static class Person {
        String name

        String getSex() {
            name == "Fred" ? "Male" : "Female"
        }
    }
}